package JavaDersleri.D6_Metotlar;

/**
 * Metotlarda Aşırı Yükleme (Overloading)
 * --------------------------------------
 * Aynı isimde birden fazla metot tanımlanabilir, ancak parametre listeleri farklı olmalıdır.
 * Bu işleme metotlarda aşırı yükleme (overloading) denir.
 *
 * - Parametre sayısı veya türü farklı olmalıdır.
 * - Dönüş tipi tek başına overloading için yeterli değildir.
 *
 * Gerçek projede, aynı işlemi farklı veri tipleri veya parametrelerle yapmak için kullanılır.
 */
public class C18_OverloadingAsiriYukleme {
    // Overloading örnekleri
    public int topla(int a, int b) {
        return a + b;
    }

    public double topla(double a, double b) {
        return a + b;
    }

    public int topla(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Hesap makinesi uygulamasında, farklı tip ve sayıda parametrelerle toplama işlemi yapılabilir.
     */
    public static void main(String[] args) {
        C18_OverloadingAsiriYukleme ornek = new C18_OverloadingAsiriYukleme();
        System.out.println("Toplam (int): " + ornek.topla(2, 3));
        System.out.println("Toplam (double): " + ornek.topla(2.5, 3.7));
        System.out.println("Toplam (3 int): " + ornek.topla(1, 2, 3));
    }
} 