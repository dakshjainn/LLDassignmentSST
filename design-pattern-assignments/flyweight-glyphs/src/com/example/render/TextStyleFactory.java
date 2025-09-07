package com.example.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TextStyleFactory {
    private static final Map<String, TextStyle> cache = new HashMap<>();

    public static TextStyle getTextStyle(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font");
        String key = font + "|" + size + "|" + (bold ? "B" : "");
        
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }

    // For testing - to check cache effectiveness
    public static int getCacheSize() {
        return cache.size();
    }
}
