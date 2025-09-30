# 🍽️ NutriOrder - Health-Conscious Food Ordering Web App

[![Live Demo](https://img.shields.io/badge/Live-Demo-success?style=for-the-badge&logo=github-pages)](https://your-username.github.io/nutriorder-webapp)
[![PWA Ready](https://img.shields.io/badge/PWA-Ready-blueviolet?style=for-the-badge&logo=pwa)](https://your-username.github.io/nutriorder-webapp)

A modern, mobile-first Progressive Web App for health-conscious food ordering with real-time nutritional tracking. Built with vanilla JavaScript, HTML5, and CSS3.

## 🌟 Features

### 📱 Mobile-First Design
- **Progressive Web App (PWA)** - Install like a native app
- **Responsive Design** - Works on all devices
- **Touch Optimized** - Smooth mobile interactions
- **Offline Support** - Works without internet

### 🥗 Health & Nutrition
- **Real-time Nutrition Tracking** - Calories, protein, fat, carbs, fiber
- **Smart Food Choices** - Detailed nutritional information
- **Wellness Focus** - Health-conscious ordering system

### 💰 Indian Market Ready
- **Rupee Pricing** - All prices in Indian Rupees (Rs)
- **Local Food Categories** - Indian foods, kebabs, pizza
- **Cultural Preferences** - Dal, chapati, biryani, and more

### 🛒 Complete E-commerce
- **Shopping Cart** - Add, remove, modify quantities
- **Order Management** - Place and track orders
- **Order History** - View past purchases
- **Customer Profiles** - Personalized experience

## 🚀 Live Demo

🌐 **[Try NutriOrder Live →](https://your-username.github.io/nutriorder-webapp)**

*Replace "your-username" with your actual GitHub username after deployment*

## 📸 Screenshots

### 📱 Mobile Interface
- Beautiful splash screen with app branding
- Category-based menu browsing
- Shopping cart with nutrition totals
- Order history and tracking

### 🍽️ Menu Features
- **26+ Food Items** across 6 categories
- **Detailed Nutrition Info** for every item
- **Smart Categorization**: Appetizers, Main Courses, Indian Foods, Pizza, Kebabs, Desserts, Beverages
- **Quick Add** and **Detailed View** options

## 🛠️ Technology Stack

- **Frontend**: HTML5, CSS3, Vanilla JavaScript
- **Design**: Mobile-First, Responsive Web Design
- **Storage**: Local Storage API
- **PWA**: Service Workers, Web App Manifest
- **Hosting**: GitHub Pages
- **Icons**: Font Awesome

## 📦 Installation & Setup

### Method 1: GitHub Pages (Recommended)

1. **Fork this repository**
2. **Enable GitHub Pages**:
   - Go to repository Settings
   - Scroll to Pages section
   - Select source: Deploy from a branch
   - Choose branch: main
   - Folder: /web
3. **Access your app** at: `https://your-username.github.io/nutriorder-webapp`

### Method 2: Local Development

```bash
# Clone the repository
git clone https://github.com/your-username/nutriorder-webapp.git
cd nutriorder-webapp

# Serve the web folder
cd web
python -m http.server 8000
# or
npx http-server . -p 8000

# Open http://localhost:8000
```

### Method 3: Install as PWA

1. Visit the live demo URL
2. Look for "Install" or "Add to Home Screen" in your browser
3. Follow the prompts to install as a native app

## 📱 Usage Guide

### 🏠 Home Screen
- View app features and statistics
- Quick navigation to menu

### 🍽️ Browse Menu
- **Categories**: Filter by food type
- **Item Details**: Tap any item for full nutrition info
- **Quick Add**: Add items directly to cart
- **Nutrition Display**: See calories, protein, and more

### 🛒 Shopping Cart
- **Manage Items**: Add, remove, change quantities
- **Nutrition Summary**: Total calories and nutrients
- **Checkout**: Enter name and place order

### 📋 Order History
- View all past orders
- Track order status
- See order details and totals

## 🍛 Menu Categories

### 🥗 Appetizers
- Caesar Salad (185 cal, Rs1,079)
- Chicken Wings (320 cal, Rs1,245)

### 🍖 Main Courses  
- Grilled Salmon (410 cal, Rs2,075)
- Chicken Parmesan (580 cal, Rs1,660)
- Vegetarian Pasta (450 cal, Rs1,410)

### 🍛 Indian Foods
- Dal Tadka (230 cal, Rs350)
- Butter Chicken (438 cal, Rs650)
- Chapati 2pc (142 cal, Rs80)
- Biryani (485 cal, Rs450)
- Palak Paneer (375 cal, Rs420)
- Rajma (267 cal, Rs320)

### 🍕 Pizza
- Margherita (540 cal, Rs750)
- Pepperoni (628 cal, Rs850)
- Chicken BBQ (710 cal, Rs950)
- Veggie Supreme (485 cal, Rs800)

### 🍢 Kebabs
- Chicken Seekh (285 cal, Rs380)
- Chicken Tikka (310 cal, Rs420)
- Fish Tikka (268 cal, Rs480)
- Mutton Kebab (385 cal, Rs550)
- Paneer Tikka (295 cal, Rs340)

### 🧁 Desserts
- Chocolate Cake (520 cal, Rs745)
- Fruit Tart (280 cal, Rs665)

### 🥤 Beverages
- Fresh Orange Juice (110 cal, Rs415)
- Green Tea (2 cal, Rs250)
- Lassi (158 cal, Rs180)
- Masala Chai (85 cal, Rs120)

## 🔧 Customization

### Adding New Menu Items
Edit `web/app.js` and add to the `menuData` array:

```javascript
{
    id: 'NEW001',
    name: 'New Item',
    description: 'Item description',
    price: 299.00,
    category: 'Category Name',
    nutrition: {
        calories: 250,
        protein: 15,
        fat: 10,
        sugar: 5,
        carbs: 30,
        fiber: 3
    }
}
```

### Changing Colors/Theme
Modify CSS variables in `web/styles.css`:

```css
:root {
    --primary-color: #4CAF50;
    --secondary-color: #45a049;
    /* Add your custom colors */
}
```

## 📊 Performance

- **⚡ Fast Loading** - Optimized assets and minimal dependencies
- **📱 Mobile Optimized** - 60fps animations and smooth scrolling
- **🔄 Offline Ready** - Works without internet connection
- **💾 Local Storage** - Persistent cart and order history

## 🌐 Browser Support

- ✅ Chrome (Mobile & Desktop)
- ✅ Firefox (Mobile & Desktop)  
- ✅ Safari (Mobile & Desktop)
- ✅ Edge (Mobile & Desktop)
- ✅ Samsung Internet
- ✅ Chrome on Android
- ✅ Safari on iOS

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- **Font Awesome** for beautiful icons
- **Google Fonts** for typography
- **PWA Community** for best practices
- **GitHub Pages** for free hosting

## 📞 Support

If you encounter any issues or have questions:

1. Check the [Issues](https://github.com/your-username/nutriorder-webapp/issues) page
2. Create a new issue with detailed information
3. Join the discussion in the community

---

**Made with ❤️ for health-conscious food lovers**

🌟 **Star this repo** if you found it helpful!

[![GitHub stars](https://img.shields.io/github/stars/your-username/nutriorder-webapp?style=social)](https://github.com/your-username/nutriorder-webapp/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/your-username/nutriorder-webapp?style=social)](https://github.com/your-username/nutriorder-webapp/network/members)
