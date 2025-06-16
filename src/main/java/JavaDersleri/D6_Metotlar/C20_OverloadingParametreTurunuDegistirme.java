package JavaDersleri.D6_Metotlar;

/**
 * Overloading: Parametre Türünü Değiştirerek
 * -----------------------------------------
 * Aynı isimde birden fazla metot tanımlanırken, parametre türü değiştirilebilir.
 * Bu şekilde farklı veri tipleriyle çalışabilen metotlar oluşturulabilir.
 *
 * Gerçek projede, aynı işlemi farklı veri tipleriyle yapmak için kullanılır.
 */
public class C20_OverloadingParametreTurunuDegistirme {
    // Parametre türünü değiştirerek overloading
    public void yazdir(int sayi) {
        System.out.println("Sayı: " + sayi);
    }

    public void yazdir(String mesaj) {
        System.out.println("Mesaj: " + mesaj);
    }

    /**
     * Gerçek projede kullanım örneği:
     * Hem sayısal hem metinsel veri yazdırmak için farklı imzalar kullanılır.
     */
    public static void main(String[] args) {
        C20_OverloadingParametreTurunuDegistirme ornek = new C20_OverloadingParametreTurunuDegistirme();
        ornek.yazdir(42);
        ornek.yazdir("Merhaba dünya");
    }
} 