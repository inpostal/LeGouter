package com.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebServlet("/member/register")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 改編碼
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");

		// 印出訊息在系統上
		List<String> list = new ArrayList<>();
		Enumeration<String> names = req.getParameterNames();
		MemberVO inputMemberData = new MemberVO();
		// [name, account, password, gender, phone, email, city, district, address, birthday]
		while (names.hasMoreElements()) {
			String element = names.nextElement();
			list.add(req.getParameter(element));
			req.setAttribute(element, req.getParameter(element));
		}
		System.out.println("新增使用者: " + list);

		// 取得使用者輸入內容
		String inputName = req.getParameter("name");
		String inputAccount = req.getParameter("account");
		String inputPassword = req.getParameter("password");
		char gender = req.getParameter("gender").charAt(0);
		String inputPhone = req.getParameter("phone");
		String inputMail = req.getParameter("email");
		String inputAddress = req.getParameter("city") + req.getParameter("district") + req.getParameter("address");
		Date inputDate = Date.valueOf(req.getParameter("birthday"));

		// 驗證姓名輸入
		if (!isValidName(inputName)) {
			req.setAttribute("inputNameErrMsg", "請輸入中文英文數字(20字以內)");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}

		MemberService service = new MemberService();

		// 將前端資料包裝到vo裡面傳遞給service
		inputMemberData.setMemberClassify(0); // 一般會員
		inputMemberData.setMemberStatus(0); // 未停權
		inputMemberData.setMemberName(inputName);
		inputMemberData.setMemberAccount(inputAccount);
		inputMemberData.setMemberPassword(inputPassword);
		inputMemberData.setMemberGender(gender);
		inputMemberData.setMemberPhone(inputPhone);
		inputMemberData.setMemberEmail(inputMail);
		inputMemberData.setMemberAddress(inputAddress);
		inputMemberData.setMemberBirthday(inputDate);

		// 驗證帳號
		if (!isValidAccount(inputAccount)) {
			req.setAttribute("inputAccountErrMsg", "只能輸入英文數字(20字以內)");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}
		if (!service.isAcciuntAllow(inputMemberData)) {
			req.setAttribute("inputAccountErrMsg", "該帳號已被註冊");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}

		// 驗證密碼
		if (!isValidPassword(inputPassword)) {
			req.setAttribute("inputPasswordErrMsg", "請輸入純英文或數字(7-20字)");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}

		// 驗證手機號碼
		if (!isValidPhoneNumber(inputPhone)) {
			req.setAttribute("inputPhoneErrMsg", "請輸入十位數字電話號碼(Ex:09123456789)");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}

		// 信箱驗證
		if (!service.isMailAllow(inputMemberData)) {
			req.setAttribute("inputMailErrMsg", "該信箱已被註冊");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}

		// 驗證地址
		if (!isValidAddress(inputAddress)) {
			req.setAttribute("inputAddrErrMsg", "請輸入中文或數字(50字以內)");
			req.getRequestDispatcher("/front-end/member/Register.jsp").forward(req, resp);
			return;
		}
		
		service.register(inputMemberData);
		req.setAttribute("register", "註冊成功 請嘗試登入");
		req.getRequestDispatcher("/front-end/member/Login.jsp").forward(req, resp);
	}

	private boolean isValidName(String inputName) {
		String regex = "^[\\p{L}\\p{N}\\p{IsHan}]{1,20}$";
		return Pattern.matches(regex, inputName);
	}

	private boolean isValidAddress(String inputAddress) {
		String regex = "^[\\p{N}\\p{IsHan}]{1,50}$";
		return Pattern.matches(regex, inputAddress);
	}

	private boolean isValidPassword(String inputPassword) {
		String regex = "^[a-zA-Z0-9]{7,20}$";
		return Pattern.matches(regex, inputPassword);
	}

	private boolean isValidAccount(String inputAccount) {
		String regex = "^[a-zA-Z0-9]{1,20}$";
		return Pattern.matches(regex, inputAccount);
	}

	private boolean isValidPhoneNumber(String inputPhone) {
		String regex = "^09[0-9]{8}$";
		return Pattern.matches(regex, inputPhone);
	}
}
