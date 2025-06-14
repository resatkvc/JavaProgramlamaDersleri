package JavaDersleri.D5_ErisimBelirleyiciler.EticaretSistemi;

/**
 * E-ticaret sisteminde ürün sınıfı
 * Erişim belirleyicilerin gerçek bir projede nasıl kullanıldığını gösterir
 */
public class Urun {
    // Private değişkenler - Sadece bu sınıf içinden erişilebilir
    private String urunKodu;
    private String urunAdi;
    private double fiyat;
    private int stokMiktari;
    
    // Protected değişken - Alt sınıflar tarafından erişilebilir
    protected String kategori;
    
    // Public sabit değer - Her yerden erişilebilir
    public static final double MINIMUM_FIYAT = 0.01;
    
    // Constructor - Public erişim
    public Urun(String urunKodu, String urunAdi, double fiyat, int stokMiktari) {
        this.urunKodu = urunKodu;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.stokMiktari = stokMiktari;
        this.kategori = "Genel";
    }
    
    // Public metotlar - Dışarıdan erişilebilir
    public void stokGuncelle(int miktar) {
        if (stokMiktari + miktar >= 0) {
            stokMiktari += miktar;
            System.out.println("Stok güncellendi. Yeni stok: " + stokMiktari);
        } else {
            System.out.println("Yetersiz stok!");
        }
    }
    
    public void fiyatGuncelle(double yeniFiyat) {
        if (yeniFiyat >= MINIMUM_FIYAT) {
            fiyat = yeniFiyat;
            System.out.println("Fiyat güncellendi. Yeni fiyat: " + fiyat);
        } else {
            System.out.println("Geçersiz fiyat!");
        }
    }
    
    // Protected metot - Alt sınıflar tarafından kullanılabilir
    protected void kategoriGuncelle(String yeniKategori) {
        this.kategori = yeniKategori;
    }
    
    // Private yardımcı metot - Sadece sınıf içinde kullanılır
    private boolean stokKontrol() {
        return stokMiktari > 0;
    }
    
    // Public getter metotları
    public String getUrunKodu() {
        return urunKodu;
    }
    
    public String getUrunAdi() {
        return urunAdi;
    }
    
    public double getFiyat() {
        return fiyat;
    }
    
    public int getStokMiktari() {
        return stokMiktari;
    }
    
    public String getKategori() {
        return kategori;
    }
} 