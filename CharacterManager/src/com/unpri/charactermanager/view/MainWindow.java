package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(CharacterManager manager) {
        // Bagian A: Pengaturan title bar & ukuran jendela[cite: 1]
        setTitle("Character Manager Sprint #3");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel tempat daftar karakter
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        // Bagian A: Tampil DINAMIS dengan loop[cite: 1]
        for (Character c : manager.getCharacterList()) {
            JLabel label = new JLabel(c.getName() + " - " + c.getType() + " (Lvl " + c.getLevel() + ")");
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            listPanel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(listPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Bagian B: JLabel statistik "Rata-rata Level"[cite: 2]
        JLabel avgLabel = new JLabel(String.format("Rata-rata Level: %.2f", manager.getAverageLevel()), SwingConstants.CENTER);
        avgLabel.setFont(new Font("Arial", Font.BOLD, 14));
        avgLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(avgLabel, BorderLayout.SOUTH);
    }
}