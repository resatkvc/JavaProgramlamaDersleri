package JavaDersleri.D6_Metotlar;

/**
 * Static Metotlar
 * --------------
 * Static metotlar, nesne oluşturmadan doğrudan sınıf adı ile çağrılabilir.
 * Sınıfa aittir, nesneye özel değildir.
 *
 * - static anahtar kelimesi ile tanımlanır.
 * - Genellikle yardımcı (utility) işlemler için kullanılır.
 *
 * Gerçek projede, genel işlemler veya yardımcı fonksiyonlar için static metotlar kullanılır.
 */
public class C21_StaticMetotlar {
    // Static metot örneği
    public static int kupAl(int sayi) {
        return sayi * sayi * sayi;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Matematiksel işlemler için static metotlar kullanılır.
     */
    public static void main(String[] args) {
        int sonuc = C21_StaticMetotlar.kupAl(3);
        System.out.println("3'ün küpü: " + sonuc);
    }
} 