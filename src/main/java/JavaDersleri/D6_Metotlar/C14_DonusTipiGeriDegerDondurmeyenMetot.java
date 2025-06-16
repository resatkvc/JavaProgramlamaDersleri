package JavaDersleri.D6_Metotlar;

/**
 * Geri Değer Döndürmeyen Metotlar
 * ------------------------------
 * Bir metot, çalışmasını tamamladığında değer döndürmek zorunda değildir.
 * Bu durumda, metot tanımında dönüş tipi void olarak belirtilir.
 *
 * - void: Hiçbir değer döndürmez.
 * - return anahtar kelimesi kullanılmaz veya sadece metottan çıkmak için kullanılır.
 *
 * Gerçek projede, ekrana yazdırma, veri güncelleme gibi işlemler için kullanılır.
 */
public class C14_DonusTipiGeriDegerDondurmeyenMetot {
    // Geri değer döndürmeyen metot örneği
    public void selamla(String isim) {
        System.out.println("Merhaba, " + isim + "!");
    }

    /**
     * Gerçek projede kullanım örneği:
     * Kullanıcıya selam veren bir metot, değer döndürmez.
     */
    public static void main(String[] args) {
        C14_DonusTipiGeriDegerDondurmeyenMetot ornek = new C14_DonusTipiGeriDegerDondurmeyenMetot();
        ornek.selamla("Ayşe");
    }
} 