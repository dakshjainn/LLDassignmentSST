package com.example.render;
public class App {
    public static void main(String[] args) {
        Renderer r = new Renderer();
        System.out.println("Cost=" + r.render("Hello Flyweight! ".repeat(2000)));
        System.out.println("TextStyle cache size: " + TextStyleFactory.getCacheSize());
        
        // Demonstrate reference equality for same styles
        TextStyle style1 = TextStyleFactory.getTextStyle("Inter", 14, true);
        TextStyle style2 = TextStyleFactory.getTextStyle("Inter", 14, true);
        System.out.println("Same style instances? " + (style1 == style2));
    }
}
