// NutriOrder Web App JavaScript

// Menu data from the Java application
const menuData = [
    // Appetizers
    { id: 'APP001', name: 'Caesar Salad', description: 'Fresh romaine lettuce with parmesan and croutons', price: 1079.00, category: 'Appetizers', nutrition: { calories: 185, protein: 8, fat: 15, sugar: 3, carbs: 10, fiber: 4 } },
    { id: 'APP002', name: 'Chicken Wings', description: 'Spicy buffalo wings with blue cheese dip', price: 1245.00, category: 'Appetizers', nutrition: { calories: 320, protein: 25, fat: 22, sugar: 2, carbs: 5, fiber: 0 } },
    
    // Main Courses
    { id: 'MAIN001', name: 'Grilled Salmon', description: 'Fresh Atlantic salmon with herbs and lemon', price: 2075.00, category: 'Main Courses', nutrition: { calories: 410, protein: 40, fat: 25, sugar: 0, carbs: 2, fiber: 0 } },
    { id: 'MAIN002', name: 'Chicken Parmesan', description: 'Breaded chicken breast with marinara and mozzarella', price: 1660.00, category: 'Main Courses', nutrition: { calories: 580, protein: 45, fat: 32, sugar: 8, carbs: 28, fiber: 3 } },
    { id: 'MAIN003', name: 'Vegetarian Pasta', description: 'Penne with roasted vegetables and olive oil', price: 1410.00, category: 'Main Courses', nutrition: { calories: 450, protein: 15, fat: 18, sugar: 12, carbs: 62, fiber: 8 } },
    
    // Indian Foods
    { id: 'IND001', name: 'Dal Tadka', description: 'Yellow lentils cooked with spices and herbs', price: 350.00, category: 'Indian Foods', nutrition: { calories: 230, protein: 18, fat: 6, sugar: 4, carbs: 35, fiber: 12 } },
    { id: 'IND002', name: 'Butter Chicken', description: 'Creamy tomato-based chicken curry', price: 650.00, category: 'Indian Foods', nutrition: { calories: 438, protein: 32, fat: 28, sugar: 8, carbs: 15, fiber: 2 } },
    { id: 'IND003', name: 'Chapati (2 pieces)', description: 'Whole wheat Indian flatbread', price: 80.00, category: 'Indian Foods', nutrition: { calories: 142, protein: 5, fat: 2, sugar: 1, carbs: 28, fiber: 4 } },
    { id: 'IND004', name: 'Biryani', description: 'Fragrant basmati rice with spiced chicken', price: 450.00, category: 'Indian Foods', nutrition: { calories: 485, protein: 28, fat: 15, sugar: 3, carbs: 65, fiber: 2 } },
    { id: 'IND005', name: 'Palak Paneer', description: 'Cottage cheese in creamy spinach gravy', price: 420.00, category: 'Indian Foods', nutrition: { calories: 375, protein: 22, fat: 28, sugar: 6, carbs: 18, fiber: 5 } },
    { id: 'IND006', name: 'Rajma', description: 'Red kidney beans curry with spices', price: 320.00, category: 'Indian Foods', nutrition: { calories: 267, protein: 15, fat: 8, sugar: 5, carbs: 38, fiber: 14 } },
    
    // Pizza
    { id: 'PIZ001', name: 'Margherita Pizza', description: 'Classic pizza with tomato sauce, mozzarella and basil', price: 750.00, category: 'Pizza', nutrition: { calories: 540, protein: 22, fat: 18, sugar: 8, carbs: 72, fiber: 4 } },
    { id: 'PIZ002', name: 'Pepperoni Pizza', description: 'Pizza topped with spicy pepperoni slices', price: 850.00, category: 'Pizza', nutrition: { calories: 628, protein: 28, fat: 26, sugar: 6, carbs: 68, fiber: 3 } },
    { id: 'PIZ003', name: 'Chicken BBQ Pizza', description: 'Pizza with BBQ chicken, onions and cheese', price: 950.00, category: 'Pizza', nutrition: { calories: 710, protein: 35, fat: 28, sugar: 12, carbs: 75, fiber: 4 } },
    { id: 'PIZ004', name: 'Veggie Supreme', description: 'Pizza loaded with fresh vegetables', price: 800.00, category: 'Pizza', nutrition: { calories: 485, protein: 20, fat: 16, sugar: 8, carbs: 65, fiber: 6 } },
    
    // Kebabs
    { id: 'KEB001', name: 'Chicken Seekh Kebab', description: 'Minced chicken skewers with aromatic spices', price: 380.00, category: 'Kebabs', nutrition: { calories: 285, protein: 28, fat: 15, sugar: 2, carbs: 5, fiber: 1 } },
    { id: 'KEB002', name: 'Chicken Tikka', description: 'Marinated chicken cubes grilled to perfection', price: 420.00, category: 'Kebabs', nutrition: { calories: 310, protein: 32, fat: 14, sugar: 3, carbs: 8, fiber: 0 } },
    { id: 'KEB003', name: 'Fish Tikka', description: 'Fresh fish marinated in yogurt and spices', price: 480.00, category: 'Kebabs', nutrition: { calories: 268, protein: 35, fat: 10, sugar: 2, carbs: 6, fiber: 0 } },
    { id: 'KEB004', name: 'Mutton Kebab', description: 'Tender mutton pieces with traditional spices', price: 550.00, category: 'Kebabs', nutrition: { calories: 385, protein: 30, fat: 25, sugar: 1, carbs: 4, fiber: 0 } },
    { id: 'KEB005', name: 'Paneer Tikka', description: 'Grilled cottage cheese with bell peppers', price: 340.00, category: 'Kebabs', nutrition: { calories: 295, protein: 18, fat: 20, sugar: 4, carbs: 12, fiber: 2 } },
    
    // Desserts
    { id: 'DES001', name: 'Chocolate Cake', description: 'Rich chocolate layer cake with ganache', price: 745.00, category: 'Desserts', nutrition: { calories: 520, protein: 6, fat: 24, sugar: 45, carbs: 72, fiber: 4 } },
    { id: 'DES002', name: 'Fruit Tart', description: 'Fresh seasonal fruits on pastry cream', price: 665.00, category: 'Desserts', nutrition: { calories: 280, protein: 4, fat: 12, sugar: 32, carbs: 42, fiber: 3 } },
    
    // Beverages
    { id: 'BEV001', name: 'Fresh Orange Juice', description: 'Freshly squeezed orange juice', price: 415.00, category: 'Beverages', nutrition: { calories: 110, protein: 2, fat: 0, sugar: 21, carbs: 26, fiber: 0 } },
    { id: 'BEV002', name: 'Green Tea', description: 'Organic green tea with antioxidants', price: 250.00, category: 'Beverages', nutrition: { calories: 2, protein: 0, fat: 0, sugar: 0, carbs: 0, fiber: 0 } },
    { id: 'BEV003', name: 'Lassi', description: 'Traditional yogurt-based drink', price: 180.00, category: 'Beverages', nutrition: { calories: 158, protein: 8, fat: 4, sugar: 18, carbs: 20, fiber: 0 } },
    { id: 'BEV004', name: 'Masala Chai', description: 'Spiced Indian tea with milk', price: 120.00, category: 'Beverages', nutrition: { calories: 85, protein: 3, fat: 2, sugar: 8, carbs: 12, fiber: 0 } }
];

