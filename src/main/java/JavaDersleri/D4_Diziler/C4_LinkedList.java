package JavaDersleri.D4_Diziler;

import java.util.LinkedList;

public class C4_LinkedList {
    public static void main(String[] args) {
        // LinkedList tanımlama
        LinkedList<String> sehirler = new LinkedList<>();

        // LinkedList'e eleman ekleme
        sehirler.add("Ankara");
        sehirler.add("İstanbul");
        sehirler.add("İzmir");
        sehirler.add("Bursa");

        // LinkedList elemanlarını ekrana yazdırma
        System.out.println("LinkedList elemanları:");
        for (String sehir : sehirler) {
            System.out.println(sehir);
        }

        // Listenin başına ve sonuna eleman ekleme
        sehirler.addFirst("Adana");
        sehirler.addLast("Antalya");
        System.out.println("\nBaşına ve sonuna ekledikten sonra:");
        for (String sehir : sehirler) {
            System.out.println(sehir);
        }

        // Eleman silme
        sehirler.remove("İzmir");
        System.out.println("\n'İzmir' silindikten sonra:");
        for (String sehir : sehirler) {
            System.out.println(sehir);
        }

        // İlk ve son elemanı alma
        System.out.println("\nİlk şehir: " + sehirler.getFirst());
        System.out.println("Son şehir: " + sehirler.getLast());

        // -----------------------------
        // Projede nasıl kullanılır?
        // Örnek: Bir görev listesi uygulaması - görev ekleme, tamamlama ve kalan görevleri listeleme
        // -----------------------------
        LinkedList<String> gorevler = new LinkedList<>();
        gorevler.add("Mail kontrolü");
        gorevler.add("Toplantı");
        gorevler.add("Rapor yazımı");
        gorevler.add("Kod inceleme");

        // Bir görevi tamamlama (listeden çıkarma)
        gorevler.remove("Toplantı");
        System.out.println("\nKalan görevler:");
        for (String gorev : gorevler) {
            System.out.println(gorev);
        }
    }
} 