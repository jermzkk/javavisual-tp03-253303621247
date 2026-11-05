package com.unpri.charactermanager.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class AppTheme {
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    public static final Color COLOR_PRIMARY_BG = new Color(245, 247, 250);
    public static final Color COLOR_TEXT_DARK = new Color(33, 37, 41);
    public static final Color COLOR_GOLD_HIGHLIGHT = new Color(184, 134, 11);

    public static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    public static final Font FONT_REGULAR = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final Font FONT_GOLD_BOLD = new Font(Font.SANS_SERIF, Font.BOLD, 13);

    public static final Border BORDER_CARD = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(210, 215, 220), 1),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    );

    public static Color colorForRole(Object role) {
        if (role == null) return Color.WHITE;
        String roleStr = role.toString().toUpperCase();
        switch (roleStr) {
            case "WARRIOR":
                return new Color(255, 230, 230);
            case "MAGE":
                return new Color(230, 230, 255);
            case "ARCHER":
                return new Color(230, 255, 230);
            case "ASSASSIN":
                return new Color(255, 240, 200);
            case "HEALER":
                return new Color(240, 230, 255);
            default:
                return new Color(240, 240, 240);
        }
    }
}