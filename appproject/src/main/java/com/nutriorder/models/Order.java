package com.nutriorder.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer order
 */
public class Order {
    private String orderId;
    private String customerName;
    private LocalDateTime orderTime;
    private List<OrderItem> items;
    private double total;
    private String status;

    public Order() {
        this.items = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
        this.status = "Pending";
    }

    public Order(String orderId, String customerName) {
        this();
        this.orderId = orderId;
        this.customerName = customerName;
    }

    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public List<OrderItem> getItems() { return items; }
    public double getTotal() { return total; }
    public String getStatus() { return status; }

    // Setters
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setOrderTime(LocalDateTime orderTime) { this.orderTime = orderTime; }
    public void setItems(List<OrderItem> items) { 
        this.items = items;
        calculateTotal();
    }
    public void setStatus(String status) { this.status = status; }

    // Order management methods
    public void addItem(OrderItem item) {
        items.add(item);
        calculateTotal();
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
        calculateTotal();
    }

    public void clearItems() {
        items.clear();
        total = 0;
    }

    private void calculateTotal() {
        total = items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    public NutritionalInfo getTotalNutrition() {
        double totalCalories = 0, totalProtein = 0, totalFat = 0, 
               totalSugar = 0, totalCarbs = 0, totalFiber = 0;

        for (OrderItem item : items) {
            NutritionalInfo itemNutrition = item.getTotalNutrition();
            totalCalories += itemNutrition.getCalories();
            totalProtein += itemNutrition.getProtein();
            totalFat += itemNutrition.getFat();
            totalSugar += itemNutrition.getSugar();
            totalCarbs += itemNutrition.getCarbs();
            totalFiber += itemNutrition.getFiber();
        }

        return new NutritionalInfo(totalCalories, totalProtein, totalFat, totalSugar, totalCarbs, totalFiber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ORDER SUMMARY ===\n");
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Time: ").append(orderTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
        sb.append("Status: ").append(status).append("\n\n");
        
        sb.append("ITEMS:\n");
        for (OrderItem item : items) {
            sb.append("- ").append(item.toString()).append("\n");
        }
        
        sb.append("\nTOTAL: Rs").append(String.format("%.2f", total)).append("\n");
        sb.append("\nNUTRITIONAL BREAKDOWN:\n");
        sb.append(getTotalNutrition().toString());
        
        return sb.toString();
    }
}
