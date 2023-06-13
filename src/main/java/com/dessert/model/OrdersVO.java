package com.dessert.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (Orders)表实体类
 *
 * @author Charlie
 * @since 2023-06-13 11:45:32
 */
@SuppressWarnings("serial")
public class OrdersVO implements Serializable {
    private static final long serialVersionUID = -60251565877828538L;

    private Integer orderId;

    private Integer memId;

    private Integer cpId;

    private Integer orderTotal;

    private Integer cpOrderTotal;

    private Integer orderStatus;

    private Date orderTime;

    private String receiverPhone;

    private String receiverAddress;

    private String receiverName;

    private List<OrderDetailVO> orderDetailListVO;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMemId() {
        return memId;
    }

    public void setMemId(Integer memId) {
        this.memId = memId;
    }

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getCpOrderTotal() {
        return cpOrderTotal;
    }

    public void setCpOrderTotal(Integer cpOrderTotal) {
        this.cpOrderTotal = cpOrderTotal;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

}

