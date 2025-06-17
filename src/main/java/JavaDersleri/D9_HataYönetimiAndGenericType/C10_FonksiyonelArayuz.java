package JavaDersleri.D9_HataYönetimiAndGenericType;

// Fonksiyonel arayüz tanımı. Sadece bir abstract metot içerir.
@FunctionalInterface
interface Hesaplama {
    int islem(int a, int b);
}

public class C10_FonksiyonelArayuz {
    public static void main(String[] args) {
        // Lambda ile toplama işlemi tanımlanıyor.
        Hesaplama toplama = (a, b) -> a + b;
        // Lambda ile çarpma işlemi tanımlanıyor.
        Hesaplama carpma = (a, b) -> a * b;
        // Sonuçlar ekrana yazdırılıyor.
        System.out.println(toplama.islem(3, 5));
        System.out.println(carpma.islem(3, 5));
    }
} 