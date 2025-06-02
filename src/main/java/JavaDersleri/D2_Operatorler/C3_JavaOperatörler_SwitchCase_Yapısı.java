package JavaDersleri.D2_Operatorler;

/**
 * Switch-Case Yapısı:
 * - Tek bir değişkenin farklı değerlerini kontrol etmek için kullanılır
 * - Çok sayıda if-else if yapısı yerine daha düzenli bir alternatif sunar
 * - Sayısal değerler, karakterler ve String'ler ile kullanılabilir
 * - Break ifadesi ile kontrol akışı yönetilir
 * - Default case ile tanımlanmamış durumlar ele alınır
 */
public class C3_JavaOperatörler_SwitchCase_Yapısı {
    public static void main(String[] args) {
        // Örnek 1: Basit switch-case yapısı
        int gun = 3;
        switch (gun) {
            case 1:
                System.out.println("Pazartesi");
                break;
            case 2:
                System.out.println("Salı");
                break;
            case 3:
                System.out.println("Çarşamba");
                break;
            default:
                System.out.println("Geçersiz gün");
        }

        // Örnek 2: String ile switch-case
        String mevsim = "Yaz";
        switch (mevsim.toLowerCase()) {
            case "kış":
                System.out.println("Kış mevsimi");
                break;
            case "ilkbahar":
                System.out.println("İlkbahar mevsimi");
                break;
            case "yaz":
                System.out.println("Yaz mevsimi");
                break;
            case "sonbahar":
                System.out.println("Sonbahar mevsimi");
                break;
            default:
                System.out.println("Geçersiz mevsim");
        }

        // Örnek 3: Break kullanmadan switch-case
        int ay = 7;
        switch (ay) {
            case 1:
            case 2:
                System.out.println("Kış ayı");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("İlkbahar ayı");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Yaz ayı");
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                System.out.println("Sonbahar ayı");
                break;
            default:
                System.out.println("Geçersiz ay");
        }
    }
}
