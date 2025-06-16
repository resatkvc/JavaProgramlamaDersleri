package JavaDersleri.D6_Metotlar;

/**
 * Metotlarda Dönüş Tipi
 * ---------------------
 * Bir metot, çalışmasını tamamladığında bir değer döndürebilir veya döndürmeyebilir.
 * Dönüş tipi, metot tanımında dönüş değerinin türünü belirtir.
 *
 * - Eğer metot bir değer döndürüyorsa, dönüş tipi o değerin türü olur (ör: int, double, String).
 * - Eğer metot değer döndürmüyorsa, dönüş tipi void olur.
 *
 * Dönüş tipi, metot imzasının bir parçası değildir, ancak metot tanımında zorunludur.
 *
 * Gerçek projede, metotlardan hesaplama sonucu, veri veya işlem sonucu döndürmek için dönüş tipi kullanılır.
 */
public class C12_DonusTipi {
    // Dönüş tipi örnekleri
    public int topla(int a, int b) {
        return a + b;
    }

    public void yazdir(String mesaj) {
        System.out.println(mesaj);
    }

    /**
     * Gerçek projede kullanım örneği:
     * Hesaplama yapan metotlar genellikle değer döndürür, ekrana yazdıranlar void olur.
     */
    public static void main(String[] args) {
        C12_DonusTipi ornek = new C12_DonusTipi();
        int sonuc = ornek.topla(7, 8);
        ornek.yazdir("Toplam: " + sonuc);
    }
} 