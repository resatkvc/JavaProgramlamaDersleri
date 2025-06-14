package JavaDersleri.D1_VeriTurleri;

public class C1_VeriTipleri {

    public static void main(String[] args) {

        // Tam Sayı (Integer): Negatif ve pozitif değerler alabilir.
        byte byteDegeri = 100; // btye değeri -128 ile 127 arasında bir değer alır.
        short shortDegeri = 10000; // -32768 ile 32767 arasında bir değer alır.
        int intDegeri = 1000000000; // -2147483648 ile 2147483648  arasında bir değer alır.
        long longDegeri = 1000000000; // -9223372036854775808 ile 9223372036854775808 arasında bir değer alır.
        System.out.println("byte'nın Degeri : " + byteDegeri);
        System.out.println("short'un Degeri : " + shortDegeri);
        System.out.println("int'in Degeri : " + intDegeri);
        System.out.println("long'un Degeri : " + longDegeri);

        System.out.println(); // boş satır eklemek için yazıldı

        // Ondalık (Float/Double): Kesirli değerler içerir.
        float floatDegeri = 3.14987654321f; // virgülden sonra 7 basamak yazdırır. ve rakam sonuna f ifadesi yer almalıdır.
        double doubleDegeri = 3.1415926535; // virgülden sonra yaklaşık 15 basamak yazdırır.
        System.out.println("Float Değeri : " + floatDegeri);
        System.out.println("Double Değeri : " + doubleDegeri);

        System.out.println();

        // Karakter (Character): Tek bir karakteri temsil eder.
        char charDegeri = 'A';
        System.out.println("Char ifadesi : " + charDegeri);

        System.out.println();

        // Mantıksal (Boolean): Sadece iki değer alır true yada false
        boolean booleanDegeriTrue = true;
        boolean booleanDegeriFalse = false;

        System.out.println("Boolean Değer (True): " + booleanDegeriTrue);
        System.out.println("Boolean Değer (False): " + booleanDegeriFalse);

        System.out.println();

        // Diziler (Array): Aynı türdeki verilerin sıralı koleksiyonudur. Sabit boyutlu. Elemanlara indeks ile erişim sağlar.
        int[] intDizi = {1, 2, 3, 4, 5}; // int olarak 5 elemeanlı bir dizi
        String[] stringDizi = {"Elma", "Armut", "Kiraz"};  // string değer olarak  3 elmandan ifadeler yer alıyor

        System.out.print("Int Dizi: ");
        for (int i = 0; i < intDizi.length; i++) {  // for döngüsüyle dizinin tüm elemanları sırayla dolaşılır.  i. sıradaki eleman yazdırılır.
        // Bu ifade bir ternary(üçlü) operatör.Eğer eleman sonuncu değilse (i < dizi uzunluğu - 1) yanına ", " eklenir.Son elemandan sonra virgül konmaz, boş string eklenir.
            // aşağıdaki -1 ? ifadedeki ? if else anlamına gelir.
            System.out.print(intDizi[i] + (i < intDizi.length - 1 ? ", " : ""));
        }
        System.out.println();


        System.out.print("String Dizi: ");
        for (int i = 0; i < stringDizi.length; i++) {
            System.out.print(stringDizi[i] + (i < stringDizi.length - 1 ? ", " : ""));
        }
        System.out.println();

        System.out.println();

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir müşteri kaydı uygulaması - müşteri bilgilerini tutma ve raporlama
        // -----------------------------
        String musteriAdi = "Ahmet Yılmaz";
        int musteriYasi = 32;
        double bakiye = 1540.75;
        boolean aktifMi = true;
        char cinsiyet = 'E';

        System.out.println("\nMüşteri Bilgileri:");
        System.out.println("Adı: " + musteriAdi);
        System.out.println("Yaşı: " + musteriYasi);
        System.out.println("Bakiye: " + bakiye + " TL");
        System.out.println("Aktif mi?: " + (aktifMi ? "Evet" : "Hayır"));
        System.out.println("Cinsiyet: " + (cinsiyet == 'E' ? "Erkek" : "Kadın"));

    }
}
