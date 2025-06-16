package JavaDersleri.D6_Metotlar;

/**
 * Overloading: Parametre Sayısını Değiştirerek
 * -------------------------------------------
 * Aynı isimde birden fazla metot tanımlanırken, parametre sayısı değiştirilebilir.
 * Bu şekilde farklı ihtiyaçlara uygun metotlar oluşturulabilir.
 *
 * Gerçek projede, aynı işlemi farklı sayıda veriyle yapmak için kullanılır.
 */
public class C19_OverloadingParametreSayisiDegistirme {
    // Parametre sayısı değiştirerek overloading
    public void yazdir(String mesaj) {
        System.out.println(mesaj);
    }

    public void yazdir(String mesaj, int tekrar) {
        for (int i = 0; i < tekrar; i++) {
            System.out.println(mesaj);
        }
    }

    /**
     * Gerçek projede kullanım örneği:
     * Bir mesajı bir veya birden fazla kez yazdırmak için farklı imzalar kullanılır.
     */
    public static void main(String[] args) {
        C19_OverloadingParametreSayisiDegistirme ornek = new C19_OverloadingParametreSayisiDegistirme();
        ornek.yazdir("Merhaba!");
        ornek.yazdir("Tekrar!", 3);
    }
} 