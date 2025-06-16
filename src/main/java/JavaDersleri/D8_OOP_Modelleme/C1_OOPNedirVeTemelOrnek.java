package JavaDersleri.D8_OOP_Modelleme;

/**
 * OOP Nedir? Temel Kavramlar ve Basit Örnek
 * ----------------------------------------
 * OOP (Nesne Yönelimli Programlama), yazılımı nesneler ve bu nesnelerin etkileşimi üzerinden modelleyen bir yaklaşımdır.
 * Temel kavramlar: Sınıf (class), Nesne (object), Özellik (field), Davranış (method), Kapsülleme, Kalıtım, Çok Biçimlilik.
 */
public class C1_OOPNedirVeTemelOrnek {
    // Basit bir sınıf: Araba
    static class Araba {
        String marka;
        int hiz;

        // Yapıcı metot ile ilk değer atama
        public Araba(String marka) {
            this.marka = marka;
            this.hiz = 0;
        }

        // Arabayı hızlandıran metot
        public void hizlan(int artis) {
            hiz += artis;
            System.out.println(marka + " hızlandı. Yeni hız: " + hiz);
        }
    }

    public static void main(String[] args) {
        // Araba nesnesi oluştur
        Araba araba1 = new Araba("Toyota");
        // Arabayı hızlandır
        araba1.hizlan(30);
    }
} 