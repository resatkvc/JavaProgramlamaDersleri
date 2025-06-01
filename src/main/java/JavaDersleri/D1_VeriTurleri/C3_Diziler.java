package JavaDersleri.D1_VeriTurleri;

public class C3_Diziler {
    public static void main(String[] args) {

        // Dizi (Array): Aynı türdeki verilerin sıralı koleksiyonudur. Sabit boyutlu. Elemanlara indeks ile erişim sağlar.

        // 1. Dizi tanımlama ve başlatma (elemanları belirterek)
        int[] sayilar = {10, 20, 30, 40, 50};

        System.out.println("--- Dizi Örneği 1 ---");
        // Dizinin elemanlarına erişme (indeks 0'dan başlar)
        System.out.println("Dizinin ilk elemanı: " + sayilar[0]); // 10
        System.out.println("Dizinin üçüncü elemanı: " + sayilar[2]); // 30
        System.out.println("Dizinin son elemanı: " + sayilar[sayilar.length - 1]); // 50

        // Dizinin uzunluğunu alma
        System.out.println("Dizinin uzunluğu: " + sayilar.length); // 5

        // Dizinin elemanlarını döngü ile yazdırma
        System.out.println("Dizi elemanları:");
        for (int i = 0; i < sayilar.length; i++) {
            System.out.print(sayilar[i] + (i < sayilar.length - 1 ? ", " : ""));
        }

        System.out.println(); // Boş satır

        // 2. Dizi tanımlama (boyutunu belirterek) ve sonra elemanları atama
        String[] meyveler = new String[4]; // 4 elemanlı bir String dizisi oluşturuldu
        meyveler[0] = "Elma";
        meyveler[1] = "Muz";
        meyveler[2] = "Çilek";
        meyveler[3] = "Portakal";

        System.out.println();
        System.out.println("Meyveler dizisinin uzunluğu: " + meyveler.length);

        // For-each döngüsü ile dizi elemanlarını yazdırma
        System.out.println("Meyveler:");
        for (String meyve : meyveler) {
            System.out.print(meyve + " ");
        }

        System.out.println(); // Boş satır

        // 3. Farklı veri tiplerinde dizi örnekleri
        double[] ondalikliSayilar = {1.1, 2.2, 3.3};
        boolean[] dogruYanlis = {true, false, true};

        System.out.println("Ondalıklı Sayılar dizisinin ilk elemanı: " + ondalikliSayilar[0]);
        System.out.println("Boolean dizisinin ikinci elemanı: " + dogruYanlis[1]);
    }
}
