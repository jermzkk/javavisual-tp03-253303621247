package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(CharacterManager manager) {
        setTitle("Character Manager Sprint #4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel tempat daftar kartu karakter
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        for (Character c : manager.getCharacterList()) {
            // Membuat panel kartu individual untuk setiap karakter
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel label = new JLabel(c.getName() + " - " + c.getType() + " (Lvl " + c.getLevel() + ")");
            
            // Pewarnaan latar belakang berdasarkan role (View Layer)
            cardPanel.setBackground(AppTheme.colorFor(String.valueOf(c.getType())));
            cardPanel.setOpaque(true); // Wajib agar latar belakang berwarna
            
            // Mini-Challenge: Level >= 5 (Batas disimpan sebagai konstanta di AppTheme)
            if (c.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
                label.setForeground(AppTheme.COLOR_ACCENT_GOLD);
                label.setFont(AppTheme.FONT_LEVEL_GOLD);
                cardPanel.setBorder(AppTheme.BORDER_HIGH_LEVEL);
            } else {
                label.setForeground(AppTheme.COLOR_TEXT_DEFAULT);
                label.setFont(AppTheme.FONT_BODY);
                cardPanel.setBorder(AppTheme.BORDER_CARD);
            }

            // Properti Tambahan 1: Tooltip detail HP dan ATK
            // Properti Tambahan 1: Tooltip detail karakter (menggunakan getter yang ada di Model)
cardPanel.setToolTipText("Karakter: " + c.getName() + " | Tipe: " + c.getType() + " | Level: " + c.getLevel());

            // Properti Tambahan 2: Dinonaktifkan jika Level 1
            if (c.getLevel() == 1) {
                cardPanel.setEnabled(false);
                label.setEnabled(false);
            }

            cardPanel.add(label);
            listPanel.add(cardPanel);
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Label Statistik
        JLabel avgLabel = new JLabel(String.format("Rata-rata Level: %.2f", manager.getAverageLevel()), SwingConstants.CENTER);
        
        // Menggunakan Font & Border dari AppTheme (Bukan new Font(...) lagi)
        avgLabel.setFont(AppTheme.FONT_TITLE);
        avgLabel.setForeground(AppTheme.COLOR_PRIMARY);
        avgLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(avgLabel, BorderLayout.SOUTH);

        // Menyesuaikan ukuran jendela otomatis berdasarkan komponen di dalamnya
        this.pack();
    }
}