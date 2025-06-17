package JavaDersleri.D9_HataYönetimiAndGenericType;

import java.util.Arrays;
import java.util.List;

public class C9_Lambda {
    public static void main(String[] args) {
        // Bir liste oluşturuluyor.
        List<String> isimler = Arrays.asList("Ali", "Veli", "Ayşe");
        // Lambda ifadesi ile listedeki her isim ekrana yazdırılıyor.
        isimler.forEach(isim -> System.out.println(isim));
    }
} 