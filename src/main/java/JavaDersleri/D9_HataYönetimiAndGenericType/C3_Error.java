package JavaDersleri.D9_HataYönetimiAndGenericType;

public class C3_Error {
    // Sonsuz özyineleme ile StackOverflowError oluşturan metot.
    public static void recursiveCall() {
        recursiveCall(); // Her çağrıda kendini tekrar çağırır, stack dolana kadar devam eder.
    }

    public static void main(String[] args) {
        try {
            // StackOverflowError oluşacak.
            recursiveCall();
        } catch (StackOverflowError e) {
            // Hata yakalanır ve kullanıcıya bilgi verilir.
            System.out.println("Stack overflow hatası: " + e.getMessage());
        }
    }
} 