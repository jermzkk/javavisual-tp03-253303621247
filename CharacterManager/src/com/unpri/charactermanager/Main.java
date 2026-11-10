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

<<<<<<< HEAD
            MainWindow window = new MainWindow(list);
=======
            // Data karakter awal
            manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 15));
            manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 20));
            manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 12));

            // Bagian B: Menambah minimal 2 karakter baru[cite: 2]
            manager.addCharacter(new Character("Shadow", CharacterType.ASSASSIN, 18));
            manager.addCharacter(new Character("Luna", CharacterType.HEALER, 14));
            manager.addCharacter(new Character("Artemis",   CharacterType.ARCHER,  6));
            manager.addCharacter(new Character("Bima",      CharacterType.WARRIOR, 8));
            manager.addCharacter(new Character("Circe",     CharacterType.MAGE,    2));

            MainWindow window = new MainWindow(manager.getCharacterList());
>>>>>>> sprint-5-layout
            window.setVisible(true);


            
        });
    }
}