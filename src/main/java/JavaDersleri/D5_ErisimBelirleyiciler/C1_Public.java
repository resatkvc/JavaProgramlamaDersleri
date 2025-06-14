package JavaDersleri.D5_ErisimBelirleyiciler;

/**
 * Public erişim belirleyici örneği
 * Public: En geniş erişim seviyesidir. Her yerden erişilebilir.
 * - Aynı paket içindeki sınıflardan
 * - Farklı paketlerdeki sınıflardan
 * - Alt sınıflardan
 * erişilebilir.
 */
public class C1_Public {
    // Public değişken
    public String publicDegisken = "Bu değişkene her yerden erişilebilir";
    
    // Public metot
    public void publicMetot() {
        System.out.println("Bu metoda her yerden erişilebilir");
    }
    
    // Public constructor
    public C1_Public() {
        System.out.println("Public constructor çağrıldı");
    }
    
    // Örnek kullanım
    public static void main(String[] args) {
        C1_Public ornek = new C1_Public();
        System.out.println(ornek.publicDegisken);
        ornek.publicMetot();
    }
} 