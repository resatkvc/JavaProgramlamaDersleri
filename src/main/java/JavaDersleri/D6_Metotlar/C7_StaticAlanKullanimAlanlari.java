package JavaDersleri.D6_Metotlar;

/**
 * Static Alan Kullanım Alanları
 * -----------------------------------
 * Static alanlar, tüm nesneler için ortak olan verileri saklamak için kullanılır.
 * Sınıf adı ile erişilir, nesneye özel değildir.
 *
 * Gerçek projede kullanım:
 * - Sayaç (counter), sabitler, uygulama genelinde ortak ayarlar gibi alanlar static olarak tanımlanır.
 */
public class C7_StaticAlanKullanimAlanlari {
    // Tüm nesneler için ortak sayaç
    public static int nesneSayisi = 0;
    public String isim;

    public C7_StaticAlanKullanimAlanlari(String isim) {
        this.isim = isim;
        nesneSayisi++; // Her nesne oluşturulduğunda sayaç artar
    }

    public void bilgiYazdir() {
        System.out.println("İsim: " + isim + ", Toplam nesne: " + nesneSayisi);
    }

    /**
     * Static alanların kullanımına örnek
     */
    public static void main(String[] args) {
        C7_StaticAlanKullanimAlanlari n1 = new C7_StaticAlanKullanimAlanlari("A");
        C7_StaticAlanKullanimAlanlari n2 = new C7_StaticAlanKullanimAlanlari("B");
        n1.bilgiYazdir(); // Toplam nesne: 2
        n2.bilgiYazdir(); // Toplam nesne: 2
        System.out.println("Toplam nesne sayısı: " + C7_StaticAlanKullanimAlanlari.nesneSayisi);
    }
} 