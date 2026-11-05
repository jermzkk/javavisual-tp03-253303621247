package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {
    private JPanel cardPanel;
    private JLabel statusLabel;
    

    public MainWindow(List<Character> characters) {
        setTitle("Character Manager - Sprint #5 (v0.5)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);

        // --- BORDERLAYOUT UTAMA JFRAME ---
        setLayout(new BorderLayout(10, 10));

        // ----------------------------------------------------
        // 1. NORTH: Header & Panel Statistik (GridLayout 2x2)
        // ----------------------------------------------------
        JPanel northContainer = new JPanel();
        northContainer.setLayout(new BoxLayout(northContainer, BoxLayout.Y_AXIS));

        // Header Title
        JLabel headerLabel = new JLabel("Character Manager Dashboard", SwingConstants.CENTER);
        headerLabel.setFont(AppTheme.FONT_TITLE != null ? AppTheme.FONT_TITLE : new Font("SansSerif", Font.BOLD, 20));
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
        northContainer.add(headerLabel);

        // Mini-Challenge: Panel Statistik Tambahan (GridLayout 2x2)
        JPanel statsPanel = new JPanel(new GridLayout(2, 2, 10, 5));
        statsPanel.setBorder(BorderFactory.createTitledBorder("Ringkasan Statistik"));

        int totalChar = characters != null ? characters.size() : 0;
        int maxLevel = 0;
        double avgLevel = 0;
        if (characters != null && !characters.isEmpty()) {
            int sum = 0;
            for (Character c : characters) {
                if (c.getLevel() > maxLevel) maxLevel = c.getLevel();
                sum += c.getLevel();
            }
            avgLevel = (double) sum / characters.size();
        }

        statsPanel.add(new JLabel(" Total Karakter: " + totalChar));
        statsPanel.add(new JLabel(" Max Level: " + maxLevel));
        statsPanel.add(new JLabel(" Rata-rata Level: " + String.format("%.1f", avgLevel)));
        statsPanel.add(new JLabel(" Status Sistem: Active"));

        northContainer.add(statsPanel);
        add(northContainer, BorderLayout.NORTH);

        // ----------------------------------------------------
        // 2. CENTER: Daftar Berscroll (JScrollPane + Card Panel)
        // ----------------------------------------------------
        // Card Panel menggunakan GridLayout 0 baris (bebas) x 2 kolom
        cardPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        // Pembungkus agar kartu ditaruh di NORTH (mencegah stretching vertikal)
        JPanel cardWrapper = new JPanel(new BorderLayout());
        cardWrapper.add(cardPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(cardWrapper);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(550, 400));

        add(scrollPane, BorderLayout.CENTER);

        // ----------------------------------------------------
        // 3. EAST: Legenda Tipe Karakter (BoxLayout Y_AXIS)
        // ----------------------------------------------------
        JPanel legendPanel = new JPanel();
        legendPanel.setLayout(new BoxLayout(legendPanel, BoxLayout.Y_AXIS));
        legendPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Legenda Peran"),
                new EmptyBorder(10, 10, 10, 10)
        ));

        // Dinamis dari CharacterType.values()
        for (CharacterType type : CharacterType.values()) {
            JLabel lblType = new JLabel("• " + type.name());
            lblType.setFont(new Font("SansSerif", Font.PLAIN, 12));
            legendPanel.add(lblType);
            legendPanel.add(Box.createVerticalStrut(8)); // Strut untuk spasi
        }
        legendPanel.add(Box.createVerticalGlue()); // Glue untuk pendorong ke atas

        add(legendPanel, BorderLayout.EAST);

        // ----------------------------------------------------
        // 4. SOUTH: Status Bar (BorderLayout Kiri-Kanan)
        // ----------------------------------------------------
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY),
                new EmptyBorder(5, 10, 5, 10)
        ));

        statusLabel = new JLabel("Ready | Total: " + totalChar + " karakter");
        JLabel versionLabel = new JLabel("v0.5");

        statusBar.add(statusLabel, BorderLayout.WEST);
        statusBar.add(versionLabel, BorderLayout.EAST);

        add(statusBar, BorderLayout.SOUTH);

        // Populate Kartu Karakter
        if (characters != null) {
            for (Character c : characters) {
                addCharacterCard(c);
            }
        }
    }

    private void addCharacterCard(Character c) {
        JPanel card = new JPanel(new BorderLayout(5, 5));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                new EmptyBorder(8, 8, 8, 8)
        ));

        JLabel nameLbl = new JLabel(c.getName() + " (Lv. " + c.getLevel() + ")");
        nameLbl.setFont(new Font("SansSerif", Font.BOLD, 13));

        JLabel typeLbl = new JLabel("Role: " + c.getType());
        typeLbl.setForeground(Color.DARK_GRAY);

        card.add(nameLbl, BorderLayout.NORTH);
        card.add(typeLbl, BorderLayout.CENTER);

        cardPanel.add(card);
    }
}