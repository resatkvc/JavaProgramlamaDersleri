package JavaDersleri.D3_Donguler;

import java.util.Scanner;

/**
 * Do-While Döngüsü:
 * - En az bir kez çalışması gereken işlemler için kullanılır
 * - Koşul kontrolü döngü sonunda yapılır
 * - While döngüsünden farklı olarak ilk çalıştırmada koşul kontrol edilmez
 * - Menü sistemleri ve kullanıcı etkileşimli programlar için idealdir
 * - Örnek kullanım alanları: Şifre kontrolü, menü seçimleri, kullanıcı doğrulama
 * - Kullanıcıdan veri alınması gereken durumlarda sıkça kullanılır
 */
public class C4_DoWhileDongusu {
    public static void main(String[] args) {
        // Örnek 1: Basit do-while döngüsü
        int sayi = 1;
        System.out.println("1'den 5'e kadar sayılar:");
        do {
            System.out.println(sayi);
            sayi++;
        } while (sayi <= 5);

        // Örnek 2: Menü seçimi
        Scanner scanner = new Scanner(System.in);
        int secim;
        do {
            System.out.println("\nMenü:");
            System.out.println("1. Toplama");
            System.out.println("2. Çıkarma");
            System.out.println("3. Çarpma");
            System.out.println("4. Bölme");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Toplama işlemi seçildi");
                    break;
                case 2:
                    System.out.println("Çıkarma işlemi seçildi");
                    break;
                case 3:
                    System.out.println("Çarpma işlemi seçildi");
                    break;
                case 4:
                    System.out.println("Bölme işlemi seçildi");
                    break;
                case 0:
                    System.out.println("Program sonlandırılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 0);

        // Örnek 3: Şifre kontrolü
        String dogruSifre = "1234";
        String girilenSifre;
        int denemeSayisi = 0;
        
        do {
            System.out.print("\nŞifrenizi girin: ");
            girilenSifre = scanner.next();
            denemeSayisi++;
            
            if (!girilenSifre.equals(dogruSifre)) {
                System.out.println("Yanlış şifre! Kalan deneme hakkı: " + (3 - denemeSayisi));
            }
        } while (!girilenSifre.equals(dogruSifre) && denemeSayisi < 3);

        if (girilenSifre.equals(dogruSifre)) {
            System.out.println("Giriş başarılı!");
        } else {
            System.out.println("Çok fazla deneme yaptınız!");
        }
    }
}
