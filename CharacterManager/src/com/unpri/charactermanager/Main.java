package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        // Minimal 6 karakter dengan variasi role dan level
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 7));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 6));
        manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 4));
        manager.addCharacter(new Character("Shadow", CharacterType.ASSASSIN, 8));
        manager.addCharacter(new Character("Luna", CharacterType.HEALER, 5));
        manager.addCharacter(new Character("Novice Tom", CharacterType.WARRIOR, 1));

        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}