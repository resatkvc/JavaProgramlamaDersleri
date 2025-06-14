package JavaDersleri.D5_ErisimBelirleyiciler.EticaretSistemi;

/**
 * Elektronik ürün sınıfı - Urun sınıfından türetilmiş
 * Protected erişim belirleyicisinin kullanımını gösterir
 */
public class ElektronikUrun extends Urun {
    // Private değişken - Sadece bu sınıf içinden erişilebilir
    private String marka;
    private String model;
    private int garantiSuresi;
    
    // Constructor
    public ElektronikUrun(String urunKodu, String urunAdi, double fiyat, 
                         int stokMiktari, String marka, String model, int garantiSuresi) {
        super(urunKodu, urunAdi, fiyat, stokMiktari);
        this.marka = marka;
        this.model = model;
        this.garantiSuresi = garantiSuresi;
        // Protected metodu kullanarak kategori güncelleme
        kategoriGuncelle("Elektronik");
    }
    
    // Public metot - Elektronik ürünlere özel işlem
    public void garantiBilgisiGoster() {
        // Protected değişkene erişim
        System.out.println("Elektronik Ürün Bilgileri:");
        System.out.println("Kategori: " + kategori);
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Garanti Süresi: " + garantiSuresi + " ay");
    }
    
    // Public getter metotları
    public String getMarka() {
        return marka;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getGarantiSuresi() {
        return garantiSuresi;
    }
} 