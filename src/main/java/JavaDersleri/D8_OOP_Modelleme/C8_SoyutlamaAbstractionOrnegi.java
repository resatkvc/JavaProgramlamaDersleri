package JavaDersleri.D8_OOP_Modelleme;

/**
 * Soyutlama (Abstraction) Nedir? Abstract Sınıf ve Metot Örneği
 * ------------------------------------------------------------
 * Soyutlama, ortak özellik ve davranışları üst sınıfta tanımlayıp, alt sınıflarda detaylandırmayı sağlar.
 * Abstract sınıflardan nesne oluşturulamaz, abstract metotlar alt sınıfta override edilmelidir.
 */
public class C8_SoyutlamaAbstractionOrnegi {
    static abstract class Sekil {
        abstract double alan();
        public void bilgi() {
            System.out.println("Bu bir şekildir.");
        }
    }
    static class Daire extends Sekil {
        double yaricap;
        public Daire(double yaricap) {
            this.yaricap = yaricap;
        }
        @Override
        double alan() {
            return Math.PI * yaricap * yaricap;
        }
    }
    public static void main(String[] args) {
        // Sekil s = new Sekil(); // HATA: Soyut sınıftan nesne oluşturulamaz
        Sekil d = new Daire(3);
        d.bilgi();
        System.out.println("Dairenin alanı: " + d.alan());
    }
} 