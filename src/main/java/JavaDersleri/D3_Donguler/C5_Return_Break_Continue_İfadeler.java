package JavaDersleri.D3_Donguler;

/**
 * Return, Break ve Continue İfadeleri:
 * 
 * Return:
 * - Metodun çalışmasını sonlandırır ve değer döndürür
 * - Metodun çağrıldığı yere kontrolü geri verir
 * - Değer döndüren veya döndürmeyen metodlarda kullanılabilir
 * 
 * Break:
 * - Döngüden veya switch-case yapısından çıkmak için kullanılır
 * - Etiketli break ile iç içe döngülerden çıkış sağlanabilir
 * - Koşullu olarak döngüyü sonlandırmak için idealdir
 * 
 * Continue:
 * - Döngünün mevcut iterasyonunu atlar ve sonraki iterasyona geçer
 * - Etiketli continue ile iç içe döngülerde üst döngüye dönülebilir
 * - Belirli koşullarda döngünün geri kalanını atlamak için kullanılır
 * 
 * Örnek kullanım alanları:
 * - Return: Metod sonuçlarını döndürme, erken çıkış
 * - Break: Döngüden çıkış, switch-case sonlandırma
 * - Continue: Belirli elemanları atlama, koşullu işlem yapma
 */
public class C5_Return_Break_Continue_İfadeler {
    public static void main(String[] args) {
        // Break örneği
        System.out.println("Break örneği:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("5'e ulaşıldı, döngüden çıkılıyor...");
                break;
            }
            System.out.println("Sayı: " + i);
        }

        // Continue örneği
        System.out.println("\nContinue örneği:");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                System.out.println("3 atlanıyor...");
                continue;
            }
            System.out.println("Sayı: " + i);
        }

        // Return örneği
        System.out.println("\nReturn örneği:");
        int sonuc = topla(5, 3);
        System.out.println("Toplam: " + sonuc);

        // Break ile etiketli döngü örneği
        System.out.println("\nEtiketli break örneği:");
        disDongu: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("İç döngüden çıkılıyor...");
                    break disDongu;
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }

        // Continue ile etiketli döngü örneği
        System.out.println("\nEtiketli continue örneği:");
        disDongu: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("İç döngü atlanıyor...");
                    continue disDongu;
                }
                System.out.println("i: " + i + ", j: " + j);
            }
        }
    }

    // Return örneği için yardımcı metod
    public static int topla(int a, int b) {
        return a + b;
    }
}
