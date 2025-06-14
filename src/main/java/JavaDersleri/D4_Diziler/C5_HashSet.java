package JavaDersleri.D4_Diziler;

import java.util.HashSet;

public class C5_HashSet {
    public static void main(String[] args) {
        // HashSet tanımlama
        HashSet<String> renkler = new HashSet<>();

        // HashSet'e eleman ekleme
        renkler.add("Kırmızı");
        renkler.add("Mavi");
        renkler.add("Yeşil");
        renkler.add("Sarı");
        renkler.add("Mavi"); // Aynı eleman tekrar eklenirse eklenmez

        // HashSet elemanlarını ekrana yazdırma
        System.out.println("HashSet elemanları:");
        for (String renk : renkler) {
            System.out.println(renk);
        }

        // Eleman var mı kontrolü
        boolean varMi = renkler.contains("Yeşil");
        System.out.println("\n'Yeşil' var mı? " + varMi);

        // Eleman silme
        renkler.remove("Sarı");
        System.out.println("\n'Sarı' silindikten sonra:");
        for (String renk : renkler) {
            System.out.println(renk);
        }

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir etkinliğe katılanların listesini tutma, tekrar eden kayıtları engelleme ve katılımcı kontrolü
        // -----------------------------
        HashSet<String> katilimcilar = new HashSet<>();
        katilimcilar.add("Ali");
        katilimcilar.add("Veli");
        katilimcilar.add("Ayşe");
        katilimcilar.add("Ali"); // Tekrar eklenmeyecek

        // Katılımcı kontrolü
        String kontrol = "Ayşe";
        if (katilimcilar.contains(kontrol)) {
            System.out.println("\n" + kontrol + " etkinliğe katılmış.");
        } else {
            System.out.println("\n" + kontrol + " etkinliğe katılmamış.");
        }

        // Katılımcı listesini yazdırma
        System.out.println("\nEtkinliğe katılanlar:");
        for (String kisi : katilimcilar) {
            System.out.println(kisi);
        }
    }
} 