package JavaDersleri.D8_OOP_Modelleme;

/**
 * Gerçek Projede OOP Modelleme Örneği
 * -----------------------------------
 * E-ticaret sisteminde temel nesneler: Ürün, Müşteri, Sipariş.
 * Sınıflar arası ilişki ve OOP'nin avantajları örneklenir.
 */
public class C5_ProjeModellemeOrnegi {
    // Ürün sınıfı: Bir ürünün adı ve fiyatı vardır
    static class Urun {
        String ad;
        double fiyat;
        public Urun(String ad, double fiyat) {
            this.ad = ad;
            this.fiyat = fiyat;
        }
    }
    // Müşteri sınıfı: Sadece isim tutar
    static class Musteri {
        String isim;
        public Musteri(String isim) {
            this.isim = isim;
        }
    }
    // Sipariş sınıfı: Bir müşteri, bir ürün ve adet içerir
    static class Siparis {
        Musteri musteri;
        Urun urun;
        int adet;
        public Siparis(Musteri musteri, Urun urun, int adet) {
            this.musteri = musteri;
            this.urun = urun;
            this.adet = adet;
        }
        // Sipariş bilgilerini ekrana yazdırır
        public void siparisBilgi() {
            System.out.println(musteri.isim + " adlı müşteri " + urun.ad + " ürününden " + adet + " adet sipariş verdi. Toplam: " + (urun.fiyat * adet) + " TL");
        }
    }
    public static void main(String[] args) {
        // Müşteri ve ürün oluştur
        Musteri m = new Musteri("Ali");
        Urun u = new Urun("Laptop", 15000);
        // Sipariş oluştur
        Siparis s = new Siparis(m, u, 2);
        // Sipariş bilgisini yazdır
        s.siparisBilgi();
    }
} 