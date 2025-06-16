package JavaDersleri.D6_Metotlar;

/**
 * Sabitler (Constants)
 * -----------------------------------
 * Sabitler, değeri değişmeyen ve genellikle büyük harflerle tanımlanan değişkenlerdir.
 * Java'da sabitler için 'final' anahtar kelimesi kullanılır.
 *
 * Gerçek projede kullanım:
 * - Sabitler, uygulama boyunca değişmemesi gereken değerleri saklamak için kullanılır.
 * - Örneğin vergi oranı, maksimum kullanıcı sayısı, hata mesajları gibi.
 */
public class C3_Sabitler {
    // Sabit bir alan (field)
    public static final double PI = 3.14159;
    public static final int MAX_KULLANICI = 1000;

    /**
     * Sabitler, kodun okunabilirliğini ve bakımını artırır.
     * Değişmeyecek değerler için sabit kullanmak en iyi uygulamadır.
     */
    public static void main(String[] args) {
        System.out.println("Pi sayısı: " + PI);
        System.out.println("Maksimum kullanıcı: " + MAX_KULLANICI);
        // Gerçek projede örnek: Kullanıcı kaydı sırasında sınır kontrolü
        int mevcutKullanici = 950;
        if (mevcutKullanici < MAX_KULLANICI) {
            System.out.println("Yeni kullanıcı eklenebilir.");
        } else {
            System.out.println("Kullanıcı limiti aşıldı!");
        }
    }
} 