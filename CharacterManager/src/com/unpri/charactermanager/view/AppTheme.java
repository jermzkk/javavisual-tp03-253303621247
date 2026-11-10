package com.unpri.charactermanager.view;

import java.awt.Color;                       // kelas warna AWT
import java.awt.Font;                        // kelas font AWT
import javax.swing.BorderFactory;            // pabrik border
import javax.swing.border.Border;            // tipe objek border
import com.unpri.charactermanager.model.CharacterType; // enum dari Model (View boleh membaca Model)

<<<<<<< HEAD
public class AppTheme {
    public static final int HIGH_LEVEL_THRESHOLD = 5;

    public static final Color COLOR_PRIMARY_BG = new Color(245, 247, 250);
    public static final Color COLOR_TEXT_DARK = new Color(33, 37, 41);
    public static final Color COLOR_GOLD_HIGHLIGHT = new Color(184, 134, 11);

    public static final Font FONT_TITLE = new Font(Font.SANS_SERIF, Font.BOLD, 18);
    public static final Font FONT_REGULAR = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
    public static final Font FONT_GOLD_BOLD = new Font(Font.SANS_SERIF, Font.BOLD, 13);

    public static final Border BORDER_CARD = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(210, 215, 220), 1),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    );

    public static Color colorForRole(Object role) {
        if (role == null) return Color.WHITE;
        String roleStr = role.toString().toUpperCase();
        switch (roleStr) {
            case "WARRIOR":
                return new Color(255, 230, 230);
            case "MAGE":
                return new Color(230, 230, 255);
            case "ARCHER":
                return new Color(230, 255, 230);
            case "ASSASSIN":
                return new Color(255, 240, 200);
            case "HEALER":
                return new Color(240, 230, 255);
            default:
                return new Color(240, 240, 240);
=======
/**
 * Pusat gaya tampilan Character Manager.
 * Mengubah tema aplikasi cukup dengan mengedit file ini.
 */
public final class AppTheme {

    // ---------- Palet warna ----------
    public static final Color BG_MAIN    = Color.decode("#13131f"); // latar jendela: hampir hitam
    public static final Color TEXT_MAIN  = Color.decode("#dfe6e9"); // teks utama: abu terang
    public static final Color TEXT_LIGHT = Color.WHITE;             // teks di atas kartu berwarna
    public static final Color GOLD       = Color.decode("#fdcb6e"); // aksen untuk karakter level tinggi

    // ---------- Font ----------
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 22);   // judul layar
    public static final Font FONT_BODY  = new Font("SansSerif", Font.PLAIN, 14);  // isi kartu
    public static final Font FONT_MONO  = new Font("Monospaced", Font.PLAIN, 13); // angka sejajar

    // ---------- Border ----------
    // Border bersifat immutable, jadi aman dipakai ulang oleh banyak komponen.
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12); // atas, kiri, bawah, kanan

    private AppTheme() { }  // class utilitas: konstruktor private mencegah new AppTheme()

    /** Menerjemahkan role (data Model) menjadi warna kartu (urusan View). */
    public static Color colorFor(CharacterType type) {
        switch (type) {
            case WARRIOR: return Color.decode("#d63031"); // merah
            case MAGE:    return Color.decode("#0984e3"); // biru
            case ARCHER:  return Color.decode("#00b894"); // hijau
            default:      return Color.GRAY;              // cadangan bila ada role baru
>>>>>>> sprint-5-layout
        }
    }

    /** Teks tooltip per role. */
    public static String describe(CharacterType type) {
        switch (type) {
            case WARRIOR: return "Warrior: jarak dekat, HP tinggi";
            case MAGE:    return "Mage: serangan sihir, HP rendah";
            case ARCHER:  return "Archer: jarak jauh, seimbang";
            default:      return "Role belum terdaftar";
        }
    }

    public static final Color BG_STATUS  = Color.decode("#0d0d1a"); // latar bar status: lebih gelap
    public static final Color TEXT_MUTED = Color.decode("#9d9dbf"); // teks sekunder / metadata
}