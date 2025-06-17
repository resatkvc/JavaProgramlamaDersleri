package JavaDersleri.D9_HataYönetimiAndGenericType;

// Generic (jenerik) bir kutu sınıfı. Her tipte veri saklayabilir.
class Kutu<T> {
    private T icerik;
    // Constructor ile kutunun içeriği atanır.
    public Kutu(T icerik) {
        this.icerik = icerik;
    }
    // Kutunun içeriği döndürülür.
    public T getIcerik() {
        return icerik;
    }
}

public class C8_GenericType {
    public static void main(String[] args) {
        // String tipinde kutu oluşturuluyor.
        Kutu<String> stringKutu = new Kutu<>("Merhaba");
        // Integer tipinde kutu oluşturuluyor.
        Kutu<Integer> intKutu = new Kutu<>(123);
        // Kutuların içeriği ekrana yazdırılıyor.
        System.out.println(stringKutu.getIcerik());
        System.out.println(intKutu.getIcerik());
    }
} 