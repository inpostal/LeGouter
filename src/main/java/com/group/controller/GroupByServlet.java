package com.group.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.group.model.GroupProductDAO;
import com.group.model.GroupProductVO;

//20230612 小組coding。
@WebServlet("/group/GroupByServlet")
public class GroupByServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		BufferedReader reader = req.getReader(); //取得請求的字串IO，準備讀取JSON 字串流。	
		String jsonstring = reader.readLine(); //使用readLine()讀取整行的JSON字串。
		
		GroupProductVO productvo = new Gson().fromJson(jsonstring, GroupProductVO.class); //用Gson().fromJson(輸入JSON字串引數,並用反射帶入到VO物件中。)
		Integer groupProductId = productvo.getGroupProductId(); //從初始化完成的VO物件獲得ID數值。
				
//		String getId = req.getParameter("groupProductId"); //後來用JSON 字串輸入 所以不能用這樣。
//		Integer groupProductId = Integer.parseInt(getId); //轉型是parse，轉值是valueOf。 後來用JSON 字串輸入 所以不能用這樣。		
		GroupProductDAO dao = new GroupProductDAO(); //建立DAO物件以使用方法。
		GroupProductVO gvo = dao.findByPrimaryKey(groupProductId); //帶入請求的ID 查詢單筆資料，放入VO物件。
		
		String jsonout = new Gson().toJson(gvo); //將VO物件轉成JSON字串。
		out.println(jsonout); //輸出JSPN字串至前端。
	}

}
