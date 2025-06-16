package JavaDersleri.D6_Metotlar;

/**
 * Sabitler Kullanım Şekilleri
 * -----------------------------------
 * Sabitler, genellikle public static final olarak tanımlanır.
 * - public: Her yerden erişilebilir
 * - static: Sınıfa aittir, nesne oluşturmadan erişilir
 * - final: Değeri değiştirilemez
 *
 * Gerçek projede kullanım:
 * - Sabitler, uygulama genelinde ortak kullanılan değerler için merkezi bir yerde tutulur.
 * - Örneğin hata kodları, sabit mesajlar, matematiksel sabitler.
 */
public class C4_SabitlerKullanimSekilleri {
    // Sabit tanımlama örnekleri
    public static final String HATA_MESAJI = "Bir hata oluştu!";
    public static final double KDV_ORANI = 0.18;

    /**
     * Sabitlerin kullanımı kodun güvenliğini ve okunabilirliğini artırır.
     * Sabitler genellikle büyük harf ve alt çizgi ile yazılır.
     */
    public static void main(String[] args) {
        double fiyat = 100;
        double fiyatKDVli = fiyat + (fiyat * KDV_ORANI);
        System.out.println("KDV'li fiyat: " + fiyatKDVli);
        // Hata mesajı örneği
        boolean hataVar = true;
        if (hataVar) {
            System.out.println(HATA_MESAJI);
        }
    }
} 