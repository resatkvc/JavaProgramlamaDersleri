package JavaDersleri.D9_HataYönetimiAndGenericType;

// Validasyon için özel exception tanımı.
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class C6_IletisimAraciHata {
    // E-posta adresi kontrolü yapan metot. '@' yoksa ValidationException fırlatır.
    public static void validateEmail(String email) throws ValidationException {
        if (!email.contains("@")) {
            throw new ValidationException("Geçersiz e-posta adresi");
        }
    }

    public static void main(String[] args) {
        try {
            // Hatalı e-posta ile kontrol. ValidationException fırlatılır.
            validateEmail("testexample.com");
        } catch (ValidationException e) {
            // Hata mesajı ile kullanıcıya bilgi verilir.
            System.out.println("Hata mesajı ile iletişim: " + e.getMessage());
        }
    }
} 