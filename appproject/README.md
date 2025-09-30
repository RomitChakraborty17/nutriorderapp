# 🍽️ NutriOrder - Health-Conscious Food Ordering System

## 📱 Live Web App
🌟 **[Try NutriOrder Live →](https://your-username.github.io/nutriorder-webapp)** 🌟

A complete food ordering system with both Java console application and modern web app versions.

## 🚀 Quick Deploy Web App

### Method 1: One-Click Deploy (Windows)
1. Double-click `deploy.bat` in this folder
2. Follow the on-screen instructions
3. Your app will be live on GitHub Pages!

### Method 2: Manual GitHub Upload
1. Go to [github.com](https://github.com) → Create new repository
2. Name: `nutriorder-webapp` (make it PUBLIC)
3. Upload ALL files from this folder
4. Settings → Pages → main branch → /web folder
5. Live at: `https://YOUR-USERNAME.github.io/nutriorder-webapp`

## 🌟 What You Get

### 📱 Modern Web App
- **26+ Food Items** with complete nutrition data
- **Mobile-First Design** - works perfectly on phones
- **PWA Ready** - install like a native app
- **Shopping Cart** with real-time nutrition totals
- **Order Management** with history tracking
- **Indian Rupee Pricing** (Rs format)

### 💻 Java Console App
NutriOrder is also an offline Java-based food ordering system that combines convenience with health awareness. It provides real-time nutritional breakdowns, including calories, protein, fat, and sugar. By storing menu data in simple files instead of databases, it remains lightweight and portable.

## Features

### 🍽️ Core Functionality
- **Menu Browsing**: Browse food items by category or view all items
- **Order Management**: Add items to cart, modify quantities, remove items
- **Order Submission**: Submit orders with customer information
- **Order History**: View past orders and daily statistics

### 🥗 Nutritional Awareness
- **Real-time Nutrition Tracking**: See calories, protein, fat, sugar, carbs, and fiber for each item
- **Order Nutrition Summary**: Get total nutritional breakdown for your entire order
- **Health-focused Decision Making**: Make informed choices with detailed nutritional information

### 💾 File-based Storage
- **Lightweight**: No database required - uses simple text files
- **Portable**: Easy to move and backup
- **Menu Data**: Stored in `data/menu.txt`
- **Order History**: Stored in `data/orders.txt`

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── nutriorder/
│               ├── NutriOrderApp.java          # Main application entry point
│               ├── models/                     # Data models
│               │   ├── FoodItem.java          # Food item with nutrition info
│               │   ├── NutritionalInfo.java   # Nutritional data structure
│               │   ├── Order.java             # Customer order
│               │   └── OrderItem.java         # Order line item
│               ├── services/                   # Business logic
│               │   ├── MenuService.java       # Menu management
│               │   └── OrderService.java      # Order processing
│               └── ui/                        # User interface
│                   └── NutriOrderUI.java      # Console-based UI
├── data/                                      # Data storage
│   ├── menu.txt                              # Menu items (auto-generated)
│   └── orders.txt                            # Order history (auto-generated)
└── README.md                                 # This file
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Any Java IDE or text editor

### Running the Application

1. **Compile the Java files:**
   ```bash
   javac -d . src/main/java/com/nutriorder/*.java src/main/java/com/nutriorder/*/*.java
   ```

2. **Run the application:**
   ```bash
   java com.nutriorder.NutriOrderApp
   ```

### First Run
On first startup, NutriOrder will automatically create:
- A sample menu with various food categories (Appetizers, Main Courses, Desserts, Beverages)
- Data directory structure
- Empty order history file

## Usage Guide

### 1. Browse Menu & Add Items
- Select from different food categories
- View detailed nutritional information for each item
- Add items to your order with desired quantities
- See real-time nutrition totals as you add items

### 2. Manage Your Order
- View current order with nutritional breakdown
- Remove items or modify quantities
- Clear entire order if needed
- See running total of calories and nutrients

### 3. Submit Orders
- Review order summary with total nutrition information
- Confirm and submit your order
- Receive order confirmation with unique order ID

### 4. View Order History
- Browse past orders
- View daily statistics (order count and revenue)
- Get detailed view of any previous order

## Sample Menu Items

The system comes with a pre-loaded sample menu including:

**Appetizers:**
- Caesar Salad (185 cal, 8g protein)
- Chicken Wings (320 cal, 25g protein)

**Main Courses:**
- Grilled Salmon (410 cal, 40g protein)
- Chicken Parmesan (580 cal, 45g protein)
- Vegetarian Pasta (450 cal, 15g protein)

**Desserts:**
- Chocolate Cake (520 cal, 6g protein)
- Fruit Tart (280 cal, 4g protein)

**Beverages:**
- Fresh Orange Juice (110 cal, 2g protein)
- Green Tea (2 cal, 0g protein)

## Data Format

### Menu File Format (`data/menu.txt`)
```
ID|Name|Description|Price|Category|Calories|Protein|Fat|Sugar|Carbs
APP001|Caesar Salad|Fresh romaine lettuce with parmesan|12.99|Appetizers|185.0|8.0|15.0|3.0|10.0
```

### Orders File Format (`data/orders.txt`)
```
OrderID|CustomerName|DateTime|Total
ORD0001|John Doe|2025-09-30T12:30:00|24.99
```

## Customization

### Adding New Menu Items
Edit `data/menu.txt` following the format above, or modify the `createSampleMenu()` method in `MenuService.java`.

### Extending Functionality
The modular design makes it easy to add new features:
- Add new nutritional metrics in `NutritionalInfo.java`
- Implement new UI components in the `ui` package
- Add new business logic in the `services` package

## Technical Details

- **Language**: Java 17+
- **Architecture**: Layered architecture (Models, Services, UI)
- **Storage**: File-based (text files)
- **UI**: Console-based interactive interface
- **Error Handling**: Comprehensive input validation and error recovery

## Benefits

### For Users
- Make healthier food choices with detailed nutritional information
- Track nutritional intake across entire orders
- Simple, intuitive ordering process
- Complete order history and statistics

### For Businesses
- Lightweight system with minimal setup requirements
- No database dependencies
- Easy to backup and transfer
- Health-conscious branding opportunity
- Simple daily reporting features

## Future Enhancements

Potential areas for expansion:
- GUI interface using JavaFX or Swing
- Export order history to CSV/PDF
- Nutritional goal tracking and recommendations
- Multiple restaurant/menu support
- Integration with payment systems
- Mobile app version

---

**NutriOrder** - Where Health Meets Convenience! 🥗✨
