package JavaDersleri.D6_Metotlar;

/**
 * Parametreli Yapıcı Metot
 * -----------------------
 * Yapıcı metotlar, parametre alarak nesneye ilk değerleri atayabilir.
 * Birden fazla parametreli yapıcı tanımlanabilir (overloading).
 *
 * - Parametreli yapıcı, nesne oluşturulurken gerekli bilgileri alır.
 *
 * Gerçek projede, nesne oluşturulurken zorunlu alanların atanmasını sağlamak için kullanılır.
 */
public class C17_ConstructorsParametreliYapiciOrnegi {
    String urunAdi;
    double fiyat;

    // Parametreli yapıcı
    public C17_ConstructorsParametreliYapiciOrnegi(String urunAdi, double fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Ürün nesnesi oluşturulurken adı ve fiyatı atanır.
     */
    public static void main(String[] args) {
        C17_ConstructorsParametreliYapiciOrnegi urun = new C17_ConstructorsParametreliYapiciOrnegi("Kalem", 12.5);
        System.out.println("Ürün: " + urun.urunAdi + ", Fiyat: " + urun.fiyat);
    }
} 