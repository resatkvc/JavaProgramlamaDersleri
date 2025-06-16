package JavaDersleri.D7_Enum;

/**
 * Enum Nedir? Temel Kullanım
 * -------------------------
 * Enum (enumeration), sabit değerler kümesini temsil eden özel bir sınıf türüdür.
 * Java'da enum ile sabitler grubu tanımlanır ve bu değerler dışında başka değer atanamaz.
 *
 * Temel enum tanımı:
 */
public class C1_EnumNedirVeTemelKullanim {
    // Basit bir enum tanımı
    enum Gun {
        PAZARTESI, SALI, CARSAMBA, PERSEMBE, CUMA, CUMARTESI, PAZAR
    }

    public static void main(String[] args) {
        // Enum kullanımı
        Gun bugun = Gun.PAZARTESI;
        System.out.println("Bugün: " + bugun);

        // Enum ile switch-case kullanımı
        switch (bugun) {
            case PAZARTESI:
                System.out.println("Haftanın ilk günü!");
                break;
            case CUMARTESI:
            case PAZAR:
                System.out.println("Hafta sonu!");
                break;
            default:
                System.out.println("Hafta içi!");
        }
    }
} 