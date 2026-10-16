package com.unpri.charactermanager.model;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO BAGIAN A: IMPLEMENTASI DASAR ===");
        Character c1 = new Character("Arthur", CharacterType.WARRIOR);
        Character c2 = new Character("Merlin", CharacterType.MAGE, 5, 120);
        Character c3 = new Character("Robin", CharacterType.ARCHER);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("\n--- Demo Level Up ---");
        c1.levelUp();
        System.out.println("Setelah Level Up: " + c1);

        System.out.println("\n=== DEMO BAGIAN B: EKSTENSI FITUR MANDIRI ===");
        // Poin 5: Buat 1 karakter baru, set mana, panggil isAlive(), cetak hasil ke console
        Character c4 = new Character("Shadow", CharacterType.NECROMANCER);
        c4.setMana(200);
        
        System.out.println("Karakter Baru: " + c4);
        System.out.println("Apakah " + c4.getName() + " masih hidup? " + c4.isAlive());

        // Pengujian status mati (hitPoints diset ke 0)
        c4.setHitPoints(0);
        System.out.println("Setelah HP diset ke 0, apakah " + c4.getName() + " masih hidup? " + c4.isAlive());

        // Pengujian Validasi Mana Negatif (Picu Exception)
        try {
            System.out.println("\n--- Pengujian Validasi Mana Negatif ---");
            c4.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi Error (Berhasil Ditangkap): " + e.getMessage());
        }
    }
}