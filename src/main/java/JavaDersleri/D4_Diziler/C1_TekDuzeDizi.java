package JavaDersleri.D4_Diziler;

public class C1_TekDuzeDizi {
    public static void main(String[] args) {
        // Tek boyutlu dizi tanımlama
        int[] sayilar = new int[5]; // 5 elemanlı bir int dizisi oluşturduk
        // Diziye değer atama
        sayilar[0] = 10;
        sayilar[1] = 20;
        sayilar[2] = 30;
        sayilar[3] = 40;
        sayilar[4] = 50;

        // Dizi elemanlarını ekrana yazdırma
        System.out.println("Dizi elemanları:");
        for (int i = 0; i < sayilar.length; i++) {
            System.out.println("sayilar[" + i + "] = " + sayilar[i]);
        }

        // Dizi tanımlama ve başlatma (kısa yol)
        String[] isimler = {"Ali", "Veli", "Ayşe", "Fatma"};
        System.out.println("\nİsimler dizisi:");
        for (String isim : isimler) {
            System.out.println(isim);
        }

        // Dizi uzunluğu
        System.out.println("\nDizinin uzunluğu: " + isimler.length);

        // Dizi elemanlarını toplama örneği
        int toplam = 0;
        for (int sayi : sayilar) {
            toplam += sayi;
        }
        System.out.println("\nDizi elemanlarının toplamı: " + toplam);

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir sınıftaki öğrencilerin notlarını diziyle tutup, ortalama hesaplama ve geçenleri listeleme
        // -----------------------------
        int[] ogrenciNotlari = {45, 78, 90, 62, 55, 30, 100, 85};
        String[] ogrenciIsimleri = {"Ali", "Veli", "Ayşe", "Fatma", "Mehmet", "Zeynep", "Can", "Elif"};

        // Ortalama hesaplama
        int toplamNot = 0;
        for (int not : ogrenciNotlari) {
            toplamNot += not;
        }
        double ortalama = (double) toplamNot / ogrenciNotlari.length;
        System.out.println("\nSınıfın not ortalaması: " + ortalama);

        // Geçen öğrencileri listeleme (geçme notu: 60)
        System.out.println("\nSınıfı geçen öğrenciler:");
        for (int i = 0; i < ogrenciNotlari.length; i++) {
            if (ogrenciNotlari[i] >= 60) {
                System.out.println(ogrenciIsimleri[i] + " - Notu: " + ogrenciNotlari[i]);
            }
        }
    }
} 