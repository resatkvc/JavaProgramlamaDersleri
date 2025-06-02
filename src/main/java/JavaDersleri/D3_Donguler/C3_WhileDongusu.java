package JavaDersleri.D3_Donguler;

import java.util.Scanner;

/**
 * While Döngüsü:
 * - Koşul sağlandığı sürece tekrar eden işlemler için kullanılır
 * - Önceden kaç kez tekrar edeceği bilinmeyen durumlar için idealdir
 * - Kullanıcı girişi gerektiren işlemlerde sıkça kullanılır
 * - Sonsuz döngüye düşmemek için koşulun değişmesi gerekir
 * - Örnek kullanım alanları: Kullanıcı doğrulama, veri okuma, matematiksel seriler
 * - Faktöriyel, Fibonacci gibi matematiksel işlemler için uygundur
 */
public class C3_WhileDongusu {
    public static void main(String[] args) {
        // Örnek 1: Basit while döngüsü
        int sayi = 1;
        System.out.println("1'den 5'e kadar sayılar:");
        while (sayi <= 5) {
            System.out.println(sayi);
            sayi++;
        }

        // Örnek 2: Kullanıcıdan sayı alma ve toplama
        Scanner scanner = new Scanner(System.in);
        int toplam = 0;
        int girilenSayi = 0;

        System.out.println("\nSayıları toplamak için sayıları girin (0 girerek çıkın):");
        while (girilenSayi != 0) {
            System.out.print("Bir sayı girin: ");
            girilenSayi = scanner.nextInt();
            toplam += girilenSayi;
        }
        System.out.println("Toplam: " + toplam);

        // Örnek 3: Faktöriyel hesaplama
        int n = 5;
        int faktoriyel = 1;
        int i = 1;

        while (i <= n) {
            faktoriyel *= i;
            i++;
        }
        System.out.println("\n" + n + " sayısının faktöriyeli: " + faktoriyel);

        // Örnek 4: Fibonacci serisi
        System.out.println("\nFibonacci serisi (ilk 10 sayı):");
        int a = 0, b = 1;
        int count = 0;
        while (count < 10) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
            count++;
        }
    }
}
