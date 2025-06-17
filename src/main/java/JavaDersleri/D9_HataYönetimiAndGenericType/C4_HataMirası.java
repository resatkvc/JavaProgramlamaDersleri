package JavaDersleri.D9_HataYönetimiAndGenericType;

// Özel bir exception (Checked Exception) tanımı. Hata mirası örneği.
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class C4_HataMirası {
    // Yaş kontrolü yapan metot. Eğer yaş 18'den küçükse CustomException fırlatır.
    public static void checkAge(int age) throws CustomException {
        if (age < 18) {
            throw new CustomException("Yaş 18'den küçük olamaz.");
        }
    }

    public static void main(String[] args) {
        try {
            // 15 yaş ile kontrol. CustomException fırlatılır.
            checkAge(15);
        } catch (CustomException e) {
            // Hata yakalanır ve kullanıcıya bilgi verilir.
            System.out.println("Özel hata yakalandı: " + e.getMessage());
        }
    }
} 