package JavaDersleri.D7_Enum;

/**
 * Enum Projede Kullanım Örneği
 * ----------------------------
 * Gerçek bir projede enumlar, sabit durumlar, tipler veya kategoriler için kullanılır.
 * Örneğin bir sipariş yönetim sisteminde siparişin durumu enum ile tanımlanabilir.
 */
public class C2_EnumProjedeKullanimOrnegi {
    // Sipariş durumu için enum
    enum OrderStatus {
        HAZIRLANIYOR, KARGOLANDI, TESLIM_EDILDI, IPTAL_EDILDI
    }

    // Sipariş sınıfı
    static class Siparis {
        String musteriAdi;
        OrderStatus durum;

        public Siparis(String musteriAdi, OrderStatus durum) {
            this.musteriAdi = musteriAdi;
            this.durum = durum;
        }

        public void durumYazdir() {
            System.out.println(musteriAdi + " sipariş durumu: " + durum);
        }
    }

    public static void main(String[] args) {
        Siparis s1 = new Siparis("Ali", OrderStatus.HAZIRLANIYOR);
        Siparis s2 = new Siparis("Ayşe", OrderStatus.KARGOLANDI);
        Siparis s3 = new Siparis("Mehmet", OrderStatus.TESLIM_EDILDI);

        s1.durumYazdir();
        s2.durumYazdir();
        s3.durumYazdir();

        // Enum ile kontrol
        if (s1.durum == OrderStatus.HAZIRLANIYOR) {
            System.out.println("Sipariş henüz hazırlanıyor, iptal edilebilir.");
        }
    }
} 