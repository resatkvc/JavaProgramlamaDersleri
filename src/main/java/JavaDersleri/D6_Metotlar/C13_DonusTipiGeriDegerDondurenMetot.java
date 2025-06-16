package JavaDersleri.D6_Metotlar;

/**
 * Geri Değer Döndüren Metotlar
 * ---------------------------
 * Bir metot, çalışmasını tamamladığında bir değer döndürebilir.
 * Bu durumda, metot tanımında dönüş tipi belirtilir (ör: int, double, String).
 *
 * - return anahtar kelimesi ile değer döndürülür.
 * - Döndürülen değerin tipi, metot tanımındaki dönüş tipiyle aynı olmalıdır.
 *
 * Gerçek projede, hesaplama, veri çekme veya işlem sonucu döndürmek için kullanılır.
 */
public class C13_DonusTipiGeriDegerDondurenMetot {
    // Geri değer döndüren metot örneği
    public double alanHesapla(double yaricap) {
        return Math.PI * yaricap * yaricap;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir dairenin alanını hesaplayan metot, sonucu döndürür.
     */
    public static void main(String[] args) {
        C13_DonusTipiGeriDegerDondurenMetot ornek = new C13_DonusTipiGeriDegerDondurenMetot();
        double alan = ornek.alanHesapla(5);
        System.out.println("Dairenin alanı: " + alan);
    }
} 