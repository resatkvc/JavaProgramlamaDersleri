package JavaDersleri.D6_Metotlar;

/**
 * Nesneye Değer Olarak Atama Açıklaması
 * ------------------------------------
 * Java'da nesneler referans tipindedir. Bir nesne başka bir değişkene atandığında, her iki değişken de aynı nesneyi gösterir.
 *
 * - Değer tiplerinde (int, double, vs.) atama ile değer kopyalanır.
 * - Referans tiplerinde (sınıflar, diziler) atama ile adres kopyalanır.
 *
 * Gerçek projede, nesne paylaşımı veya nesne üzerinde ortak işlem yapmak için kullanılır.
 */
public class C24_NesneyeDegerOlarakAtamaAciklama {
    String isim;

    public C24_NesneyeDegerOlarakAtamaAciklama(String isim) {
        this.isim = isim;
    }

    /**
     * Gerçek projede kullanım örneği:
     * İki referans aynı nesneyi gösterirse, birinde yapılan değişiklik diğerini de etkiler.
     */
    public static void main(String[] args) {
        C24_NesneyeDegerOlarakAtamaAciklama n1 = new C24_NesneyeDegerOlarakAtamaAciklama("Ali");
        C24_NesneyeDegerOlarakAtamaAciklama n2 = n1;
        n2.isim = "Veli";
        System.out.println("n1.isim: " + n1.isim); // Veli
        System.out.println("n2.isim: " + n2.isim); // Veli
    }
} 