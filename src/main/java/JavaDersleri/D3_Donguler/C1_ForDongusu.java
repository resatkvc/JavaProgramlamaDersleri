package JavaDersleri.D3_Donguler;

/**
 * For Döngüsü:
 * - Belirli sayıda tekrar eden işlemler için kullanılır
 * - Başlangıç değeri, bitiş koşulu ve artış/azalış miktarı belirlenebilir
 * - İç içe kullanılarak çok boyutlu işlemler yapılabilir
 * - Diziler ve koleksiyonlar üzerinde işlem yapmak için idealdir
 * - Örnek kullanım alanları: Sayı dizileri, çarpım tabloları, matris işlemleri
 * - Artan veya azalan sırada işlem yapılabilir
 */
public class C1_ForDongusu {
    public static void main(String[] args) {
        // Örnek 1: Basit for döngüsü
        System.out.println("1'den 5'e kadar sayılar:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Örnek 2: Çift sayıları yazdırma
        System.out.println("\n1'den 10'a kadar çift sayılar:");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i);
        }

        // Örnek 3: Azalan döngü
        System.out.println("\n10'dan 1'e kadar sayılar:");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }

        // Örnek 4: İç içe for döngüsü (çarpım tablosu)
        System.out.println("\nÇarpım tablosu (1-3):");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.println(i + " x " + j + " = " + (i * j));
            }
            System.out.println(); // Boş satır ekle
        }

        // Örnek 5: Toplam hesaplama
        int toplam = 0;
        for (int i = 1; i <= 5; i++) {
            toplam += i;
        }
        System.out.println("\n1'den 5'e kadar sayıların toplamı: " + toplam);
    }
}
