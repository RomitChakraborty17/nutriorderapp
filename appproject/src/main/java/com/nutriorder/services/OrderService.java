package com.nutriorder.services;

import com.nutriorder.models.Order;
import com.nutriorder.models.OrderItem;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Service for managing orders and order history
 */
public class OrderService {
    private static final String ORDERS_FILE = "data/orders.txt";
    private List<Order> orderHistory;
    private Order currentOrder;
    private int orderCounter;

    public OrderService() {
        this.orderHistory = new ArrayList<>();
        this.orderCounter = 1;
        loadOrderHistory();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public Order createNewOrder(String customerName) {
        String orderId = "ORD" + String.format("%04d", orderCounter++);
        currentOrder = new Order(orderId, customerName);
        return currentOrder;
    }

    public void addItemToCurrentOrder(OrderItem item) {
        if (currentOrder != null) {
            currentOrder.addItem(item);
        }
    }

    public void removeItemFromCurrentOrder(OrderItem item) {
        if (currentOrder != null) {
            currentOrder.removeItem(item);
        }
    }

    public void clearCurrentOrder() {
        if (currentOrder != null) {
            currentOrder.clearItems();
        }
    }

    public Order submitCurrentOrder() {
        if (currentOrder != null && !currentOrder.getItems().isEmpty()) {
            currentOrder.setStatus("Submitted");
            orderHistory.add(currentOrder);
            saveOrderToFile(currentOrder);
            Order submittedOrder = currentOrder;
            currentOrder = null;
            return submittedOrder;
        }
        return null;
    }

    public List<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

    public Order getOrderById(String orderId) {
        return orderHistory.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .findFirst()
                .orElse(null);
    }

    private void loadOrderHistory() {
        File file = new File(ORDERS_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }
                
                // Simple order loading - in a real app, you'd parse more detailed order data
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    String orderId = parts[0].trim();
                    String customerName = parts[1].trim();
                    String timeStr = parts[2].trim();
                    double total = Double.parseDouble(parts[3].trim());
                    
                    Order order = new Order(orderId, customerName);
                    order.setOrderTime(LocalDateTime.parse(timeStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                    order.setStatus("Completed");
                    orderHistory.add(order);
                    
                    // Update counter to avoid ID conflicts
                    try {
                        int orderNum = Integer.parseInt(orderId.substring(3));
                        if (orderNum >= orderCounter) {
                            orderCounter = orderNum + 1;
                        }
                    } catch (Exception e) {
                        // Ignore parsing errors
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading order history: " + e.getMessage());
        }
    }

    private void saveOrderToFile(Order order) {
        File file = new File(ORDERS_FILE);
        file.getParentFile().mkdirs();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
            if (file.length() == 0) {
                writer.println("# NutriOrder History File");
                writer.println("# Format: OrderID|CustomerName|DateTime|Total");
                writer.println();
            }
            
            writer.printf("%s|%s|%s|%.2f%n",
                    order.getOrderId(),
                    order.getCustomerName(),
                    order.getOrderTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    order.getTotal());
        } catch (IOException e) {
            System.err.println("Error saving order: " + e.getMessage());
        }
    }

    public double calculateDailyRevenue() {
        LocalDateTime today = LocalDateTime.now().toLocalDate().atStartOfDay();
        return orderHistory.stream()
                .filter(order -> order.getOrderTime().isAfter(today))
                .mapToDouble(Order::getTotal)
                .sum();
    }

    public int getTodayOrderCount() {
        LocalDateTime today = LocalDateTime.now().toLocalDate().atStartOfDay();
        return (int) orderHistory.stream()
                .filter(order -> order.getOrderTime().isAfter(today))
                .count();
    }
}
