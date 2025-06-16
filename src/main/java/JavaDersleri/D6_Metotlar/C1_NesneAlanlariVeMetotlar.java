package JavaDersleri.D6_Metotlar;

/**
 * Nesne Alanları ve Metotlar
 * -----------------------------------
 * Bir sınıfın (class) sahip olduğu değişkenlere "alan" (field, property) denir.
 * Sınıfın işlevlerini tanımlayan fonksiyonlara ise "metot" (method) denir.
 *
 * Gerçek projede kullanım:
 * - Alanlar, nesnenin durumunu (state) tutar. Örneğin bir "Ogrenci" nesnesinin adı, numarası, notu gibi.
 * - Metotlar ise nesneye davranış (davranış = behavior) kazandırır. Örneğin "notGuncelle", "bilgiYazdir" gibi.
 *
 * Alan ve metotlar, nesne tabanlı programlamanın temelini oluşturur.
 */
public class C1_NesneAlanlariVeMetotlar {
    // Alanlar (fields)
    String ad;
    int yas;
    double notOrtalamasi;

    // Yapıcı metot (constructor)
    public C1_NesneAlanlariVeMetotlar(String ad, int yas, double notOrtalamasi) {
        this.ad = ad;
        this.yas = yas;
        this.notOrtalamasi = notOrtalamasi;
    }

    // Nesneye ait bir metot (davranış)
    public void bilgiYazdir() {
        System.out.println("Ad: " + ad + ", Yaş: " + yas + ", Not Ortalaması: " + notOrtalamasi);
    }

    // Not güncelleyen metot
    public void notGuncelle(double yeniNot) {
        this.notOrtalamasi = yeniNot;
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir öğrenci yönetim sistemi uygulamasında, her öğrenci bir nesne olarak tutulur.
     * Alanlar: ad, yas, notOrtalamasi
     * Metotlar: bilgiYazdir, notGuncelle
     */
    public static void main(String[] args) {
        C1_NesneAlanlariVeMetotlar ogrenci = new C1_NesneAlanlariVeMetotlar("Ayşe", 20, 85.5);
        ogrenci.bilgiYazdir(); // Ad: Ayşe, Yaş: 20, Not Ortalaması: 85.5
        ogrenci.notGuncelle(90.0);
        ogrenci.bilgiYazdir(); // Ad: Ayşe, Yaş: 20, Not Ortalaması: 90.0
    }
} 