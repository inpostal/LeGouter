package com.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@WebServlet("/member/memberData")
public class MemberDataServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 先處理編碼
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");
		
		// 從session抓是否有登入資訊
		HttpSession session = req.getSession();
		Integer memberId = (Integer) session.getAttribute("isLogin");
		
		MemberService service = new MemberService();
		
		// 檢查是否登入過
		if (memberId != null) {
			MemberVO memberVO = service.findByPk(memberId);
			req.setAttribute("memberName", memberVO.getMemberName());
			req.setAttribute("memberAcount", memberVO.getMemberAccount());
			req.setAttribute("memberPassword", memberVO.getMemberPassword());
			req.setAttribute("gender", memberVO.getMemberGender().equals('f') ? "女" : "男");
			req.setAttribute("memberPhone", memberVO.getMemberPhone());
			req.setAttribute("memberMail", memberVO.getMemberEmail());
			req.setAttribute("memberAddress", memberVO.getMemberAddress());
			req.setAttribute("memberBirthday", memberVO.getMemberBirthday().toString());
			req.setAttribute("memberRegisterDate", memberVO.getMemberRegistrationTime().toString());
			req.getRequestDispatcher("/front-end/member/MemberData.jsp").forward(req, resp);
		}else {
			// 沒有登入過被重導至登入頁面並記錄原本所在地
			session.setAttribute("location", req.getRequestURI());
			req.setAttribute("pleaseLogin", "請先登入");
			req.getRequestDispatcher("/front-end/member/Login.jsp").forward(req, resp);
		}
	}
}
