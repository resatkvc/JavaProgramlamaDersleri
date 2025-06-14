package JavaDersleri.D4_Diziler;

public class C2_CokBoyutluDizi {
    public static void main(String[] args) {
        // 2 boyutlu dizi tanımlama
        int[][] matris = new int[3][4]; // 3 satır, 4 sütunlu bir matris

        // Diziye değer atama
        matris[0][0] = 1;
        matris[0][1] = 2;
        matris[0][2] = 3;
        matris[0][3] = 4;
        matris[1][0] = 5;
        matris[1][1] = 6;
        matris[1][2] = 7;
        matris[1][3] = 8;
        matris[2][0] = 9;
        matris[2][1] = 10;
        matris[2][2] = 11;
        matris[2][3] = 12;

        // 2 boyutlu diziyi ekrana yazdırma
        System.out.println("Matrisin elemanları:");
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }

        // 2 boyutlu dizi tanımlama ve başlatma (kısa yol)
        int[][] tablo = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("\nTablo dizisi:");
        for (int[] satir : tablo) {
            for (int eleman : satir) {
                System.out.print(eleman + " ");
            }
            System.out.println();
        }

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir sınıftaki öğrencilerin 3 sınav notunu tablo şeklinde tutup, her öğrencinin ortalamasını bulma
        // -----------------------------
        String[] ogrenciler = {"Ali", "Veli", "Ayşe", "Fatma"};
        int[][] sinavNotlari = {
            {70, 80, 90},   // Ali
            {60, 75, 70},   // Veli
            {90, 95, 100},  // Ayşe
            {50, 60, 55}    // Fatma
        };

        for (int i = 0; i < ogrenciler.length; i++) {
            int toplam = 0;
            for (int j = 0; j < sinavNotlari[i].length; j++) {
                toplam += sinavNotlari[i][j];
            }
            double ortalama = (double) toplam / sinavNotlari[i].length;
            System.out.println(ogrenciler[i] + " adlı öğrencinin ortalaması: " + ortalama);
        }
    }
} 