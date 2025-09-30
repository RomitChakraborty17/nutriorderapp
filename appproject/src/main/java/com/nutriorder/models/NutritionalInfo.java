package com.nutriorder.models;

/**
 * Represents nutritional information for food items
 */
public class NutritionalInfo {
    private double calories;
    private double protein;  // in grams
    private double fat;      // in grams
    private double sugar;    // in grams
    private double carbs;    // in grams
    private double fiber;    // in grams

    public NutritionalInfo() {}

    public NutritionalInfo(double calories, double protein, double fat, double sugar, double carbs, double fiber) {
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sugar = sugar;
        this.carbs = carbs;
        this.fiber = fiber;
    }

    // Getters
    public double getCalories() { return calories; }
    public double getProtein() { return protein; }
    public double getFat() { return fat; }
    public double getSugar() { return sugar; }
    public double getCarbs() { return carbs; }
    public double getFiber() { return fiber; }

    // Setters
    public void setCalories(double calories) { this.calories = calories; }
    public void setProtein(double protein) { this.protein = protein; }
    public void setFat(double fat) { this.fat = fat; }
    public void setSugar(double sugar) { this.sugar = sugar; }
    public void setCarbs(double carbs) { this.carbs = carbs; }
    public void setFiber(double fiber) { this.fiber = fiber; }

    @Override
    public String toString() {
        return String.format("Calories: %.1f | Protein: %.1fg | Fat: %.1fg | Sugar: %.1fg | Carbs: %.1fg | Fiber: %.1fg",
                calories, protein, fat, sugar, carbs, fiber);
    }
}
