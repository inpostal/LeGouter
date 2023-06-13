package com.cart.controller;

import com.cart.model.CartDetailDAO;
import com.dessert.model.CartDetailVO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: CartDetailByIDServlet
 * Description:
 *
 * @Author Charlie
 * @Create 2023/6/12 PM 03:02
 */

@WebServlet("/Cart/Detail")
public class CartDetailByIDServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        resp.setContentType("application/json;charset=UTF8");

        BufferedReader reader = req.getReader();
        String jsonString = reader.readLine();

        Gson gson = new Gson();
        CartDetailVO detailVO = gson.fromJson(jsonString, CartDetailVO.class);
        Integer dessertId1 = detailVO.getDessertId();
        Integer memId1 = detailVO.getMemId();

//        Integer dessertId = Integer.parseInt(req.getParameter("dessertId"));
//        Integer memIdDB = Integer.parseInt(req.getParameter("memId"));


        PrintWriter writer = resp.getWriter();
        CartDetailDAO dao = new CartDetailDAO();
        CartDetailVO cartDetailDB = dao.findByPrimaryKey(dessertId1, memId1);

        String json = gson.toJson(cartDetailDB);
        writer.print(json);


//        writer.print(cartDetailVO);

//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("application/json; charset=UTF-8");
//
//        System.out.println("Hi");
//
//        // 前端給的json string
//        BufferedReader reader = req.getReader();
//        // readline整個讀起來
//        String jsonString = reader.readLine();
//
//
//        // 要用VO把資料包裝起來
//        Gson gson = new Gson();
//        // 可以把jsonString轉成物件
//        System.out.println(jsonString);
//        EmpVO vo = gson.fromJson(jsonString, EmpVO.class);
//
//        Integer empId = vo.getEmpId();
//        System.out.println(empId);
//
//        EmpDAO dao = new EmpDAO();
//        EmpVO voInDB = dao.findByPrimaryKey(empId);
//
//
//        String json = gson.toJson(voInDB);
//        PrintWriter writer = resp.getWriter();
//        writer.println(json);

    }
}
