package JavaDersleri.D9_HataYönetimiAndGenericType;

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class C6_IletisimAraciHata {
    public static void validateEmail(String email) throws ValidationException {
        if (!email.contains("@")) {
            throw new ValidationException("Geçersiz e-posta adresi");
        }
    }

    public static void main(String[] args) {
        try {
            validateEmail("testexample.com");
        } catch (ValidationException e) {
            System.out.println("Hata mesajı ile iletişim: " + e.getMessage());
        }
    }
} 