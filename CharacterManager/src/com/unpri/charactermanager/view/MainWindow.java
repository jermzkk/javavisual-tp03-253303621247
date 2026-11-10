package com.unpri.charactermanager.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
<<<<<<< HEAD

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;
=======
>>>>>>> sprint-5-layout

public class MainWindow extends JFrame {
    private JPanel cardPanel;
    private JLabel statusLabel;
    

<<<<<<< HEAD
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
=======
    private List<Character> characterList;     // data dari Main.java (Model)

    public MainWindow(List<Character> characterList) {
        super("Character Manager v0.5");            // sprint #5
        this.characterList = characterList;

        initComponents();                           // 1. susun semua area

        pack();                                     // 2. ukuran awal = preferred size isi
        setMinimumSize(new Dimension(560, 380));    // 3. batas terkecil yang masih rapi
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);                // 4. pusatkan SETELAH pack()
    }

    private void initComponents() {
        getContentPane().setBackground(AppTheme.BG_MAIN);  // warna di balik semua panel
        setLayout(new BorderLayout());                     // kerangka 4 wilayah (JFrame meneruskan ke content pane)

        add(createHeaderPanel(), BorderLayout.NORTH);      // judul + jumlah
        add(createListArea(),    BorderLayout.CENTER);     // daftar berscroll: satu-satunya yang tumbuh
        add(createLegendPanel(), BorderLayout.EAST);       // legenda role
        add(createStatusPanel(), BorderLayout.SOUTH);      // bar status
    }

    /** NORTH: judul di kiri, jumlah karakter di kanan. */
    private JPanel createHeaderPanel() {
        JPanel header = new JPanel(new BorderLayout());     // panel bersarang dengan layout sendiri
        header.setBackground(AppTheme.BG_MAIN);
        header.setBorder(BorderFactory.createEmptyBorder(16, 16, 8, 16)); // atas, kiri, bawah, kanan

        JLabel title = new JLabel("Character Manager");
        title.setFont(AppTheme.FONT_TITLE);
        title.setForeground(AppTheme.TEXT_MAIN);

        JLabel count = new JLabel(characterList.size() + " karakter");
        count.setFont(AppTheme.FONT_BODY);
        count.setForeground(AppTheme.GOLD);

        header.add(title, BorderLayout.WEST);               // rata kiri
        header.add(count, BorderLayout.EAST);               // rata kanan
        return header;
    }

    /** CENTER: kartu karakter di dalam JScrollPane. */
    private JScrollPane createListArea() {
        JPanel cards = new JPanel(new GridLayout(0, 1, 0, 8)); // satu kolom, jarak 8 px
        cards.setBackground(AppTheme.BG_MAIN);
        for (Character c : characterList) {
            cards.add(createCharacterLabel(c));              // kartu ditambah ke PANEL, bukan ke scroll pane
        }

        // holder: menaruh cards di NORTH agar kartu mempertahankan tinggi alaminya
        JPanel holder = new JPanel(new BorderLayout());
        holder.setBackground(AppTheme.BG_MAIN);
        holder.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 8));
        holder.add(cards, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(holder);        // bungkus HOLDER
        scroll.setBorder(null);                              // buang border bawaan
        scroll.getViewport().setBackground(AppTheme.BG_MAIN);
        scroll.setPreferredSize(new Dimension(460, 280));    // tanpa ini, 50 karakter = jendela raksasa
        return scroll;
    }

    /** Satu kartu karakter (sama seperti v0.4). */
    private JLabel createCharacterLabel(Character c) {
        String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower();

        JLabel lbl = new JLabel(info);
        lbl.setFont(AppTheme.FONT_BODY);
        lbl.setForeground(AppTheme.TEXT_LIGHT);
        lbl.setBackground(AppTheme.colorFor(c.getType()));
        lbl.setOpaque(true);                                 // wajib agar background tampak
        lbl.setBorder(AppTheme.CARD_BORDER);
        lbl.setToolTipText(AppTheme.describe(c.getType()));
        lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return lbl;
    }

    /** EAST: legenda warna per role, ditumpuk vertikal dengan BoxLayout. */
    private JPanel createLegendPanel() {
        JPanel legend = new JPanel();
        legend.setLayout(new BoxLayout(legend, BoxLayout.Y_AXIS)); // target = panel ini sendiri!
        legend.setBackground(AppTheme.BG_MAIN);
        legend.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 16));

        JLabel head = new JLabel("Legenda Role");
        head.setFont(AppTheme.FONT_BODY.deriveFont(java.awt.Font.BOLD)); // tebalkan tanpa tahu nama font
        head.setForeground(AppTheme.TEXT_MAIN);
        legend.add(head);
        legend.add(Box.createVerticalStrut(8));             // spasi tetap 8 px

        for (CharacterType type : CharacterType.values()) {  // satu chip per role
            JLabel chip = new JLabel(type.name());
            chip.setOpaque(true);
            chip.setBackground(AppTheme.colorFor(type));
            chip.setForeground(AppTheme.TEXT_LIGHT);
            chip.setFont(AppTheme.FONT_MONO);
            chip.setBorder(AppTheme.CARD_BORDER);
            chip.setToolTipText(AppTheme.describe(type));
            legend.add(chip);
            legend.add(Box.createVerticalStrut(6));
        }
        legend.add(Box.createVerticalGlue());               // dorong semua ke atas
        return legend;
    }

    /** SOUTH: bar status rata kiri. */
    private JPanel createStatusPanel() {
        JPanel status = new JPanel(new FlowLayout(FlowLayout.LEFT, 16, 6));
        status.setBackground(AppTheme.BG_STATUS);

        JLabel lbl = new JLabel("Total: " + characterList.size() + " karakter  |  Siap");
        lbl.setFont(AppTheme.FONT_MONO);
        lbl.setForeground(AppTheme.TEXT_MUTED);
        status.add(lbl);
        return status;
>>>>>>> sprint-5-layout
    }
}