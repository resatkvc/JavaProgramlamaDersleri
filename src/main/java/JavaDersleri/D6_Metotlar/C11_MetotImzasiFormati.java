package JavaDersleri.D6_Metotlar;

/**
 * Metot İmzası Formatı
 * --------------------
 * Bir metot tanımlanırken, imza şu formatta olur:
 *
 * [erişim belirleyici] [dönüş tipi] [metot adı] ([parametre listesi])
 *
 * - Erişim belirleyici: public, private, protected, (veya hiçbiri)
 * - Dönüş tipi: void, int, double, String, vs.
 * - Metot adı: Küçük harfle başlar, camelCase kullanılır
 * - Parametre listesi: Parantez içinde, tür ve isim olarak yazılır
 *
 * Not: Sadece metot adı ve parametreler imzayı oluşturur.
 *
 * Örnek format:
 * public int topla(int a, int b)
 *
 * Gerçek projede, metot imzası kodun okunabilirliğini ve bakımını kolaylaştırır.
 */
public class C11_MetotImzasiFormati {
    // Metot imzası formatı örneği
    public int topla(int a, int b) {
        return a + b;
    }

    public void yazdir(String mesaj) {
        System.out.println(mesaj);
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir toplama ve yazdırma işlemi için farklı imzalar kullanılır.
     */
    public static void main(String[] args) {
        C11_MetotImzasiFormati ornek = new C11_MetotImzasiFormati();
        System.out.println("Toplam: " + ornek.topla(10, 20));
        ornek.yazdir("İşlem tamamlandı.");
    }
} 