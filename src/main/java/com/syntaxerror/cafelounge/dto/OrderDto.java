package com.syntaxerror.cafelounge.dto;

import java.util.Date;

public class OrderDto {
    private String customerName;
    private String menuName;
    private Date dateOrdered;
    private int quantity;
    private String status;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMenuName() {
        return menuName;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }
}
