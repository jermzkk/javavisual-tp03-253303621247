package com.unpri.charactermanager.model;

import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    // Bagian D No 3: Field static untuk menghitung total karakter yang dibuat
    public static int totalCharacterCreated = 0;

    private List<Character> characterList;

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    // ==========================================
    // BAGIAN A — IMPLEMENTASI CORE
    // ==========================================

    // Bagian A No 2 & 3: Menambah Karakter & Menolak Duplikat Nama
    public boolean addCharacter(Character c) {
        if (c == null) return false;

        for (Character existing : characterList) {
            if (existing.equals(c)) {
                System.out.println("[ERROR] Gagal menambahkan: Karakter dengan nama '" + c.getName() + "' sudah ada!");
                return false;
            }
        }

        // Simpan menggunakan defensive copy
        characterList.add(new Character(c));
        totalCharacterCreated++;
        System.out.println("[SUCCESS] Karakter '" + c.getName() + "' berhasil ditambahkan.");
        return true;
    }

    // Bagian A No 2: Mencari Karakter Berdasarkan Nama
    public Character findByName(String name) {
        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return new Character(c); // Return defensive copy
            }
        }
        return null;
    }

    // Bagian A No 2: Menghapus Karakter Berdasarkan Nama
    public boolean removeCharacter(String name) {
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).getName().equalsIgnoreCase(name)) {
                characterList.remove(i);
                System.out.println("[SUCCESS] Karakter '" + name + "' berhasil dihapus.");
                return true;
            }
        }
        System.out.println("[ERROR] Karakter '" + name + "' tidak ditemukan untuk dihapus.");
        return false;
    }

    // Bagian A No 2: Total Karakter di Manager
    public int getTotalCharacters() {
        return characterList.size();
    }

    // Bagian A No 4: Defensive Copy untuk Mengembalikan List
    public List<Character> getAllCharacters() {
        List<Character> copyList = new ArrayList<>();
        for (Character c : characterList) {
            copyList.add(new Character(c));
        }
        return copyList;
    }

    // ==========================================
    // BAGIAN B — MINI-CHALLENGE
    // ==========================================

    // Bagian B No 1: Menghitung Rata-Rata Level (Aman dari pembagian dengan 0)
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Character c : characterList) {
            sum += c.getLevel();
        }
        return sum / characterList.size();
    }

    // Bagian B No 2: Mencari Berdasarkan Tipe
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(new Character(c)); // Defensive copy
            }
        }
        return result;
    }

    // ==========================================
    // BAGIAN C — FITUR ANALITIK MANDIRI
    // ==========================================

    /**
     * Mencari dan mengembalikan karakter dengan level tertinggi.
     * Method ini menjaga encapsulation dengan mengembalikan salinan objek (defensive copy).
     *
     * @return Objek Character dengan level tertinggi, atau null jika list kosong.
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }
        Character strongest = characterList.get(0);
        for (Character c : characterList) {
            if (c.getLevel() > strongest.getLevel()) {
                strongest = c;
            }
        }
        return new Character(strongest); // Defensive copy
    }
}