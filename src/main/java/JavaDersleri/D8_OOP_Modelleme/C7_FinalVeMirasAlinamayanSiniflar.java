package JavaDersleri.D8_OOP_Modelleme;

/**
 * final Anahtar Kelimesi ve Miras Alınamayan Sınıflar
 * --------------------------------------------------
 * Bir sınıf final olarak tanımlanırsa, o sınıftan başka bir sınıf türetilemez (miras alınamaz).
 * Bir metot final ise, alt sınıflar tarafından override edilemez.
 */
public class C7_FinalVeMirasAlinamayanSiniflar {
    final static class SabitSinif {
        public void yazdir() {
            System.out.println("Bu sınıf miras alınamaz.");
        }
    }
    // Aşağıdaki kod derlenmez:
    // class AltSinif extends SabitSinif {}

    static class UstSinif {
        public final void degistirilemezMetot() {
            System.out.println("Bu metot override edilemez.");
        }
    }
    static class AltSinif extends UstSinif {
        // public void degistirilemezMetot() {} // HATA: final metot override edilemez
    }
    public static void main(String[] args) {
        SabitSinif s = new SabitSinif();
        s.yazdir();
        AltSinif a = new AltSinif();
        a.degistirilemezMetot();
    }
} 