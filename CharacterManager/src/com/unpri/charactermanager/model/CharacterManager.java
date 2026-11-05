package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterManager {
    private final List<Character> characters;

    public CharacterManager() {
        this.characters = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        if (character != null) {
            characters.add(character);
        }
    }

    public List<Character> getAllCharacters() {
        List<Character> copyList = new ArrayList<>();
        for (Character c : characters) {
            copyList.add(new Character(c));
        }
        return Collections.unmodifiableList(copyList);
    }
}