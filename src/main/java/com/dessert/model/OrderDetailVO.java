package com.dessert.model;

import java.io.Serializable;
import java.util.Date;

/**
 * (OrderDetail)实体类
 *
 * @author makejava
 * @since 2023-06-13 11:53:09
 */
public class OrderDetailVO implements Serializable {
    private static final long serialVersionUID = -60251565877828538L;

    private Integer orderId;

    private Integer dessertId;

    private Integer dessertAmount;

    private Integer dessertPrice;

    private Date dessertReviewDate;

    private Integer dessertRateStar;


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getDessertId() {
        return dessertId;
    }

    public void setDessertId(Integer dessertId) {
        this.dessertId = dessertId;
    }

    public Integer getDessertAmount() {
        return dessertAmount;
    }

    public void setDessertAmount(Integer dessertAmount) {
        this.dessertAmount = dessertAmount;
    }

    public Integer getDessertPrice() {
        return dessertPrice;
    }

    public void setDessertPrice(Integer dessertPrice) {
        this.dessertPrice = dessertPrice;
    }

    public Date getDessertReviewDate() {
        return dessertReviewDate;
    }

    public void setDessertReviewDate(Date dessertReviewDate) {
        this.dessertReviewDate = dessertReviewDate;
    }

    public Integer getDessertRateStar() {
        return dessertRateStar;
    }

    public void setDessertRateStar(Integer dessertRateStar) {
        this.dessertRateStar = dessertRateStar;
    }

}

