package com.cart.model;

import jdk.dynalink.linker.support.Lookup;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * ClassName: CartDetailDAO
 * Description:
 *
 * @Author Charlie
 * @Create 2023/6/12 PM 02:04
 */
public class CartDetailDAO implements ICartDetailDAO {
    private static DataSource ds = null;
    static {
        try {
            InitialContext context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/LeGouterDB");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insert(CartDetailVO cartDetailVO) {

    }

    @Override
    public void update(CartDetailVO cartDetailVO) {

    }

    @Override
    public void delete(Integer dessertId, Integer memId) {

    }

    @Override
    public CartDetailVO findByPrimaryKey(Integer dessertId, Integer memId) {
        String sql = "SELECT * FROM cart_detail WHERE DESSERT_ID = ? AND MEM_ID = ?";
        try ( Connection connection = ds.getConnection();
              PreparedStatement statement = connection.prepareStatement(sql);){

            statement.setInt(1, dessertId);
            statement.setInt(2, memId);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                CartDetailVO cartDetailVO = new CartDetailVO();
                cartDetailVO.setDessertId(rs.getInt("dessert_Id"));
                cartDetailVO.setMemId(rs.getInt("mem_Id"));
                cartDetailVO.setCartDessertAmount(rs.getInt("CART_DESSERT_AMOUNT"));
                return cartDetailVO;
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CartDetailVO> getAll() {
        return null;
    }
}