// App State
let currentPage = 'home';
let cart = JSON.parse(localStorage.getItem('nutriorder-cart')) || [];
let orders = JSON.parse(localStorage.getItem('nutriorder-orders')) || [];
let selectedCategory = 'all';
let selectedItem = null;
let selectedQuantity = 1;

// Initialize app
document.addEventListener('DOMContentLoaded', function() {
    setTimeout(() => {
        document.getElementById('splash-screen').style.display = 'none';
        document.getElementById('app').style.display = 'block';
        updateCartBadge();
        loadMenuItems();
        updateStats();
        loadOrders();
    }, 3000);

    // Navigation event listeners
    const navItems = document.querySelectorAll('.nav-item');
    navItems.forEach(item => {
        item.addEventListener('click', () => {
            const page = item.dataset.page;
            navigateToPage(page);
        });
    });

    // Category event listeners
    const categoryChips = document.querySelectorAll('.category-chip');
    categoryChips.forEach(chip => {
        chip.addEventListener('click', () => {
            const category = chip.dataset.category;
            selectCategory(category);
        });
    });

    // Cart badge click
    document.getElementById('cart-badge').addEventListener('click', () => {
        navigateToPage('cart');
    });
});

// Navigation
function navigateToPage(page) {
    // Update navigation
    document.querySelectorAll('.nav-item').forEach(item => {
        item.classList.remove('active');
        if (item.dataset.page === page) {
            item.classList.add('active');
        }
    });

    // Update pages
    document.querySelectorAll('.page').forEach(p => {
        p.classList.remove('active');
    });
    document.getElementById(page + '-page').classList.add('active');
    
    currentPage = page;

    // Load page-specific content
    if (page === 'menu') {
        loadMenuItems();
    } else if (page === 'cart') {
        loadCart();
    } else if (page === 'orders') {
        loadOrders();
    }
}

// Category selection
function selectCategory(category) {
    document.querySelectorAll('.category-chip').forEach(chip => {
        chip.classList.remove('active');
        if (chip.dataset.category === category) {
            chip.classList.add('active');
        }
    });
    selectedCategory = category;
    loadMenuItems();
}

