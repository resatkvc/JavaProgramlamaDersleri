package JavaDersleri.D5_ErisimBelirleyiciler;

/**
 * Private erişim belirleyici örneği
 * Private: En kısıtlı erişim seviyesidir
 * - Sadece tanımlandığı sınıf içinden erişilebilir
 * - Alt sınıflardan bile erişilemez
 * - Farklı paketlerden erişilemez
 */
public class C4_Private {
    // Private değişken
    private String privateDegisken = "Bu değişkene sadece bu sınıf içinden erişilebilir";
    
    // Private metot
    private void privateMetot() {
        System.out.println("Bu metoda sadece bu sınıf içinden erişilebilir");
    }
    
    // Private constructor
    private C4_Private() {
        System.out.println("Private constructor çağrıldı");
    }
    
    // Public metot üzerinden private üyelere erişim (Encapsulation örneği)
    public void publicMetot() {
        System.out.println(privateDegisken);
        privateMetot();
    }
    
    // Factory metot örneği
    public static C4_Private createInstance() {
        return new C4_Private();
    }
    
    public static void main(String[] args) {
        C4_Private ornek = createInstance();
        ornek.publicMetot();
    }
} 