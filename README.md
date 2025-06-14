# Java Erişim Belirleyiciler (Access Modifiers) Örnekleri

Bu proje, Java'da erişim belirleyicilerin (access modifiers) kullanımını gösteren örnekler içermektedir.

## Kodlama Sırası ve Açıklamaları

### 1. Temel Erişim Belirleyici Örnekleri

İlk olarak temel erişim belirleyici örneklerini oluşturduk:

1. **C1_Public.java**
   - Public erişim belirleyicisini gösteren basit bir örnek
   - Public değişken, metot ve constructor örnekleri
   - Her yerden erişilebilir yapıların gösterimi

2. **C2_Protected.java**
   - Protected erişim belirleyicisini gösteren örnek
   - Alt sınıf kullanımını içeren yapı
   - Aynı paket ve alt sınıflardan erişim örnekleri

3. **C3_Default.java**
   - Default (package-private) erişim belirleyicisini gösteren örnek
   - Erişim belirleyici yazılmadığında nasıl çalıştığının gösterimi
   - Sadece aynı paket içinden erişim örnekleri

4. **C4_Private.java**
   - Private erişim belirleyicisini gösteren örnek
   - Encapsulation (kapsülleme) kavramının factory metot örneğiyle açıklanması
   - Sadece sınıf içinden erişilebilir yapıların gösterimi

### 2. Gerçek Proje Örneği: E-Ticaret Sistemi

Sonra gerçek bir proje örneği olarak e-ticaret sistemini oluşturduk:

#### EticaretSistemi Paketi Altında:

1. **Urun.java (Ana Sınıf)**
   - Private değişkenler: urunKodu, urunAdi, fiyat, stokMiktari
   - Protected değişken: kategori
   - Public metotlar: stokGuncelle(), fiyatGuncelle()
   - Protected metot: kategoriGuncelle()
   - Private metot: stokKontrol()
   - Public getter metotları

2. **ElektronikUrun.java (Alt Sınıf)**
   - Private değişkenler: marka, model, garantiSuresi
   - Protected metodu kullanarak kategori güncelleme
   - Elektronik ürünlere özel garanti bilgisi gösterme metodu

3. **EticaretTest.java (Test Sınıfı)**
   - Standart ürün oluşturma ve işlemleri
   - Elektronik ürün oluşturma ve işlemleri
   - Erişim belirleyicilerin kullanımını gösteren örnekler
   - Hata verecek durumların yorum satırı olarak gösterimi
