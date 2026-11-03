package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {
    // Batas level untuk mini-challenge (konstanta bernama)
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    // Minimal 3 Warna
    public static final Color COLOR_PRIMARY = Color.decode("#2C3E50");
    public static final Color COLOR_ACCENT_GOLD = Color.decode("#F1C40F");
    public static final Color COLOR_TEXT_DEFAULT = Color.decode("#333333");
    
    // Warna per Role
    public static final Color COLOR_ROLE_WARRIOR = Color.decode("#E74C3C");
    public static final Color COLOR_ROLE_MAGE = Color.decode("#a1db0f");
    public static final Color COLOR_ROLE_ARCHER = Color.decode("#14e76c");

    // Minimal 3 Font (menggunakan Logical Fonts)
    public static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    public static final Font FONT_BODY = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final Font FONT_LEVEL_GOLD = new Font(Font.SANS_SERIF, Font.BOLD, 12);

    // Minimal 1 Border
    public static final Border BORDER_CARD = BorderFactory.createLineBorder(Color.GRAY, 1);
    public static final Border BORDER_HIGH_LEVEL = BorderFactory.createLineBorder(COLOR_ACCENT_GOLD, 2);

    // Method colorFor untuk memetakan role ke warna
   public static Color colorFor(Object type) {
    if (type == null) return COLOR_PRIMARY;
    String typeName = type.toString().toUpperCase();
    
    switch (typeName) {
        case "WARRIOR":
            return COLOR_ROLE_WARRIOR;
        case "MAGE":
            return COLOR_ROLE_MAGE;
        case "ARCHER":
            return COLOR_ROLE_ARCHER;
        default:
            return COLOR_PRIMARY;
        }
    }
}