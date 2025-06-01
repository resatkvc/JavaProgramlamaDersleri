package JavaDersleri.D1_VeriTurleri;

public class C2_StringVeriTipi {
    public static void main(String[] args) {
        String metin = "Merhaba Dünya!";
        String baskaMetin = "Java Programlama";

        System.out.println("\n--- Yeni String Örnekleri ---");

        // String birleştirme (concatenation)
        String tamMetin = metin + " " + baskaMetin;
        System.out.println("Birleştirilmiş metin: " + tamMetin);

        // String uzunluğu (length)
        System.out.println("Metin uzunluğu: " + metin.length());

        // Belirli bir indeksteki karaktere erişme
        System.out.println("Metnin 7. indeksteki karakteri: " + metin.charAt(6)); // İndeks 0'dan başlar

        // Stringi küçük harfe çevirme
        System.out.println("Metnin küçük harf hali: " + metin.toLowerCase());

        // Stringi büyük harfe çevirme
        System.out.println("Metnin büyük harf hali: " + metin.toUpperCase());

        // Bir stringin diğerini içerip içermediğini kontrol etme
        System.out.println("Metin 'Dünya' kelimesini içeriyor mu? " + metin.contains("Dünya"));

        // Bir stringin belirli bir metinle başlayıp başlamadığını kontrol etme
        System.out.println("Metin 'Merhaba' ile başlıyor mu? " + metin.startsWith("Merhaba"));

        // Bir stringin belirli bir metinle bitip bitmediğini kontrol etme
        System.out.println("Metin '!' ile bitiyor mu? " + metin.endsWith("!"));

        // Bir stringin belirli bir kısmını alma (substring)
        System.out.println("Metnin 0 ile 7. indeks arasındaki kısmı: " + metin.substring(0, 7)); // 7. indeks dahil değil

        // Stringteki belirli bir karakterin veya metnin indeksini bulma
        System.out.println("'a' karakterinin ilk geçtiği indeks: " + metin.indexOf('a'));
        System.out.println("'Dünya' metninin ilk geçtiği indeks: " + metin.indexOf("Dünya"));

        // Stringteki boşlukları silme (trim)
        String boslukluMetin = "   Başında ve sonunda boşluklar var   ";
        System.out.println("Boşluklu metin: " + boslukluMetin);
        System.out.println("Boşlukları silinmiş metin: " + boslukluMetin.trim());
    }
}
