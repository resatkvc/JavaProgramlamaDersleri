package JavaDersleri.D6_Metotlar;

/**
 * Metot İmzası Nedir?
 * -------------------
 * Bir metodu diğerlerinden ayıran, metot adı ve parametre listesinin birleşimidir.
 * Aynı isimde birden fazla metot tanımlanabilir (overloading), ancak imzaları farklı olmalıdır.
 *
 * Metot imzası şunlardan oluşur:
 * - Metot adı
 * - Parametre sayısı ve türleri
 *
 * Dönüş tipi metot imzasına dahil değildir!
 *
 * Örnekler:
 * void yazdir(String mesaj)   --> imza: yazdir(String)
 * int topla(int a, int b)     --> imza: topla(int, int)
 * double hesapla(double x)    --> imza: hesapla(double)
 *
 * Gerçek projede, aynı işlemi farklı parametrelerle yapmak için metot imzası kullanılır.
 */
public class C10_MetotImzasi {
    // Metot imzası örnekleri
    public void yazdir(String mesaj) {
        System.out.println(mesaj);
    }

    public int topla(int a, int b) {
        return a + b;
    }

    public double hesapla(double x) {
        return x * x;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir hesap makinesi uygulamasında, farklı işlemler için farklı imzalar kullanılır.
     */
    public static void main(String[] args) {
        C10_MetotImzasi ornek = new C10_MetotImzasi();
        ornek.yazdir("Merhaba!");
        System.out.println("Toplam: " + ornek.topla(3, 5));
        System.out.println("Karesi: " + ornek.hesapla(4));
    }
} 