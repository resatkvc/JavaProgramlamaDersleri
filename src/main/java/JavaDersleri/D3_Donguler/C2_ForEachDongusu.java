package JavaDersleri.D3_Donguler;

import java.util.ArrayList;
import java.util.List;

/**
 * ForEach Döngüsü:
 * - Diziler ve koleksiyonlar üzerinde kolay gezinme sağlar
 * - İndeks kullanmadan elemanlara erişim imkanı sunar
 * - Daha temiz ve okunabilir kod yazımı sağlar
 * - Her türlü veri tipi ile kullanılabilir
 * - İç içe kullanılarak çok boyutlu diziler işlenebilir
 */
public class C2_ForEachDongusu {
    public static void main(String[] args) {
        // Örnek 1: Dizi üzerinde for-each döngüsü
        int[] sayilar = {1, 2, 3, 4, 5};
        System.out.println("Dizideki sayılar:");
        for (int sayi : sayilar) {
            System.out.println(sayi);
        }

        // Örnek 2: String dizisi üzerinde for-each
        String[] meyveler = {"Elma", "Armut", "Muz", "Çilek"};
        System.out.println("\nMeyveler:");
        for (String meyve : meyveler) {
            System.out.println(meyve);
        }

        // Örnek 3: ArrayList üzerinde for-each
        List<String> sehirler = new ArrayList<>();
        sehirler.add("İstanbul");
        sehirler.add("Ankara");
        sehirler.add("İzmir");
        sehirler.add("Bursa");

        System.out.println("\nŞehirler:");
        for (String sehir : sehirler) {
            System.out.println(sehir);
        }

        // Örnek 4: İç içe for-each (2 boyutlu dizi)
        int[][] matris = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("\nMatris elemanları:");
        for (int[] satir : matris) {
            for (int eleman : satir) {
                System.out.print(eleman + " ");
            }
            System.out.println();
        }
    }
}
