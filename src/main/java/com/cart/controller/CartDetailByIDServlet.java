package com.cart.controller;

import com.cart.model.CartDetailDAO;
import com.cart.model.CartDetailVO;
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

    }
}
