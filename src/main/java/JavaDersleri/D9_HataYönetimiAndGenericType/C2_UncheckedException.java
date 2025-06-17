package JavaDersleri.D9_HataYönetimiAndGenericType;

public class C2_UncheckedException {
    // İki sayıyı bölen metot. Sıfıra bölme durumunda ArithmeticException fırlatır (Unchecked Exception).
    public static int divide(int a, int b) {
        return a / b; // b sıfırsa ArithmeticException oluşur.
    }

    public static void main(String[] args) {
        try {
            // Sıfıra bölme deneniyor. Bu durumda ArithmeticException fırlatılır.
            int result = divide(10, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            // Hata yakalanır ve kullanıcıya bilgi verilir.
            System.out.println("Sıfıra bölme hatası: " + e.getMessage());
        }
    }
} 