package JavaDersleri.D8_OOP_Modelleme;

/**
 * Kalıtım (Inheritance) Nedir? Basit Örnek
 * ----------------------------------------
 * Kalıtım, bir sınıfın başka bir sınıftan özellik ve davranışları miras almasını sağlar.
 * Java'da 'extends' anahtar kelimesiyle kullanılır.
 */
public class C3_KalitimOrnegi {
    // Üst sınıf (base class)
    static class Hayvan {
        String ad;
        public void sesCikar() {
            System.out.println("Hayvan ses çıkarıyor.");
        }
    }
    // Alt sınıf: Kedi, Hayvan'dan miras alır
    static class Kedi extends Hayvan {
        public void sesCikar() {
            System.out.println("Miyav!");
        }
    }
    public static void main(String[] args) {
        // Kedi nesnesi oluştur, Hayvan'dan miras alınan ad alanı kullanılabilir
        Kedi kedi = new Kedi();
        kedi.ad = "Tekir";
        System.out.println("Adı: " + kedi.ad);
        // Kedi'nin sesCikar metodu override edildiği için kendi davranışı çalışır
        kedi.sesCikar();
    }
} 