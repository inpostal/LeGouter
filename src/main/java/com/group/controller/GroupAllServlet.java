package com.group.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group.model.GroupProductDAO;
import com.group.model.GroupProductVO;

@WebServlet("/group/GroupAllServlet")
public class GroupAllServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/plan; charset=UTF-8");		
		resp.setContentType("application/json; charset=UTF-8"); //20230613 必須在resp.getWriter()之前設定好編碼。
		PrintWriter out = resp.getWriter();
		
		GroupProductDAO gdao = new GroupProductDAO();
		
		List<GroupProductVO> all = gdao.getAll();
		
//		for (GroupProductVO gvo : all) {
//			out.println(gvo);
//		}
		
		Gson gson = new Gson();
		String json = gson.toJson(all);
		out.println(json);
	}
}
