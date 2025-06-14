package JavaDersleri.D5_ErisimBelirleyiciler;

/**
 * Protected erişim belirleyici örneği
 * Protected: Sınırlı erişim sağlar
 * - Aynı paket içindeki sınıflardan erişilebilir
 * - Alt sınıflardan erişilebilir (farklı pakette olsa bile)
 * - Farklı paketlerdeki sınıflardan doğrudan erişilemez
 */
public class C2_Protected {
    // Protected değişken
    protected String protectedDegisken = "Bu değişkene aynı paket ve alt sınıflardan erişilebilir";
    
    // Protected metot
    protected void protectedMetot() {
        System.out.println("Bu metoda aynı paket ve alt sınıflardan erişilebilir");
    }
    
    // Protected constructor
    protected C2_Protected() {
        System.out.println("Protected constructor çağrıldı");
    }
    
    // Alt sınıf örneği
    public static class AltSinif extends C2_Protected {
        public void testErisim() {
            // Alt sınıftan protected üyelere erişim
            System.out.println(protectedDegisken);
            protectedMetot();
        }
    }
    
    public static void main(String[] args) {
        C2_Protected ornek = new C2_Protected();
        System.out.println(ornek.protectedDegisken);
        ornek.protectedMetot();
        
        // Alt sınıf üzerinden erişim
        AltSinif altSinif = new AltSinif();
        altSinif.testErisim();
    }
} 