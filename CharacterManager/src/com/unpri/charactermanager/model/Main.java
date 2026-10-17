package com.unpri.charactermanager.model;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        System.out.println("==========================================");
        System.out.println("BAGIAN A: UJI IMPLEMENTASI CORE");
        System.out.println("==========================================");

        // 1. Uji Tambah & Penolakan Duplikat
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 10));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 15));

        System.out.println("\n--- Menguji Penolakan Nama Duplikat ---");
        manager.addCharacter(new Character("Arthur", CharacterType.ARCHER, 25)); // Harus ditolak

        // 2. Uji findByName & removeCharacter
        System.out.println("\n--- Menguji Pencarian & Penghapusan ---");
        System.out.println("Cari 'Merlin': " + manager.findByName("Merlin"));
        manager.removeCharacter("Merlin");
        System.out.println("Total Karakter Sekarang: " + manager.getTotalCharacters());

        // 3. Eksperimen Halaman 7 (Defensive Copying getAllCharacters)
        System.out.println("\n--- Eksperimen Defensive Copying (getAllCharacters) ---");
        List<Character> listCopy = manager.getAllCharacters();
        System.out.println("Jumlah awal pada list salinan: " + listCopy.size());

        System.out.println("Mengosongkan list salinan (listCopy.clear())...");
        listCopy.clear();

        System.out.println("Ukuran list salinan setelah clear: " + listCopy.size());
        System.out.println("Ukuran list asli di Manager: " + manager.getTotalCharacters()); // Harus tetap utuh


        System.out.println("\n==========================================");
        System.out.println("BAGIAN B: UJI MINI-CHALLENGE");
        System.out.println("==========================================");

        manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 12));
        manager.addCharacter(new Character("Gandalf", CharacterType.MAGE, 50));

        // 1. Uji getAverageLevel
        System.out.println("\nRata-rata level saat ini: " + manager.getAverageLevel());

        // Uji Edge Case List Kosong
        CharacterManager emptyManager = new CharacterManager();
        System.out.println("Rata-rata level (List Kosong): " + emptyManager.getAverageLevel());

        // 2. Uji findByType
        System.out.println("\nKarakter dengan Tipe MAGE:");
        for (Character c : manager.findByType(CharacterType.MAGE)) {
            System.out.println(" - " + c);
        }


        System.out.println("\n==========================================");
        System.out.println("BAGIAN C: UJI FITUR ANALITIK MANDIRI");
        System.out.println("==========================================");

        // Uji findStrongest
        System.out.println("Karakter Terkuat saat ini: " + manager.findStrongest());
        System.out.println("Total seluruh instance karakter yang pernah dibuat: " + CharacterManager.totalCharacterCreated);
    }
}