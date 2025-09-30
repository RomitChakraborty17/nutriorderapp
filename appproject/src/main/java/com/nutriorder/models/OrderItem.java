package com.nutriorder.models;

/**
 * Represents an item in the order with quantity
 */
public class OrderItem {
    private FoodItem foodItem;
    private int quantity;
    private double subtotal;

    public OrderItem() {}

    public OrderItem(FoodItem foodItem, int quantity) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.subtotal = foodItem.getPrice() * quantity;
    }

    // Getters
    public FoodItem getFoodItem() { return foodItem; }
    public int getQuantity() { return quantity; }
    public double getSubtotal() { return subtotal; }

    // Setters
    public void setFoodItem(FoodItem foodItem) { 
        this.foodItem = foodItem;
        updateSubtotal();
    }
    
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
        updateSubtotal();
    }

    private void updateSubtotal() {
        if (foodItem != null) {
            this.subtotal = foodItem.getPrice() * quantity;
        }
    }

    public NutritionalInfo getTotalNutrition() {
        if (foodItem == null || foodItem.getNutritionalInfo() == null) {
            return new NutritionalInfo();
        }
        
        NutritionalInfo itemNutrition = foodItem.getNutritionalInfo();
        return new NutritionalInfo(
            itemNutrition.getCalories() * quantity,
            itemNutrition.getProtein() * quantity,
            itemNutrition.getFat() * quantity,
            itemNutrition.getSugar() * quantity,
            itemNutrition.getCarbs() * quantity,
            itemNutrition.getFiber() * quantity
        );
    }

    @Override
    public String toString() {
        return String.format("%s x%d - Rs%.2f", foodItem.getName(), quantity, subtotal);
    }
}
