package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Bagian A: Menggunakan SwingUtilities.invokeLater()[cite: 1]
        SwingUtilities.invokeLater(() -> {
            CharacterManager manager = new CharacterManager();

            // Data karakter awal
            manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 15));
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 20));
            manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 12));

            // Bagian B: Menambah minimal 2 karakter baru[cite: 2]
            manager.addCharacter(new Character("Shadow", CharacterType.ASSASSIN, 18));
            manager.addCharacter(new Character("Luna", CharacterType.HEALER, 14));

            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}