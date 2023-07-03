package com.syntaxerror.cafelounge.model;

import org.springframework.web.multipart.MultipartFile;

public class MenuForm {
    private String name;
    private double price;
    private String category;
    private MultipartFile image;

    public MenuForm() {}
    public MenuForm(String name, double price, String category, MultipartFile image) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public MultipartFile getImage() {
        return image;
    }
}
