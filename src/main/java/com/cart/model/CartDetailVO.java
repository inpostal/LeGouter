package com.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 購物車明細VO
 * cart_detail
 *
 * dessert_id		甜點ID
 * mem_id			會員ID
 * cart_dessert_amount	甜點數量
 *
 * @version 2022/06/12
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailVO implements Serializable {
    private static final long serialVersionUID = 991064508818802335L;
    
    private Integer dessertId;
    
    private Integer memId;
    
    private Integer cartDessertAmount;


    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getCartDessertAmount() {
        return cartDessertAmount;
    }

    public void setCartDessertAmount(Integer cartDessertAmount) {
        this.cartDessertAmount = cartDessertAmount;
    }

}

