package JavaDersleri.D8_OOP_Modelleme;

/**
 * this Anahtar Kelimesi Nedir? Nasıl Kullanılır?
 * ---------------------------------------------
 * this, bir nesnenin kendi alanlarına/metotlarına referans vermek için kullanılır.
 * Genellikle parametre isimleri ile alan isimleri çakıştığında kullanılır.
 */
public class C6_ThisAnahtarKelimesiOrnegi {
    static class Personel {
        String isim;
        public Personel(String isim) {
            this.isim = isim; // this ile alanı parametreden ayırıyoruz
        }
        public void yazdir() {
            System.out.println("Personel: " + this.isim);
        }
    }
    public static void main(String[] args) {
        Personel p = new Personel("Zeynep");
        p.yazdir();
    }
} 