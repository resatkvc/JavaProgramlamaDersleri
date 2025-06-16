package JavaDersleri.D6_Metotlar;

/**
 * Nesneye Değer Olarak Atama
 * -------------------------
 * Java'da nesneler referans tipindedir. Bir nesne başka bir nesneye atandığında, referans (adres) kopyalanır.
 * Yani iki değişken aynı nesneyi gösterir.
 *
 * - Değer tiplerinde (int, double, vs.) değer kopyalanır.
 * - Referans tiplerinde (sınıflar, diziler) adres kopyalanır.
 *
 * Gerçek projede, nesne paylaşımı veya nesne üzerinde ortak işlem yapmak için kullanılır.
 */
public class C23_NesneyeDegerOlarakAtama {
    int sayi;

    public C23_NesneyeDegerOlarakAtama(int sayi) {
        this.sayi = sayi;
    }

    /**
     * Gerçek projede kullanım örneği:
     * İki referans aynı nesneyi gösterirse, birinde yapılan değişiklik diğerini de etkiler.
     */
    public static void main(String[] args) {
        C23_NesneyeDegerOlarakAtama a = new C23_NesneyeDegerOlarakAtama(10);
        C23_NesneyeDegerOlarakAtama b = a; // b de aynı nesneyi gösterir
        b.sayi = 20;
        System.out.println("a.sayi: " + a.sayi); // 20
        System.out.println("b.sayi: " + b.sayi); // 20
    }
} 