package com.syntaxerror.cafelounge.dto;

public class MenuDto {
    private int id;
    private String name;
    private double price;
    private String category;
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

    public byte[] getImage() {
        return image;
    }
}