// Load menu items
function loadMenuItems() {
    const container = document.getElementById('menu-items');
    const items = selectedCategory === 'all' ? menuData : menuData.filter(item => item.category === selectedCategory);
    
    container.innerHTML = items.map(item => `
        <div class="menu-item" onclick="openItemModal('${item.id}')">
            <div class="menu-item-content">
                <div class="menu-item-header">
                    <div>
                        <div class="menu-item-name">${item.name}</div>
                        <div class="menu-item-price">Rs${item.price.toFixed(2)}</div>
                    </div>
                </div>
                <div class="menu-item-description">${item.description}</div>
                <div class="menu-item-nutrition">
                    <h4>🥗 Nutritional Info</h4>
                    <div class="nutrition-quick">
                        <span>${Math.round(item.nutrition.calories)} cal</span>
                        <span>${Math.round(item.nutrition.protein)}g protein</span>
                        <span>${Math.round(item.nutrition.fat)}g fat</span>
                        <span>${Math.round(item.nutrition.carbs)}g carbs</span>
                    </div>
                </div>
                <button class="add-item-button" onclick="event.stopPropagation(); quickAddToCart('${item.id}')">
                    🛒 Quick Add
                </button>
            </div>
        </div>
    `).join('');
}

// Modal functions
function openItemModal(itemId) {
    const item = menuData.find(i => i.id === itemId);
    if (!item) return;

    selectedItem = item;
    selectedQuantity = 1;

    document.getElementById('modal-item-name').textContent = item.name;
    document.getElementById('modal-item-description').textContent = item.description;
    document.getElementById('modal-item-price').textContent = item.price.toFixed(2);
    document.getElementById('selected-quantity').textContent = selectedQuantity;
    
    const nutritionDetails = document.getElementById('modal-nutrition-details');
    nutritionDetails.innerHTML = `
        <div><strong>Calories:</strong> ${Math.round(item.nutrition.calories)}</div>
        <div><strong>Protein:</strong> ${Math.round(item.nutrition.protein)}g</div>
        <div><strong>Fat:</strong> ${Math.round(item.nutrition.fat)}g</div>
        <div><strong>Sugar:</strong> ${Math.round(item.nutrition.sugar)}g</div>
        <div><strong>Carbs:</strong> ${Math.round(item.nutrition.carbs)}g</div>
        <div><strong>Fiber:</strong> ${Math.round(item.nutrition.fiber)}g</div>
    `;

    document.getElementById('item-modal').style.display = 'block';
}

function closeModal() {
    document.getElementById('item-modal').style.display = 'none';
    selectedItem = null;
    selectedQuantity = 1;
}

function changeQuantity(delta) {
    selectedQuantity = Math.max(1, Math.min(20, selectedQuantity + delta));
    document.getElementById('selected-quantity').textContent = selectedQuantity;
}

// Cart functions
function quickAddToCart(itemId) {
    const item = menuData.find(i => i.id === itemId);
    if (!item) return;

    addItemToCart(item, 1);
    showToast(`Added ${item.name} to cart!`);
}

function addToCart() {
    if (!selectedItem) return;

    addItemToCart(selectedItem, selectedQuantity);
    showToast(`Added ${selectedQuantity}x ${selectedItem.name} to cart!`);
    closeModal();
}

function addItemToCart(item, quantity) {
    const existingItem = cart.find(cartItem => cartItem.id === item.id);
    
    if (existingItem) {
        existingItem.quantity += quantity;
    } else {
        cart.push({
            ...item,
            quantity: quantity
        });
    }
    
    saveCart();
    updateCartBadge();
    
    if (currentPage === 'cart') {
        loadCart();
    }
}

function removeFromCart(itemId) {
    cart = cart.filter(item => item.id !== itemId);
    saveCart();
    updateCartBadge();
    loadCart();
    showToast('Item removed from cart', 'error');
}

function updateCartQuantity(itemId, newQuantity) {
    if (newQuantity <= 0) {
        removeFromCart(itemId);
        return;
    }
    
    const item = cart.find(cartItem => cartItem.id === itemId);
    if (item) {
        item.quantity = newQuantity;
        saveCart();
        updateCartBadge();
        loadCart();
    }
}

