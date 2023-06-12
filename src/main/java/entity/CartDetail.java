package entity;

import java.io.Serializable;

/**
 * (CartDetail)实体类
 *
 * @author makejava
 * @since 2023-06-12 13:43:45
 */
public class CartDetail implements Serializable {
    private static final long serialVersionUID = 734708871446229088L;
    
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

