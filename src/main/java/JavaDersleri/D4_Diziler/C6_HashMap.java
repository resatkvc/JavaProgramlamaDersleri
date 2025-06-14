package JavaDersleri.D4_Diziler;

import java.util.HashMap;

public class C6_HashMap {
    public static void main(String[] args) {
        // HashMap tanımlama
        HashMap<String, Integer> notlar = new HashMap<>();

        // HashMap'e anahtar-değer ekleme
        notlar.put("Ali", 90);
        notlar.put("Veli", 85);
        notlar.put("Ayşe", 95);
        notlar.put("Fatma", 80);

        // HashMap elemanlarını ekrana yazdırma
        System.out.println("HashMap elemanları:");
        for (String isim : notlar.keySet()) {
            System.out.println(isim + ": " + notlar.get(isim));
        }

        // Belirli bir anahtarın değerini alma
        System.out.println("\nAyşe'nin notu: " + notlar.get("Ayşe"));

        // Anahtar var mı kontrolü
        boolean varMi = notlar.containsKey("Veli");
        System.out.println("'Veli' anahtarı var mı? " + varMi);

        // Değer var mı kontrolü
        boolean degerVarMi = notlar.containsValue(100);
        System.out.println("100 değeri var mı? " + degerVarMi);

        // Eleman silme
        notlar.remove("Fatma");
        System.out.println("\n'Fatma' silindikten sonra:");
        for (String isim : notlar.keySet()) {
            System.out.println(isim + ": " + notlar.get(isim));
        }

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir ürün stoğu uygulaması - ürün adı ve stok miktarı ile stok güncelleme ve raporlama
        // -----------------------------
        HashMap<String, Integer> stoklar = new HashMap<>();
        stoklar.put("Bilgisayar", 10);
        stoklar.put("Telefon", 5);
        stoklar.put("Tablet", 0);

        // Stok güncelleme (ürün satışı)
        String satilanUrun = "Telefon";
        if (stoklar.containsKey(satilanUrun) && stoklar.get(satilanUrun) > 0) {
            stoklar.put(satilanUrun, stoklar.get(satilanUrun) - 1);
            System.out.println("\n" + satilanUrun + " satıldı. Yeni stok: " + stoklar.get(satilanUrun));
        } else {
            System.out.println("\n" + satilanUrun + " stokta yok!");
        }

        // Stok raporu
        System.out.println("\nGüncel stok durumu:");
        for (String urun : stoklar.keySet()) {
            System.out.println(urun + ": " + stoklar.get(urun));
        }
    }
} 