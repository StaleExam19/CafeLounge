package com.syntaxerror.cafelounge.dto;

public class MenuDto {
    private int id;
    private String name;
    private double price;
    private String category;
    private String status;
    private byte[] image;   

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public byte[] getImage() {
        return image;
    }

}
