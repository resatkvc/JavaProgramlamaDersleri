package JavaDersleri.D6_Metotlar;

/**
 * Varsayılan (Parametresiz) Yapıcı Metot
 * -------------------------------------
 * Sınıfta herhangi bir yapıcı metot tanımlanmazsa, Java otomatik olarak parametresiz bir yapıcı ekler.
 * Eğer özel bir yapıcı tanımlanırsa, varsayılan yapıcı otomatik eklenmez.
 *
 * - Varsayılan yapıcı, nesne oluşturulurken hiçbir parametre almaz.
 *
 * Gerçek projede, nesneye başlangıçta değer atamadan oluşturmak için kullanılır.
 */
public class C16_ConstructorsVarsayilanYapiciOrnegi {
    String ad;
    int yas;

    // Varsayılan yapıcı (otomatik eklenir)
    // public C16_ConstructorsVarsayilanYapiciOrnegi() {}

    /**
     * Gerçek projede kullanım örneği:
     * Nesne oluşturulup, alanlar sonradan atanabilir.
     */
    public static void main(String[] args) {
        C16_ConstructorsVarsayilanYapiciOrnegi ogrenci = new C16_ConstructorsVarsayilanYapiciOrnegi();
        ogrenci.ad = "Ayşe";
        ogrenci.yas = 22;
        System.out.println("Ad: " + ogrenci.ad + ", Yaş: " + ogrenci.yas);
    }
} 