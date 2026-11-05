package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Character> list = new ArrayList<>();
            
            // Minimal 8 karakter variatif dengan urutan parameter yang benar: (Name, Type, Level)
            list.add(new Character("Arthur", CharacterType.WARRIOR, 45));
            list.add(new Character("Merlin", CharacterType.MAGE, 50));
            list.add(new Character("Robin", CharacterType.ARCHER, 30));
            list.add(new Character("Shadow", CharacterType.ASSASSIN, 25));
            list.add(new Character("Galahad", CharacterType.WARRIOR, 40));
            list.add(new Character("Gandalf", CharacterType.MAGE, 50));
            list.add(new Character("Legolas", CharacterType.ARCHER, 35));
            list.add(new Character("Ezio", CharacterType.ASSASSIN, 28));

            MainWindow window = new MainWindow(list);
            window.setVisible(true);
        });
    }
}