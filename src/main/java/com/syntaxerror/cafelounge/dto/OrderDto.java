package com.syntaxerror.cafelounge.dto;

import java.util.Date;

public class OrderDto {
    private int id;
    private int customerId;
    private int menuId;

    private Date date_ordered;
    private Date date_completed;
    private Date date_deleted;

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setDate_ordered(Date date_ordered) {
        this.date_ordered = date_ordered;
    }

    public void setDate_completed(Date date_completed) {
        this.date_completed = date_completed;
    }

    public void setDate_deleted(Date date_deleted) {
        this.date_deleted = date_deleted;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getMenuId() {
        return menuId;
    }

    public Date getDate_ordered() {
        return date_ordered;
    }

    public Date getDate_completed() {
        return date_completed;
    }

    public Date getDate_deleted() {
        return date_deleted;
    }
}
