package com.syntaxerror.cafelounge.model;

public class MenuCategory {
    private String category;
    private String categoryName;

    public MenuCategory() {}

    public MenuCategory(String category, String categoryName) {
        this.category = category;
        this.categoryName = categoryName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategory() {
        return category;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
