package JavaDersleri.D6_Metotlar;

/**
 * Static Alanlar
 * -----------------------------------
 * Static alanlar, sınıfa ait olup tüm nesneler tarafından ortak kullanılır.
 * Nesneye değil, sınıfa aittir. Sınıf adı ile erişilir.
 *
 * Gerçek projede kullanım:
 * - Örneğin bir banka uygulamasında, tüm hesaplar için ortak olan "bankaAdi" static olarak tanımlanabilir.
 */
public class C6_StaticAlanlar {
    public static String bankaAdi = "JavaBank";
    public String hesapSahibi;

    public C6_StaticAlanlar(String hesapSahibi) {
        this.hesapSahibi = hesapSahibi;
    }

    public void hesapBilgisiYazdir() {
        System.out.println("Banka: " + bankaAdi + ", Hesap Sahibi: " + hesapSahibi);
    }

    /**
     * Static alanların kullanımı ile ilgili örnek
     */
    public static void main(String[] args) {
        C6_StaticAlanlar hesap1 = new C6_StaticAlanlar("Ali");
        C6_StaticAlanlar hesap2 = new C6_StaticAlanlar("Ayşe");
        hesap1.hesapBilgisiYazdir();
        hesap2.hesapBilgisiYazdir();
        // Static alanı değiştirmek
        C6_StaticAlanlar.bankaAdi = "YeniJavaBank";
        hesap1.hesapBilgisiYazdir();
        hesap2.hesapBilgisiYazdir();
    }
} 