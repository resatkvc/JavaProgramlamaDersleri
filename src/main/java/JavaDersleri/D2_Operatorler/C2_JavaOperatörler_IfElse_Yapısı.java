package JavaDersleri.D2_Operatorler;

/**
 * If-Else Yapısı:
 * - Koşullu ifadeleri kontrol etmek için kullanılır
 * - Program akışını belirli koşullara göre yönlendirir
 * - Tek koşul (if-else), çoklu koşul (if-else if-else) ve iç içe koşullar için kullanılabilir
 * - Boolean değerler ile mantıksal kontroller yapılabilir
 */
public class C2_JavaOperatörler_IfElse_Yapısı {
    public static void main(String[] args) {
        // Örnek 1: Basit if-else yapısı
        int sayi = 10;
        if (sayi > 0) {
            System.out.println("Sayı pozitiftir");
        } else {
            System.out.println("Sayı negatiftir");
        }

        // Örnek 2: if-else if-else yapısı
        int not = 85;
        if (not >= 90) {
            System.out.println("AA");
        } else if (not >= 80) {
            System.out.println("BA");
        } else if (not >= 70) {
            System.out.println("BB");
        } else {
            System.out.println("FF");
        }

        // Örnek 3: İç içe if-else yapısı
        int yas = 20;
        boolean ehliyetVar = true;
        
        if (yas >= 18) {
            if (ehliyetVar) {
                System.out.println("Araç kullanabilirsiniz");
            } else {
                System.out.println("Ehliyet almanız gerekiyor");
            }
        } else {
            System.out.println("Yaşınız yeterli değil");
        }

        // Örnek 4: Boolean değişken ile if-else
        boolean havaGunesli = true;
        boolean yagmurYagiyor = false;
        
        if (havaGunesli && !yagmurYagiyor) {
            System.out.println("Pikniğe gidebilirsiniz");
        } else {
            System.out.println("Evde kalın");
        }
    }
}
