package JavaDersleri.D4_Diziler;

import java.util.ArrayList;

public class C3_ArrayList {
    public static void main(String[] args) {
        // ArrayList tanımlama
        ArrayList<String> isimler = new ArrayList<>();

        // ArrayList'e eleman ekleme
        isimler.add("Ali");
        isimler.add("Veli");
        isimler.add("Ayşe");
        isimler.add("Fatma");

        // ArrayList elemanlarını ekrana yazdırma
        System.out.println("ArrayList elemanları:");
        for (String isim : isimler) {
            System.out.println(isim);
        }

        // Belirli bir index'teki elemanı alma
        System.out.println("\n2. indexteki eleman: " + isimler.get(2));

        // Eleman sayısı
        System.out.println("ArrayList boyutu: " + isimler.size());

        // Eleman silme
        isimler.remove("Veli");
        System.out.println("\n'Veli' silindikten sonra:");
        for (String isim : isimler) {
            System.out.println(isim);
        }

        // ArrayList'te eleman arama
        boolean varMi = isimler.contains("Ayşe");
        System.out.println("\n'Ayşe' var mı? " + varMi);

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir ürün listesi uygulaması - ürün ekleme, arama, silme ve listeleme
        // -----------------------------
        ArrayList<String> urunler = new ArrayList<>();
        urunler.add("Bilgisayar");
        urunler.add("Telefon");
        urunler.add("Tablet");
        urunler.add("Klavye");

        // Ürün arama
        String aranan = "Telefon";
        if (urunler.contains(aranan)) {
            System.out.println("\nAranan ürün bulundu: " + aranan);
        } else {
            System.out.println("\nAranan ürün bulunamadı: " + aranan);
        }

        // Ürün silme
        urunler.remove("Tablet");
        System.out.println("\nGüncel ürün listesi:");
        for (String urun : urunler) {
            System.out.println(urun);
        }
    }
} 