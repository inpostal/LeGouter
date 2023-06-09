package com.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebServlet("/member/memberDataEdit")
public class MemberDataEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理編碼
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		Integer memberId = (Integer) session.getAttribute("isLogin");
		
		MemberService service = new MemberService();
		MemberVO memberVO = service.findByPk(memberId);
		
		req.setAttribute("name", memberVO.getMemberName());
		req.setAttribute("password", memberVO.getMemberPassword());
		req.setAttribute("gender", memberVO.getMemberGender()=='f' ? "女" : "男");
		req.setAttribute("address", memberVO.getMemberAddress());
		req.setAttribute("phone", memberVO.getMemberPhone());
		
		req.getRequestDispatcher("/front-end/member/EditMemberData.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 處理編碼
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");

		// 取得請求參數
		Enumeration<String> names = req.getParameterNames();
		while (names.hasMoreElements()) {
			String element = names.nextElement();
			req.setAttribute(element, req.getParameter(element));
		}
		
		// 取得目前登入的使用者id編號
		HttpSession session = req.getSession();
		Integer memberId  = (Integer) session.getAttribute("isLogin");
		
		// 取得使用者輸入內容
		String inputName = req.getParameter("name");
		String inputPassword = req.getParameter("password");
		char gender = req.getParameter("gender").charAt(0);
		String inputPhone = req.getParameter("phone");
		String inputAddress = req.getParameter("city") + req.getParameter("district") + req.getParameter("address");

		MemberVO inputMemberData = new MemberVO();
		MemberService service = new MemberService();

		// 將前端資料包裝到vo裡面傳遞給service
		inputMemberData.setMemberClassify(0); // 一般會員
		inputMemberData.setMemberStatus(0); // 未停權
		inputMemberData.setMemberId(memberId);
		inputMemberData.setMemberName(inputName);
		inputMemberData.setMemberPassword(inputPassword);
		inputMemberData.setMemberGender(gender);
		inputMemberData.setMemberPhone(inputPhone);
		inputMemberData.setMemberAddress(inputAddress);

		// 驗證輸入
		// 驗證姓名輸入
		if (!Authorizations.isValidName(inputName)) {
			req.setAttribute("inputNameErrMsg", "請輸入中文英文數字(20字以內)");
			req.getRequestDispatcher("/front-end/member/EditMemberData.jsp").forward(req, resp);
			return;
		}

		// 驗證密碼
		if (!Authorizations.isValidPassword(inputPassword)) {
			req.setAttribute("inputPasswordErrMsg", "請輸入純英文或數字(7-20字)");
			req.getRequestDispatcher("/front-end/member/EditMemberData.jsp").forward(req, resp);
			return;
		}

		// 驗證手機號碼
		if (!Authorizations.isValidPhoneNumber(inputPhone)) {
			req.setAttribute("inputPhoneErrMsg", "請輸入十位數字電話號碼(Ex:09123456789)");
			req.getRequestDispatcher("/front-end/member/EditMemberData.jsp").forward(req, resp);
			return;
		}

		// 驗證地址
		if (!Authorizations.isValidAddress(inputAddress)) {
			req.setAttribute("inputAddrErrMsg", "請輸入中文或數字(50字以內)");
			req.getRequestDispatcher("/front-end/member/EditMemberData.jsp").forward(req, resp);
			return;
		}

		service.editMemberData(inputMemberData);
		req.setAttribute("MemberDataEdit", "修改成功");
		req.getRequestDispatcher("/member/memberData").forward(req, resp);
	}

}
