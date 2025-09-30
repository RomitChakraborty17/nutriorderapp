package com.nutriorder;

import com.nutriorder.ui.NutriOrderUI;

/**
 * Main application class for NutriOrder
 * 
 * NutriOrder is an offline Java-based food ordering system that combines 
 * convenience with health awareness. It provides real-time nutritional 
 * breakdowns including calories, protein, fat, and sugar while storing 
 * menu data in simple files for portability.
 */
public class NutriOrderApp {
    
    public static void main(String[] args) {
        System.out.println("Initializing NutriOrder System...");
        
        try {
            // Create and start the UI
            NutriOrderUI ui = new NutriOrderUI();
            ui.start();
            
        } catch (Exception e) {
            System.err.println("Error starting NutriOrder: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
