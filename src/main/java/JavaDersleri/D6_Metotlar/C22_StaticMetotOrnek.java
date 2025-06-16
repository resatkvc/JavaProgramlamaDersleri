package JavaDersleri.D6_Metotlar;

/**
 * Static Metot Kullanımı
 * ---------------------
 * Static metotlar, nesne oluşturmadan doğrudan sınıf adı ile çağrılır.
 * Sınıfa aittir, nesneye özel değildir.
 *
 * - static anahtar kelimesi ile tanımlanır.
 * - Genellikle yardımcı işlemler için kullanılır.
 *
 * Gerçek projede, matematiksel işlemler veya genel yardımcı fonksiyonlar için static metotlar kullanılır.
 */
public class C22_StaticMetotOrnek {
    // Static metot örneği
    public static double daireCevresi(double yaricap) {
        return 2 * Math.PI * yaricap;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Dairenin çevresini hesaplayan yardımcı bir static metot.
     */
    public static void main(String[] args) {
        double cevre = C22_StaticMetotOrnek.daireCevresi(5);
        System.out.println("Dairenin çevresi: " + cevre);
    }
} 