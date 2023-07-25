package com.syntaxerror.cafelounge.dto;

import java.util.Date;

public class OrderDto {
    private int id;
    private int customerId;
    private int menuId;
    private int quantity;
    private String status;
    private Date dateOrdered;
    private Date dateCompleted;
    private Date dateDeleted;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getMenuId() {
        return menuId;
    }
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getDateOrdered() {
        return dateOrdered;
    }
    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
    public Date getDateCompleted() {
        return dateCompleted;
    }
    public void setDateCompleted(Date completed) {
        this.dateCompleted = completed;
    }
    public Date getDateDeleted() {
        return dateDeleted;
    }
    public void setDateDeleted(Date dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    
}
