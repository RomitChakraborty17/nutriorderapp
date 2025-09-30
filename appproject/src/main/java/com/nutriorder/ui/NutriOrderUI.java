package com.nutriorder.ui;

import com.nutriorder.models.*;
import com.nutriorder.services.*;
import java.util.*;

/**
 * Console-based user interface for the NutriOrder system
 */
public class NutriOrderUI {
    private MenuService menuService;
    private OrderService orderService;
    private Scanner scanner;

    public NutriOrderUI() {
        this.menuService = new MenuService();
        this.orderService = new OrderService();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        clearScreen();
        showWelcomeScreen();

        while (true) {
            showMainMenu();
            int choice = getChoice(1, 5);
            
            switch (choice) {
                case 1 -> browseMenu();
                case 2 -> viewCurrentOrder();
                case 3 -> submitOrder();
                case 4 -> viewOrderHistory();
                case 5 -> {
                    System.out.println("Thank you for using NutriOrder!");
                    return;
                }
            }
        }
    }

    private void showMainMenu() {
        showAppHeader();
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                         📱 MAIN MENU                        │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.println("│                                                              │");
        System.out.println("│  🍽️  1. Browse Menu & Add Items                            │");
        System.out.println("│  🛒  2. View Current Order                                  │");
        System.out.println("│  ✅  3. Submit Order                                        │");
        System.out.println("│  📋  4. View Order History                                  │");
        System.out.println("│  🚪  5. Exit                                                │");
        System.out.println("│                                                              │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        System.out.println();
        System.out.print("🔸 Choose an option (1-5): ");
    }

    private void browseMenu() {
        clearScreen();
        showAppHeader();
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                      🍽️ MENU CATEGORIES                     │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        
        // Show categories with emojis
        List<String> categories = menuService.getCategories();
        String[] categoryEmojis = {"🥗", "🍖", "🧁", "🍛", "🍕", "🍢", "🥤"};
        
        for (int i = 0; i < categories.size(); i++) {
            String emoji = i < categoryEmojis.length ? categoryEmojis[i] : "🍴";
            System.out.printf("│  %s  %d. %-50s │%n", emoji, i + 1, categories.get(i));
        }
        System.out.printf("│  🌟  %d. %-50s │%n", categories.size() + 1, "View All Items");
        System.out.println("│                                                              │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        System.out.print("Select category: ");
        int categoryChoice = getChoice(1, categories.size() + 1);
        
        List<FoodItem> items;
        if (categoryChoice <= categories.size()) {
            String selectedCategory = categories.get(categoryChoice - 1);
            items = menuService.getItemsByCategory(selectedCategory);
            System.out.printf("%n🎯 Selected Category: %s%n", selectedCategory.toUpperCase());
        } else {
            items = menuService.getAllItems();
            System.out.println("\n🌟 ALL MENU ITEMS");
        }
        
        System.out.println();
        System.out.println("┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│                         AVAILABLE ITEMS                     │");
        System.out.println("└──────────────────────────────────────────────────────────────┘");
        
        // Display items in card format
        for (int i = 0; i < items.size(); i++) {
            FoodItem item = items.get(i);
            System.out.println();
            System.out.println("╭──────────────────────────────────────────────────────────────╮");
            System.out.printf("│  🍴 %d. %-52s │%n", i + 1, item.getName());
            System.out.printf("│      💰 Price: Rs%-42.2f │%n", item.getPrice());
            System.out.printf("│      📝 %s", formatDescription(item.getDescription()));
            System.out.printf("│      🥗 Nutrition: %-41s │%n", formatNutrition(item.getNutritionalInfo()));
            System.out.println("╰──────────────────────────────────────────────────────────────╯");
        }
        
        if (items.isEmpty()) {
            System.out.println("No items available in this category.");
            return;
        }
        
        // Add item to order
        System.out.printf("%nSelect item to add (1-%d) or 0 to go back: ", items.size());
        int itemChoice = getChoice(0, items.size());
        
        if (itemChoice > 0) {
            FoodItem selectedItem = items.get(itemChoice - 1);
            addItemToOrder(selectedItem);
        }
    }

    private void addItemToOrder(FoodItem item) {
        System.out.printf("%nAdding %s to your order%n", item.getName());
        System.out.print("Enter quantity: ");
        int quantity = getChoice(1, 20);
        
        // Create or get current order
        if (orderService.getCurrentOrder() == null) {
            System.out.print("Enter your name: ");
            String customerName = scanner.nextLine().trim();
            orderService.createNewOrder(customerName);
        }
        
        OrderItem orderItem = new OrderItem(item, quantity);
        orderService.addItemToCurrentOrder(orderItem);
        
        System.out.printf("Added %d x %s to your order!%n", quantity, item.getName());
        System.out.printf("Item nutrition (total): %s%n", orderItem.getTotalNutrition().toString());
        
        // Ask if they want to continue shopping or view order
        System.out.println("\n1. Continue Shopping");
        System.out.println("2. View Current Order");
        System.out.print("Choose: ");
        int choice = getChoice(1, 2);
        
        if (choice == 2) {
            viewCurrentOrder();
        }
    }

    private void viewCurrentOrder() {
        Order currentOrder = orderService.getCurrentOrder();
        
        if (currentOrder == null || currentOrder.getItems().isEmpty()) {
            System.out.println("\nYour order is empty.");
            return;
        }
        
        System.out.println("\n" + currentOrder.toString());
        
        // Order management options
        System.out.println("\nOrder Management:");
        System.out.println("1. Continue Shopping");
        System.out.println("2. Remove Item");
        System.out.println("3. Clear Order");
        System.out.println("4. Submit Order");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose: ");
        
        int choice = getChoice(1, 5);
        switch (choice) {
            case 1 -> browseMenu();
            case 2 -> removeItemFromOrder();
            case 3 -> {
                orderService.clearCurrentOrder();
                System.out.println("Order cleared!");
            }
            case 4 -> submitOrder();
            case 5 -> {} // Return to main menu
        }
    }

    private void removeItemFromOrder() {
        Order currentOrder = orderService.getCurrentOrder();
        if (currentOrder == null || currentOrder.getItems().isEmpty()) {
            return;
        }
        
        List<OrderItem> items = currentOrder.getItems();
        System.out.println("\nSelect item to remove:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, items.get(i).toString());
        }
        
        System.out.print("Choose item to remove: ");
        int choice = getChoice(1, items.size());
        
        OrderItem itemToRemove = items.get(choice - 1);
        orderService.removeItemFromCurrentOrder(itemToRemove);
        System.out.println("Item removed from order!");
    }

    private void submitOrder() {
        Order currentOrder = orderService.getCurrentOrder();
        
        if (currentOrder == null || currentOrder.getItems().isEmpty()) {
            System.out.println("\nNo order to submit. Please add items first.");
            return;
        }
        
        System.out.println("\n=== ORDER CONFIRMATION ===");
        System.out.println(currentOrder.toString());
        
        System.out.println("\nConfirm submission?");
        System.out.println("1. Yes, Submit Order");
        System.out.println("2. No, Continue Editing");
        System.out.print("Choose: ");
        
        int choice = getChoice(1, 2);
        if (choice == 1) {
            Order submittedOrder = orderService.submitCurrentOrder();
            if (submittedOrder != null) {
                System.out.println("\n✓ Order submitted successfully!");
                System.out.printf("Order ID: %s%n", submittedOrder.getOrderId());
                System.out.println("Thank you for your order!");
            } else {
                System.out.println("Error submitting order.");
            }
        }
    }

    private void viewOrderHistory() {
        List<Order> history = orderService.getOrderHistory();
        
        if (history.isEmpty()) {
            System.out.println("\nNo order history available.");
            return;
        }
        
        System.out.println("\n=== ORDER HISTORY ===");
        for (int i = 0; i < history.size(); i++) {
            Order order = history.get(i);
            System.out.printf("%d. %s - %s - Rs%.2f - %s%n", 
                    i + 1, order.getOrderId(), order.getCustomerName(), 
                    order.getTotal(), order.getStatus());
        }
        
        System.out.println("\nDaily Statistics:");
        System.out.printf("Today's Orders: %d%n", orderService.getTodayOrderCount());
        System.out.printf("Today's Revenue: Rs%.2f%n", orderService.calculateDailyRevenue());
        
        System.out.print("\nView detailed order (1-" + history.size() + ") or 0 to return: ");
        int choice = getChoice(0, history.size());
        
        if (choice > 0) {
            Order selectedOrder = history.get(choice - 1);
            System.out.println("\n" + selectedOrder.toString());
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }

    private int getChoice(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.printf("⚠️  Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.printf("⚠️  Please enter a valid number between %d and %d: ", min, max);
            }
        }
    }

    private void clearScreen() {
        // Clear screen for Windows
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // If clear doesn't work, print multiple newlines
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }

    private void showWelcomeScreen() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                              ║");
        System.out.println("║                    🍽️  NUTRIORDER  🥗                        ║");
        System.out.println("║                                                              ║");
        System.out.println("║              Your Health-Conscious Food Ordering            ║");
        System.out.println("║                       System v1.0                           ║");
        System.out.println("║                                                              ║");
        System.out.println("║                   📱 Mobile-Style Interface                  ║");
        System.out.println("║                   💡 Smart Nutrition Tracking               ║");
        System.out.println("║                   🇮🇳 Indian Rupee Pricing                   ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("💚 Making healthy choices easier, one meal at a time!");
        System.out.println();
        pauseForUser();
    }

    private void pauseForUser() {
        System.out.print("Press Enter to continue... ");
        scanner.nextLine();
        clearScreen();
    }

    private void showAppHeader() {
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("    🍽️  NUTRIORDER - Health-Conscious Food Ordering  🥗");
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println();
    }

    private String formatDescription(String description) {
        if (description.length() > 50) {
            return String.format("%-50s │%n│           ", description.substring(0, 47) + "...");
        }
        return String.format("%-50s │%n", description);
    }

    private String formatNutrition(NutritionalInfo nutrition) {
        return String.format("%.0f cal, %.0fg protein", nutrition.getCalories(), nutrition.getProtein());
    }
}
