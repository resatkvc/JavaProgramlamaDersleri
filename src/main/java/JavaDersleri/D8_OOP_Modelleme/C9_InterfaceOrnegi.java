package JavaDersleri.D8_OOP_Modelleme;

/**
 * Interface (Arayüz) Nedir? Nasıl Kullanılır?
 * ------------------------------------------
 * Interface, bir sınıfın hangi metotları uygulaması gerektiğini belirten bir şablondur.
 * Çoklu kalıtım ve bağımlılıkları azaltmak için kullanılır.
 */
public class C9_InterfaceOrnegi {
    interface OdemeYontemi {
        void odemeYap(double tutar);
    }
    static class KrediKarti implements OdemeYontemi {
        public void odemeYap(double tutar) {
            System.out.println(tutar + " TL kredi kartı ile ödendi.");
        }
    }
    static class Havale implements OdemeYontemi {
        public void odemeYap(double tutar) {
            System.out.println(tutar + " TL havale ile ödendi.");
        }
    }
    public static void main(String[] args) {
        OdemeYontemi odeme1 = new KrediKarti();
        OdemeYontemi odeme2 = new Havale();
        odeme1.odemeYap(100);
        odeme2.odemeYap(200);
    }
} 