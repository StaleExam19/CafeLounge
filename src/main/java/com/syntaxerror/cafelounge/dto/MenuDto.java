package com.syntaxerror.cafelounge.dto;

import java.util.Date;

public class MenuDto {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String status;
    private int quantity;
    private String addedBy;
    private String updatedBy;
    private byte[] image;

    private Date dateCreated;
    private Date dateUpdated;
    private Date dateDelisted;
    

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
    public void setDateDelisted(Date dateDeleted) {
        this.dateDelisted = dateDeleted;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public byte[] getImage() {
        return image;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public Date getDateDelisted() {
        return dateDelisted;
    }
}
