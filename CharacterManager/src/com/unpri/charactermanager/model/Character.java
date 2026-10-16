package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // Poin 1: Atribut private baru (mana)

    // Constructor 1: Default Level 1 & Mana Default 50
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.mana = 50;
        calculateStats();
    }

    // Constructor 2: Custom Level dan Mana
    public Character(String name, CharacterType type, int level, int mana) {
        this.name = name;
        this.type = type;
        setLevel(level);
        setMana(mana);
    }

    private void calculateStats() {
        this.hitPoints = this.level * 100;
        this.attackPower = this.level * 15;
    }

    // Poin 2: Getter & Setter Mana dengan Validasi IllegalArgumentException
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    // Poin 3: Method isAlive() -> true jika hitPoints > 0
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level tidak boleh kurang dari 1!");
        }
        this.level = level;
        calculateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void levelUp() {
        this.level++;
        calculateStats();
        System.out.println(this.name + " berhasil naik ke Level " + this.level + "!");
    }

    // Poin 4: toString() diperbarui untuk menampilkan mana
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                ", mana=" + mana +
                '}';
    }
}