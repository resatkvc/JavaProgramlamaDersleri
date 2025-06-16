package JavaDersleri.D6_Metotlar;

/**
 * Metot Adlandırma
 * -----------------------------------
 * Metot isimleri, metotun yaptığı işi açıkça ifade etmelidir.
 * Java'da metot isimleri küçük harfle başlar ve camelCase kullanılır (ör: hesaplaToplam, yazdirBilgi).
 *
 * Gerçek projede kullanım:
 * - Anlamlı ve açıklayıcı metot isimleri, kodun okunabilirliğini ve bakımını kolaylaştırır.
 */
public class C9_MetotAdlandirma {
    // Kötü örnek: Anlamsız metot ismi
    public void a() {
        // ...
    }

    // İyi örnek: Anlamlı metot ismi
    public void ogrenciBilgisiYazdir() {
        System.out.println("Öğrenci bilgisi yazdırıldı.");
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir öğrenci yönetim sisteminde, öğrencinin bilgisini yazdıran metot anlamlı bir isimle tanımlanır.
     */
    public static void main(String[] args) {
        C9_MetotAdlandirma ornek = new C9_MetotAdlandirma();
        ornek.ogrenciBilgisiYazdir();
    }
} 