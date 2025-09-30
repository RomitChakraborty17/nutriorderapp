package com.nutriorder.services;

import com.nutriorder.models.FoodItem;
import com.nutriorder.models.NutritionalInfo;
import java.io.*;
import java.util.*;

/**
 * Service for managing menu data stored in files
 */
public class MenuService {
    private static final String MENU_FILE = "data/menu.txt";
    private List<FoodItem> menuItems;

    public MenuService() {
        this.menuItems = new ArrayList<>();
        loadMenuFromFile();
    }

    public List<FoodItem> getAllItems() {
        return new ArrayList<>(menuItems);
    }

    public List<FoodItem> getItemsByCategory(String category) {
        return menuItems.stream()
                .filter(item -> item.getCategory().equalsIgnoreCase(category))
                .filter(FoodItem::isAvailable)
                .toList();
    }

    public FoodItem getItemById(String id) {
        return menuItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<String> getCategories() {
        return menuItems.stream()
                .map(FoodItem::getCategory)
                .distinct()
                .sorted()
                .toList();
    }

    private void loadMenuFromFile() {
        // Always create fresh sample menu with updated items and prices
        createSampleMenu();
    }

    private void loadMenuFromFileOriginal() {
        File file = new File(MENU_FILE);
        if (!file.exists()) {
            createSampleMenu();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) {
                    continue;
                }
                
                FoodItem item = parseMenuLine(line);
                if (item != null) {
                    menuItems.add(item);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading menu: " + e.getMessage());
            createSampleMenu();
        }
    }

    private FoodItem parseMenuLine(String line) {
        try {
            String[] parts = line.split("\\|");
            if (parts.length != 10) {
                return null;
            }

            String id = parts[0].trim();
            String name = parts[1].trim();
            String description = parts[2].trim();
            double price = Double.parseDouble(parts[3].trim());
            String category = parts[4].trim();
            
            // Parse nutritional info
            double calories = Double.parseDouble(parts[5].trim());
            double protein = Double.parseDouble(parts[6].trim());
            double fat = Double.parseDouble(parts[7].trim());
            double sugar = Double.parseDouble(parts[8].trim());
            double carbs = Double.parseDouble(parts[9].trim());
            
            NutritionalInfo nutrition = new NutritionalInfo(calories, protein, fat, sugar, carbs, 0);
            
            return new FoodItem(id, name, description, price, category, nutrition, true);
        } catch (Exception e) {
            System.err.println("Error parsing menu line: " + line);
            return null;
        }
    }

    private void createSampleMenu() {
        // Create sample menu data
        menuItems.clear();
        
        // Appetizers
        menuItems.add(new FoodItem("APP001", "Caesar Salad", "Fresh romaine lettuce with parmesan and croutons", 
                1079.00, "Appetizers", new NutritionalInfo(185, 8, 15, 3, 10, 4), true));
        menuItems.add(new FoodItem("APP002", "Chicken Wings", "Spicy buffalo wings with blue cheese dip", 
                1245.00, "Appetizers", new NutritionalInfo(320, 25, 22, 2, 5, 0), true));
        
        // Main Courses
        menuItems.add(new FoodItem("MAIN001", "Grilled Salmon", "Fresh Atlantic salmon with herbs and lemon", 
                2075.00, "Main Courses", new NutritionalInfo(410, 40, 25, 0, 2, 0), true));
        menuItems.add(new FoodItem("MAIN002", "Chicken Parmesan", "Breaded chicken breast with marinara and mozzarella", 
                1660.00, "Main Courses", new NutritionalInfo(580, 45, 32, 8, 28, 3), true));
        menuItems.add(new FoodItem("MAIN003", "Vegetarian Pasta", "Penne with roasted vegetables and olive oil", 
                1410.00, "Main Courses", new NutritionalInfo(450, 15, 18, 12, 62, 8), true));
        
        // Desserts
        menuItems.add(new FoodItem("DES001", "Chocolate Cake", "Rich chocolate layer cake with ganache", 
                745.00, "Desserts", new NutritionalInfo(520, 6, 24, 45, 72, 4), true));
        menuItems.add(new FoodItem("DES002", "Fruit Tart", "Fresh seasonal fruits on pastry cream", 
                665.00, "Desserts", new NutritionalInfo(280, 4, 12, 32, 42, 3), true));
        
        // Indian Foods
        menuItems.add(new FoodItem("IND001", "Dal Tadka", "Yellow lentils cooked with spices and herbs", 
                350.00, "Indian Foods", new NutritionalInfo(230, 18, 6, 4, 35, 12), true));
        menuItems.add(new FoodItem("IND002", "Butter Chicken", "Creamy tomato-based chicken curry", 
                650.00, "Indian Foods", new NutritionalInfo(438, 32, 28, 8, 15, 2), true));
        menuItems.add(new FoodItem("IND003", "Chapati (2 pieces)", "Whole wheat Indian flatbread", 
                80.00, "Indian Foods", new NutritionalInfo(142, 5, 2, 1, 28, 4), true));
        menuItems.add(new FoodItem("IND004", "Biryani", "Fragrant basmati rice with spiced chicken", 
                450.00, "Indian Foods", new NutritionalInfo(485, 28, 15, 3, 65, 2), true));
        menuItems.add(new FoodItem("IND005", "Palak Paneer", "Cottage cheese in creamy spinach gravy", 
                420.00, "Indian Foods", new NutritionalInfo(375, 22, 28, 6, 18, 5), true));
        menuItems.add(new FoodItem("IND006", "Rajma", "Red kidney beans curry with spices", 
                320.00, "Indian Foods", new NutritionalInfo(267, 15, 8, 5, 38, 14), true));

        // Pizza
        menuItems.add(new FoodItem("PIZ001", "Margherita Pizza", "Classic pizza with tomato sauce, mozzarella and basil", 
                750.00, "Pizza", new NutritionalInfo(540, 22, 18, 8, 72, 4), true));
        menuItems.add(new FoodItem("PIZ002", "Pepperoni Pizza", "Pizza topped with spicy pepperoni slices", 
                850.00, "Pizza", new NutritionalInfo(628, 28, 26, 6, 68, 3), true));
        menuItems.add(new FoodItem("PIZ003", "Chicken BBQ Pizza", "Pizza with BBQ chicken, onions and cheese", 
                950.00, "Pizza", new NutritionalInfo(710, 35, 28, 12, 75, 4), true));
        menuItems.add(new FoodItem("PIZ004", "Veggie Supreme", "Pizza loaded with fresh vegetables", 
                800.00, "Pizza", new NutritionalInfo(485, 20, 16, 8, 65, 6), true));

        // Kebabs
        menuItems.add(new FoodItem("KEB001", "Chicken Seekh Kebab", "Minced chicken skewers with aromatic spices", 
                380.00, "Kebabs", new NutritionalInfo(285, 28, 15, 2, 5, 1), true));
        menuItems.add(new FoodItem("KEB002", "Chicken Tikka", "Marinated chicken cubes grilled to perfection", 
                420.00, "Kebabs", new NutritionalInfo(310, 32, 14, 3, 8, 0), true));
        menuItems.add(new FoodItem("KEB003", "Fish Tikka", "Fresh fish marinated in yogurt and spices", 
                480.00, "Kebabs", new NutritionalInfo(268, 35, 10, 2, 6, 0), true));
        menuItems.add(new FoodItem("KEB004", "Mutton Kebab", "Tender mutton pieces with traditional spices", 
                550.00, "Kebabs", new NutritionalInfo(385, 30, 25, 1, 4, 0), true));
        menuItems.add(new FoodItem("KEB005", "Paneer Tikka", "Grilled cottage cheese with bell peppers", 
                340.00, "Kebabs", new NutritionalInfo(295, 18, 20, 4, 12, 2), true));

        // Beverages
        menuItems.add(new FoodItem("BEV001", "Fresh Orange Juice", "Freshly squeezed orange juice", 
                415.00, "Beverages", new NutritionalInfo(110, 2, 0, 21, 26, 0), true));
        menuItems.add(new FoodItem("BEV002", "Green Tea", "Organic green tea with antioxidants", 
                250.00, "Beverages", new NutritionalInfo(2, 0, 0, 0, 0, 0), true));
        menuItems.add(new FoodItem("BEV003", "Lassi", "Traditional yogurt-based drink", 
                180.00, "Beverages", new NutritionalInfo(158, 8, 4, 18, 20, 0), true));
        menuItems.add(new FoodItem("BEV004", "Masala Chai", "Spiced Indian tea with milk", 
                120.00, "Beverages", new NutritionalInfo(85, 3, 2, 8, 12, 0), true));

        saveMenuToFile();
    }

    private void saveMenuToFile() {
        File file = new File(MENU_FILE);
        file.getParentFile().mkdirs();
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println("# NutriOrder Menu File");
            writer.println("# Format: ID|Name|Description|Price|Category|Calories|Protein|Fat|Sugar|Carbs");
            writer.println();
            
            for (FoodItem item : menuItems) {
                NutritionalInfo nutrition = item.getNutritionalInfo();
                writer.printf("%s|%s|%s|%.2f|%s|%.1f|%.1f|%.1f|%.1f|%.1f%n",
                        item.getId(), item.getName(), item.getDescription(), item.getPrice(),
                        item.getCategory(), nutrition.getCalories(), nutrition.getProtein(),
                        nutrition.getFat(), nutrition.getSugar(), nutrition.getCarbs());
            }
        } catch (IOException e) {
            System.err.println("Error saving menu: " + e.getMessage());
        }
    }
}
