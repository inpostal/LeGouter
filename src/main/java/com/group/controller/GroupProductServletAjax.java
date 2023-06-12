package com.group.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group.model.GroupProductDAO;
import com.group.model.GroupProductVO;

@WebServlet("/group/GroupProductServletAjax")
public class GroupProductServletAjax extends HttpServlet {

	private static final long serialVersionUID = 123456737473L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("application/josn; charset=utf-8");
		
		try {
			BufferedReader readjson = req.getReader();
			String line = readjson.readLine();
			GroupProductVO gvo = new Gson().fromJson(line, GroupProductVO.class);
			
			GroupProductDAO dao = new GroupProductDAO();
			dao.insert(gvo);

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
}
