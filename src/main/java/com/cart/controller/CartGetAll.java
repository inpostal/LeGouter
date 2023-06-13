package com.cart.controller;

import com.cart.model.CartDetailDAO;
import com.dessert.model.CartDetailVO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * ClassName: CartGetAll
 * Description:
 *
 * @Author Charlie
 * @Create 2023/6/13 PM 02:07
 */
@WebServlet("/Cart/GetAll")
public class CartGetAll extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json;charset=UTF8");

        PrintWriter writer = res.getWriter();
        CartDetailDAO dao = new CartDetailDAO();
        List<CartDetailVO> all = dao.getAll();

        Gson gson = new Gson();
        String json = gson.toJson(all);
        writer.print(json);
    }
}
