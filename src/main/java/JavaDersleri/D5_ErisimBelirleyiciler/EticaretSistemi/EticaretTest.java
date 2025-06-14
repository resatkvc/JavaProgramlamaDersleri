package JavaDersleri.D5_ErisimBelirleyiciler.EticaretSistemi;

/**
 * E-ticaret sisteminin test sınıfı
 * Erişim belirleyicilerin pratik kullanımını gösterir
 */
public class EticaretTest {
    public static void main(String[] args) {
        // Standart ürün oluşturma
        Urun standartUrun = new Urun("U001", "Kalem", 10.0, 100);
        System.out.println("Standart Ürün Bilgileri:");
        System.out.println("Ürün Kodu: " + standartUrun.getUrunKodu());
        System.out.println("Ürün Adı: " + standartUrun.getUrunAdi());
        System.out.println("Kategori: " + standartUrun.getKategori());
        
        // Standart ürün işlemleri
        standartUrun.stokGuncelle(50);
        standartUrun.fiyatGuncelle(12.5);
        
        System.out.println("\n------------------------\n");
        
        // Elektronik ürün oluşturma
        ElektronikUrun elektronikUrun = new ElektronikUrun("E001", "Akıllı Telefon", 
                                                          5000.0, 20, "Samsung", "Galaxy S21", 24);
        System.out.println("Elektronik Ürün Bilgileri:");
        System.out.println("Ürün Kodu: " + elektronikUrun.getUrunKodu());
        System.out.println("Ürün Adı: " + elektronikUrun.getUrunAdi());
        System.out.println("Kategori: " + elektronikUrun.getKategori());
        
        // Elektronik ürün işlemleri
        elektronikUrun.stokGuncelle(5);
        elektronikUrun.garantiBilgisiGoster();
        
        // Erişim belirleyicilerin önemi:
        // 1. Private değişkenlere doğrudan erişilemez
        // System.out.println(elektronikUrun.fiyat); // Hata! Private değişkene erişilemez
        
        // 2. Protected değişkenlere sadece alt sınıflardan erişilebilir
        // System.out.println(standartUrun.kategori); // Hata! Protected değişkene dışarıdan erişilemez
        
        // 3. Public metotlar her yerden erişilebilir
        System.out.println("\nSon Durum:");
        System.out.println("Standart Ürün Stok: " + standartUrun.getStokMiktari());
        System.out.println("Elektronik Ürün Stok: " + elektronikUrun.getStokMiktari());
    }
} 