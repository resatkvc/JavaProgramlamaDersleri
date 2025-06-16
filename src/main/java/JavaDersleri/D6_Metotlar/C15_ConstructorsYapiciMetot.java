package JavaDersleri.D6_Metotlar;

/**
 * Yapıcı Metotlar (Constructors)
 * -----------------------------
 * Bir sınıftan nesne oluşturulurken ilk çalışan özel metotlardır.
 * Sınıf adıyla aynı isme sahiptirler ve dönüş tipi olmaz.
 *
 * - Nesneye ilk değer atamak için kullanılır.
 * - Varsayılan (parametresiz) veya parametreli olabilir.
 *
 * Gerçek projede, nesne oluşturulurken başlangıç değerlerini ayarlamak için kullanılır.
 */
public class C15_ConstructorsYapiciMetot {
    String ad;
    int yas;

    // Yapıcı metot (constructor)
    public C15_ConstructorsYapiciMetot(String ad, int yas) {
        this.ad = ad;
        this.yas = yas;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir öğrenci nesnesi oluşturulurken adı ve yaşı atanır.
     */
    public static void main(String[] args) {
        C15_ConstructorsYapiciMetot ogrenci = new C15_ConstructorsYapiciMetot("Ali", 21);
        System.out.println("Ad: " + ogrenci.ad + ", Yaş: " + ogrenci.yas);
    }
} 