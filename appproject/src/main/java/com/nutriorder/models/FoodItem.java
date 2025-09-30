package com.nutriorder.models;

/**
 * Represents a food item in the menu
 */
public class FoodItem {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private NutritionalInfo nutritionalInfo;
    private boolean available;

    public FoodItem() {}

    public FoodItem(String id, String name, String description, double price, String category, 
                   NutritionalInfo nutritionalInfo, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.nutritionalInfo = nutritionalInfo;
        this.available = available;
    }

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public NutritionalInfo getNutritionalInfo() { return nutritionalInfo; }
    public boolean isAvailable() { return available; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setNutritionalInfo(NutritionalInfo nutritionalInfo) { this.nutritionalInfo = nutritionalInfo; }
    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return String.format("%s - %s\n%s\nPrice: Rs%.2f | Category: %s\n%s\n%s",
                id, name, description, price, category, 
                nutritionalInfo.toString(), 
                available ? "Available" : "Not Available");
    }
}
