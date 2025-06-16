package JavaDersleri.D8_OOP_Modelleme;

/**
 * Kapsülleme (Encapsulation) Nedir? Basit Örnek
 * ---------------------------------------------
 * Kapsülleme, nesnenin verilerini (alanlarını) dışarıya karşı koruma altına alır.
 * Genellikle alanlar private yapılır ve erişim için getter/setter metotları kullanılır.
 */
public class C2_KapsullemeOrnegi {
    static class Ogrenci {
        // Alanlar private, doğrudan erişilemez
        private String ad;
        private int yas;

        // Yapıcı metot ile ilk değer atama
        public Ogrenci(String ad, int yas) {
            this.ad = ad;
            this.yas = yas;
        }

        // Getter: ad alanını okuma
        public String getAd() {
            return ad;
        }

        // Setter: ad alanını değiştirme
        public void setAd(String ad) {
            this.ad = ad;
        }

        // Getter: yas alanını okuma
        public int getYas() {
            return yas;
        }

        // Setter: yas alanını değiştirme (kontrollü)
        public void setYas(int yas) {
            if (yas > 0) this.yas = yas;
        }
    }

    public static void main(String[] args) {
        // Ogrenci nesnesi oluştur
        Ogrenci ogr = new Ogrenci("Ayşe", 20);
        // Alanlara doğrudan erişim yok, getter ile okuma
        System.out.println("Ad: " + ogr.getAd() + ", Yaş: " + ogr.getYas());
        // Setter ile yaşı güncelle
        ogr.setYas(22);
        System.out.println("Yeni yaş: " + ogr.getYas());
    }
} 