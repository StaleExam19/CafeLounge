package com.syntaxerror.cafelounge.model;

import org.springframework.web.multipart.MultipartFile;

public class MenuForm {
    private String name;
    private String description;
    private String price;
    private String category;
    private String quantity;
    private String status;
    private MultipartFile image;

    public MenuForm() {}
    public MenuForm(String name, String price, String category, MultipartFile image) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public MultipartFile getImage() {
        return image;
    }
}