function loadCart() {
    const container = document.getElementById('cart-items');
    const summary = document.getElementById('cart-summary');
    
    if (cart.length === 0) {
        container.innerHTML = `
            <div class="empty-cart">
                <i class="fas fa-shopping-cart"></i>
                <h3>Your cart is empty</h3>
                <p>Add some delicious items from our menu!</p>
                <button class="cta-button" onclick="navigateToPage('menu')">
                    Browse Menu
                </button>
            </div>
        `;
        summary.style.display = 'none';
        return;
    }

    // Show cart items
    container.innerHTML = cart.map(item => `
        <div class="cart-item">
            <div class="cart-item-header">
                <span class="cart-item-name">${item.name}</span>
                <button class="remove-item" onclick="removeFromCart('${item.id}')">
                    <i class="fas fa-trash"></i>
                </button>
            </div>
            <div class="cart-item-details">
                <div class="quantity-controls">
                    <button onclick="updateCartQuantity('${item.id}', ${item.quantity - 1})">-</button>
                    <span>${item.quantity}</span>
                    <button onclick="updateCartQuantity('${item.id}', ${item.quantity + 1})">+</button>
                </div>
                <span class="item-total">Rs${(item.price * item.quantity).toFixed(2)}</span>
            </div>
        </div>
    `).join('');

    // Calculate totals
    const totals = cart.reduce((acc, item) => {
        const itemTotal = item.quantity;
        acc.calories += item.nutrition.calories * itemTotal;
        acc.protein += item.nutrition.protein * itemTotal;
        acc.fat += item.nutrition.fat * itemTotal;
        acc.carbs += item.nutrition.carbs * itemTotal;
        acc.total += item.price * itemTotal;
        return acc;
    }, { calories: 0, protein: 0, fat: 0, carbs: 0, total: 0 });

    // Update nutrition summary
    document.getElementById('total-calories').textContent = Math.round(totals.calories);
    document.getElementById('total-protein').textContent = Math.round(totals.protein) + 'g';
    document.getElementById('total-fat').textContent = Math.round(totals.fat) + 'g';
    document.getElementById('total-carbs').textContent = Math.round(totals.carbs) + 'g';
    document.getElementById('cart-total').textContent = totals.total.toFixed(2);

    summary.style.display = 'block';
}

function submitOrder() {
    const customerName = document.getElementById('customer-name').value.trim();
    
    if (!customerName) {
        showToast('Please enter your name', 'error');
        return;
    }
    
    if (cart.length === 0) {
        showToast('Your cart is empty', 'error');
        return;
    }

    // Create order
    const order = {
        id: 'ORD' + Date.now(),
        customerName: customerName,
        items: [...cart],
        total: cart.reduce((sum, item) => sum + (item.price * item.quantity), 0),
        date: new Date().toISOString(),
        status: 'Submitted'
    };

    // Save order
    orders.unshift(order);
    localStorage.setItem('nutriorder-orders', JSON.stringify(orders));

    // Clear cart
    cart = [];
    saveCart();
    updateCartBadge();

    // Show success
    showToast(`Order ${order.id} submitted successfully!`);
    
    // Navigate to orders
    setTimeout(() => {
        navigateToPage('orders');
        document.getElementById('customer-name').value = '';
    }, 1000);
}

// Orders
function loadOrders() {
    const container = document.getElementById('orders-list');
    
    if (orders.length === 0) {
        container.innerHTML = `
            <div class="empty-orders">
                <i class="fas fa-receipt"></i>
                <h3>No orders yet</h3>
                <p>Your order history will appear here</p>
            </div>
        `;
        return;
    }

    container.innerHTML = orders.map(order => `
        <div class="order-item">
            <div class="order-header">
                <span class="order-id">${order.id}</span>
                <span class="order-status">${order.status}</span>
            </div>
            <div class="order-details">
                <div>Customer: ${order.customerName}</div>
                <div>Date: ${new Date(order.date).toLocaleDateString()}</div>
                <div>Items: ${order.items.length}</div>
            </div>
            <div class="order-total">Total: Rs${order.total.toFixed(2)}</div>
        </div>
    `).join('');
}

// Utility functions
function updateCartBadge() {
    const count = cart.reduce((sum, item) => sum + item.quantity, 0);
    document.getElementById('cart-count').textContent = count;
    document.getElementById('cart-count').style.display = count > 0 ? 'flex' : 'none';
}

function saveCart() {
    localStorage.setItem('nutriorder-cart', JSON.stringify(cart));
}

function updateStats() {
    document.getElementById('total-items').textContent = menuData.length;
    document.getElementById('categories').textContent = [...new Set(menuData.map(item => item.category))].length;
    
    // Count today's orders
    const today = new Date().toDateString();
    const todayOrders = orders.filter(order => new Date(order.date).toDateString() === today).length;
    document.getElementById('orders-today').textContent = todayOrders;
}

function showToast(message, type = 'success') {
    const toast = document.createElement('div');
    toast.className = `toast ${type}`;
    toast.textContent = message;
    
    document.getElementById('toast-container').appendChild(toast);
    
    setTimeout(() => {
        toast.remove();
    }, 3000);
}

// Close modal when clicking outside
window.onclick = function(event) {
    const modal = document.getElementById('item-modal');
    if (event.target === modal) {
        closeModal();
    }
}
