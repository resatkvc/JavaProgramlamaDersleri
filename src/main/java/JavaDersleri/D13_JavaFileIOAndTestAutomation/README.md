# D13 - Java File I/O ve Test Otomasyonu

Bu klasör, Java File I/O (Dosya Giriş/Çıkış) işlemlerini test otomasyonu ile birleştiren pratik örnekleri içerir. Gerçek projelerde kullanılan dosya yönetimi tekniklerini öğrenirsiniz.

## 📁 Dosya Yapısı

### C1_TestDataFileOperations.java
**Test Verisi Dosya İşlemleri**

Test otomasyonunda dosya işlemlerinin temel kullanımlarını gösterir:

- **CSV Dosyasından Test Verisi Okuma**: Test verilerini merkezi CSV dosyalarından okuma
- **JSON Formatında Test Sonuçları**: Test sonuçlarını JSON formatında dosyaya yazma
- **HTML Test Raporu Oluşturma**: Test sonuçlarını HTML formatında raporlama
- **E-ticaret Login Testi**: Pratik bir test senaryosu örneği

**Öğrenilen Kavramlar:**
- `BufferedReader` ve `BufferedWriter` kullanımı
- CSV dosya parsing
- JSON formatında veri yazma
- HTML rapor oluşturma
- Test verisi yönetimi

### C2_LogFileManagement.java
**Log Dosyası Yönetimi**

Test sürecinde log dosyalarının yönetimini gösterir:

- **Test Logger Sınıfı**: Özel log yöneticisi sınıfı
- **Log Seviyeleri**: INFO, WARNING, ERROR, STEP, RESULT
- **Ayrı Hata Logları**: Hataları ayrı dosyalarda toplama
- **Log Temizleme**: Eski log dosyalarını otomatik silme
- **Log Analizi**: Log dosyalarını analiz etme

**Öğrenilen Kavramlar:**
- `Files.createDirectories()` ile klasör oluşturma
- Timestamp ile dosya isimlendirme
- Log dosyası organizasyonu
- Exception handling ile log yazma
- Dosya tarih analizi

### C3_ScreenshotFileHandling.java
**Screenshot Dosya Yönetimi**

Test sırasında screenshot'ların yönetimini gösterir:

- **Screenshot Manager**: Screenshot yöneticisi sınıfı
- **Başarılı/Başarısız Ayrımı**: Test sonucuna göre klasörleme
- **HTML Screenshot Raporu**: Screenshot'ları HTML'de görüntüleme
- **Otomatik Temizleme**: Eski screenshot'ları silme
- **Screenshot İstatistikleri**: Screenshot sayılarını analiz etme

**Öğrenilen Kavramlar:**
- Dosya sistemi organizasyonu
- HTML dosya oluşturma
- Dosya boyutu ve tarih analizi
- Simüle edilmiş screenshot oluşturma
- Test adımı bazlı dosya isimlendirme

### C4_ConfigurationFileReader.java
**Konfigürasyon Dosyası Okuma**

Test konfigürasyonlarını dosyalardan okuma tekniklerini gösterir:

- **Properties Dosyası Okuma**: Java Properties formatında konfigürasyon
- **JSON Dosyası Okuma**: JSON formatında konfigürasyon
- **Environment-Specific Configs**: Ortama özel konfigürasyonlar
- **Konfigürasyon Doğrulama**: Gerekli ayarları kontrol etme
- **Konfigürasyon Karşılaştırma**: Farklı ortamları karşılaştırma

**Öğrenilen Kavramlar:**
- `Properties` sınıfı kullanımı
- Basit JSON parsing
- Environment-based konfigürasyon
- Konfigürasyon validasyonu
- Dosya birleştirme ve override

## 🎯 Öğrenme Hedefleri

Bu klasörde şunları öğreneceksiniz:

1. **Dosya İşlemleri**: Java'da dosya okuma/yazma teknikleri
2. **Test Verisi Yönetimi**: Test verilerini dosyalardan okuma
3. **Log Yönetimi**: Test sürecini log dosyalarıyla takip etme
4. **Screenshot Yönetimi**: Test kanıtlarını görsel olarak saklama
5. **Konfigürasyon Yönetimi**: Test ayarlarını merkezi yönetme
6. **Raporlama**: Test sonuçlarını farklı formatlarda raporlama

## 🚀 Gerçek Proje Kullanımı

Bu örnekler gerçek test otomasyonu projelerinde kullanılan teknikleri yansıtır:

- **Selenium WebDriver** ile entegrasyon
- **TestNG/JUnit** test framework'leri
- **Maven/Gradle** build araçları
- **CI/CD** pipeline entegrasyonu
- **Test raporlama** araçları

## 📋 Çalıştırma

Her dosyayı ayrı ayrı çalıştırabilirsiniz:

```bash
# Test verisi dosya işlemleri
java JavaDersleri.D13_JavaFileIOAndTestAutomation.C1_TestDataFileOperations

# Log dosyası yönetimi
java JavaDersleri.D13_JavaFileIOAndTestAutomation.C2_LogFileManagement

# Screenshot dosya yönetimi
java JavaDersleri.D13_JavaFileIOAndTestAutomation.C3_ScreenshotFileHandling

# Konfigürasyon dosyası okuma
java JavaDersleri.D13_JavaFileIOAndTestAutomation.C4_ConfigurationFileReader
```

## 📁 Oluşturulan Dosyalar

Programlar çalıştırıldığında şu dosyalar oluşur:

- `testdata.csv` - Test verisi dosyası
- `test-results.json` - Test sonuçları
- `test-report.html` - HTML test raporu
- `test-logs/` - Log dosyaları klasörü
- `error-logs/` - Hata logları klasörü
- `test-screenshots/` - Screenshot dosyaları klasörü
- `test-config/` - Konfigürasyon dosyaları klasörü
- `env-config/` - Ortam konfigürasyonları klasörü

## 🔧 Özelleştirme

Bu örnekleri kendi projelerinize uyarlayabilirsiniz:

- Farklı dosya formatları ekleyebilirsiniz
- Yeni log seviyeleri tanımlayabilirsiniz
- Screenshot formatlarını değiştirebilirsiniz
- Konfigürasyon şemalarını genişletebilirsiniz

Bu klasör, Java File I/O ve test otomasyonunu birleştirerek gerçek dünya senaryolarında kullanılan teknikleri öğretir. 