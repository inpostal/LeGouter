package com.cart.model;

import java.util.List;

/**
 * ClassName: ICartDetail
 * Description:
 *
 * @Author Charlie
 * @Create 2023/6/12 PM 02:00
 */
public interface ICartDetailDAO {
    void insert(CartDetailVO cartDetailVO);
    void update(CartDetailVO cartDetailVO);
    void delete(Integer dessertId, Integer memId);
    CartDetailVO findByPrimaryKey(Integer dessertId, Integer memId);
    List<CartDetailVO> getAll();
}
