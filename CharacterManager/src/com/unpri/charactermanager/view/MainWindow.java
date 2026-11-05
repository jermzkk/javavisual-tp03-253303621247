package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final CharacterManager manager;
    private final JPanel characterListPanel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager Sprint #4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(AppTheme.COLOR_PRIMARY_BG);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Daftar Karakter", SwingConstants.CENTER);
        titleLabel.setFont(AppTheme.FONT_TITLE);
        titleLabel.setForeground(AppTheme.COLOR_TEXT_DARK);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        characterListPanel = new JPanel();
        characterListPanel.setLayout(new GridLayout(0, 2, 10, 10));
        characterListPanel.setBackground(AppTheme.COLOR_PRIMARY_BG);

        JScrollPane scrollPane = new JScrollPane(characterListPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        renderCharacters();

        pack();
        setLocationRelativeTo(null);
    }

    private void renderCharacters() {
        characterListPanel.removeAll();

        for (Character c : manager.getAllCharacters()) {
            JPanel card = new JPanel();
            card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
            card.setBorder(AppTheme.BORDER_CARD);
            
            card.setBackground(AppTheme.colorForRole(c.getType()));
            card.setOpaque(true);

            JLabel nameLabel = new JLabel("Nama: " + c.getName());
            nameLabel.setFont(AppTheme.FONT_REGULAR);
            nameLabel.setForeground(AppTheme.COLOR_TEXT_DARK);

            JLabel roleLabel = new JLabel("Role: " + c.getType());
            roleLabel.setFont(AppTheme.FONT_REGULAR);
            roleLabel.setForeground(AppTheme.COLOR_TEXT_DARK);

            JLabel levelLabel = new JLabel("Level: " + c.getLevel());
            
            if (c.getLevel() >= AppTheme.HIGH_LEVEL_THRESHOLD) {
                levelLabel.setFont(AppTheme.FONT_GOLD_BOLD);
                levelLabel.setForeground(AppTheme.COLOR_GOLD_HIGHLIGHT);
            } else {
                levelLabel.setFont(AppTheme.FONT_REGULAR);
                levelLabel.setForeground(AppTheme.COLOR_TEXT_DARK);
            }

            card.setToolTipText("Karakter: " + c.getName() + " | Tipe: " + c.getType() + " | Level: " + c.getLevel());

            if (c.getLevel() == 1) {
                card.setEnabled(false);
            }

            card.add(nameLabel);
            card.add(roleLabel);
            card.add(levelLabel);

            characterListPanel.add(card);
        }

        characterListPanel.revalidate();
        characterListPanel.repaint();
    }
}