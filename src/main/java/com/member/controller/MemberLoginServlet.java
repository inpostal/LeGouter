package com.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		MemberService service = new MemberService();
		Integer isLoginSuccess = service.login(username, password);
		// 檢查登入是否成功
		if (isLoginSuccess == null) {
			// 沒有成功回來原本的登入頁面
			req.setAttribute("errorMsgs", "帳號或密碼錯誤");
			req.getRequestDispatcher("/front-end/member/Login.jsp").forward(req, resp);
		} else {
			// 成功之後
			HttpSession session = req.getSession();
			// 設定會員ID至session當中
			session.setAttribute("isLogin", isLoginSuccess);
			
			// 檢查是否有來源網址
			String location = (String) session.getAttribute("location");
			if (location != null) {
				session.removeAttribute("location");
				resp.sendRedirect(location);
			} else {
				resp.sendRedirect("/CHA101_LeGouter/front-end/FrontIndex.jsp");
			}
		}
	}
}
