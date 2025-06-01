package JavaDersleri.D2_Operatorler;

public class C1_JavaOperatorler {

    public static void main(String[] args) {

        // 1. ARİTMATİK OPERATORLER
        System.out.println("--- Aritmetik Operatörler ---");
        int a = 10;
        int b = 5;
        System.out.println("a + b = " + (a + b)); // Toplama
        System.out.println("a - b = " + (a - b)); // Çıkarma
        System.out.println("a * b = " + (a * b)); // Çarpma
        System.out.println("a / b = " + (a / b)); // Bölme
        System.out.println("a % b = " + (a % b)); // Mod (kalan)

        int c = 10;
        System.out.println("++c = " + (++c)); // Artırma (önce artır, sonra kullan)
        System.out.println("c++ = " + (c++)); // Artırma (önce kullan, sonra artır)
        System.out.println("c = " + c);

        int d = 10;
        System.out.println("--d = " + (--d)); // Azaltma (önce azalt, sonra kullan)
        System.out.println("d-- = " + (d--)); // Azaltma (önce kullan, sonra azalt)
        System.out.println("d = " + d);

        System.out.println(); // Boş satır

        // 2. ATAMA OPERATORLERİ
        System.out.println("--- Atama Operatörleri ---");
        int e = 20;
        e += 5; // e = e + 5
        System.out.println("e += 5 : " + e);
        e -= 10; // e = e - 10
        System.out.println("e -= 10 : " + e);
        e *= 2; // e = e * 2
        System.out.println("e *= 2 : " + e);
        e /= 3; // e = e / 3
        System.out.println("e /= 3 : " + e);
        e %= 4; // e = e % 4
        System.out.println("e %= 4 : " + e);

        System.out.println(); // Boş satır

        // 3. KARŞILAŞTIRMA (İLİŞKİSEL) OPERATORLERİ
        System.out.println("--- Karşılaştırma Operatörler ---");
        int f = 15;
        int g = 20;
        System.out.println("f == g : " + (f == g)); // Eşit mi?
        System.out.println("f != g : " + (f != g)); // Eşit değil mi?
        System.out.println("f > g : " + (f > g));   // Büyük mü?
        System.out.println("f < g : " + (f < g));   // Küçük mü?
        System.out.println("f >= g : " + (f >= g)); // Büyük veya eşit mi?
        System.out.println("f <= g : " + (f <= g)); // Küçük veya eşit mi?

        System.out.println(); // Boş satır

        // 4. MANTIKSAL OPERATORLERİ
        System.out.println("--- Mantıksal Operatörler ---");
        boolean x = true;
        boolean y = false;
        System.out.println("x && y : " + (x && y)); // VE (And) - İkisi de true ise true
        System.out.println("x || y : " + (x || y)); // VEYA (Or) - Herhangi biri true ise true
        System.out.println("!x : " + (!x));       // DEĞİL (Not) - True ise false, false ise true

        System.out.println(); // Boş satır

        // 5. BİT DÜZEYİNDE OPERATORLER
        System.out.println("--- Bit düzeyinde Operatörler ---");
        int h = 5;  // Binary: 0101
        int i = 3;  // Binary: 0011
        System.out.println("h & i = " + (h & i)); // Bitwise AND (0001 = 1)
        System.out.println("h | i = " + (h | i)); // Bitwise OR (0111 = 7)
        System.out.println("h ^ i = " + (h ^ i)); // Bitwise XOR (0110 = 6)
        System.out.println("~h = " + (~h));      // Bitwise NOT (Tüm bitleri ters çevirir)
        System.out.println("h << 1 = " + (h << 1)); // Sol Shift (0101 -> 1010 = 10) * 2
        System.out.println("h >> 1 = " + (h >> 1)); // Sağ Shift (0101 -> 0010 = 2) / 2
        System.out.println("h >>> 1 = " + (h >>> 1)); // İşaretsiz Sağ Shift (Negatif sayılarda farklı)

        System.out.println(); // Boş satır

        // 6. ÜÇLÜ (Ternary) OPERATORLER
        System.out.println("--- Üçlü (Ternary) Operatör ---");
        int yas = 18;
        String durum = (yas >= 18) ? "Yetişkin" : "Genç";
        System.out.println("Durum: " + durum);
    }
}