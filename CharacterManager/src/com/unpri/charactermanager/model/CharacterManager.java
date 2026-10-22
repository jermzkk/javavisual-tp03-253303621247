package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private List<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    public void addCharacter(Character c) {
        characterList.add(c);
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    // Perhitungan statistik Rata-rata Level (Bagian B)
    public double getAverageLevel() {
        if (characterList.isEmpty()) return 0.0;
        int total = 0;
        for (Character c : characterList) {
            total += c.getLevel();
        }
        return (double) total / characterList.size();
    }
}