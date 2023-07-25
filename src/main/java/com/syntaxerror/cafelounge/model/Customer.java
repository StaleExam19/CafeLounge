package com.syntaxerror.cafelounge.model;

import java.util.Date;
import java.util.List;

public class Customer {
    private String firstname;
    private String lastname;
    private List<Menu> orders;
    private String status;
    private Date dateOrdered;

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Date dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Menu> getOrders() {
        return orders;
    }

    public void setOrders(List<Menu> orders) {
        this.orders = orders;
    }
}
