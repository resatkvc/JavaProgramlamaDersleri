package JavaDersleri.D8_OOP_Modelleme;

/**
 * Polimorfizm (Çok Biçimlilik) Nedir? Basit Örnek
 * ----------------------------------------------
 * Polimorfizm, aynı arayüzü paylaşan farklı nesnelerin, aynı metodu farklı şekillerde uygulayabilmesidir.
 * Java'da override ile sağlanır ve genellikle kalıtım ile birlikte kullanılır.
 */
public class C4_PolimorfizmOrnegi {
    // Üst sınıf (base class)
    static class Hayvan {
        public void sesCikar() {
            System.out.println("Hayvan ses çıkarıyor.");
        }
    }
    // Alt sınıf: Köpek
    static class Kopek extends Hayvan {
        public void sesCikar() {
            System.out.println("Hav hav!");
        }
    }
    // Alt sınıf: Kedi
    static class Kedi extends Hayvan {
        public void sesCikar() {
            System.out.println("Miyav!");
        }
    }

    public static void main(String[] args) {
        // Polimorfizm: Üst sınıf referansı ile alt sınıf nesnesi
        Hayvan h1 = new Kopek();
        Hayvan h2 = new Kedi();
        h1.sesCikar(); // Hav hav!
        h2.sesCikar(); // Miyav!

        // Dizi ile polimorfizm örneği
        Hayvan[] hayvanlar = {new Kopek(), new Kedi(), new Hayvan()};
        for (Hayvan h : hayvanlar) {
            h.sesCikar();
        }
    }
} 