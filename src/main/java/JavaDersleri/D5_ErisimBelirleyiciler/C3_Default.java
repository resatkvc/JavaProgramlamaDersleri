package JavaDersleri.D5_ErisimBelirleyiciler;

/**
 * Default (Package-Private) erişim belirleyici örneği
 * Default: Erişim belirleyici yazılmadığında kullanılan seviyedir
 * - Sadece aynı paket içindeki sınıflardan erişilebilir
 * - Farklı paketlerden erişilemez
 * - Alt sınıflardan erişilemez (farklı pakette ise)
 */
class C3_Default {
    // Default değişken
    String defaultDegisken = "Bu değişkene sadece aynı paketten erişilebilir";
    
    // Default metot
    void defaultMetot() {
        System.out.println("Bu metoda sadece aynı paketten erişilebilir");
    }
    
    // Default constructor
    C3_Default() {
        System.out.println("Default constructor çağrıldı");
    }
    
    public static void main(String[] args) {
        C3_Default ornek = new C3_Default();
        System.out.println(ornek.defaultDegisken);
        ornek.defaultMetot();
    }
} 