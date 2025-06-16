package JavaDersleri.D6_Metotlar;

/**
 * Nesne Metotları
 * -----------------------------------
 * Nesne metotları, bir nesneye ait olan ve o nesnenin durumunu değiştiren veya bilgi sağlayan fonksiyonlardır.
 *
 * Gerçek projede kullanım:
 * - Nesne metotları, genellikle nesnenin alanlarını (field) okuma, değiştirme veya nesneye özel işlemler yapmak için kullanılır.
 * - Örneğin bir "Araba" nesnesinde "hizlan", "yavasla", "bilgiGoster" gibi metotlar olabilir.
 */
public class C2_NesneMetotlari {
    String marka;
    int hiz;

    public C2_NesneMetotlari(String marka) {
        this.marka = marka;
        this.hiz = 0; // Başlangıçta araba duruyor
    }

    // Nesne metodu: Arabayı hızlandırır
    public void hizlan(int artis) {
        this.hiz += artis;
        System.out.println(marka + " hızlandı. Yeni hız: " + hiz);
    }

    // Nesne metodu: Arabayı yavaşlatır
    public void yavasla(int azalis) {
        this.hiz -= azalis;
        if (hiz < 0) hiz = 0;
        System.out.println(marka + " yavaşladı. Yeni hız: " + hiz);
    }

    // Nesne metodu: Bilgi gösterir
    public void bilgiGoster() {
        System.out.println("Marka: " + marka + ", Hız: " + hiz);
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir araç takip sisteminde, her araç bir nesne olarak tutulur.
     * Kullanıcı aracı hızlandırabilir, yavaşlatabilir ve mevcut bilgileri görebilir.
     */
    public static void main(String[] args) {
        C2_NesneMetotlari araba = new C2_NesneMetotlari("Toyota");
        araba.bilgiGoster(); // Marka: Toyota, Hız: 0
        araba.hizlan(50);
        araba.yavasla(20);
        araba.bilgiGoster(); // Marka: Toyota, Hız: 30
    }
} 