# D10: Selenium WebDriver ile Web Test Otomasyonu

Bu ders kapsamında, Selenium WebDriver ile web test otomasyonunun temelleri ve profesyonel kullanımına dair önemli başlıklar işlenmiştir.

---

## 1. WebDriver Kurulumu ve Temel Komutlar
- WebDriver, farklı tarayıcılarda otomasyon testi yapmak için kullanılır.
- ChromeDriver, FirefoxDriver gibi tarayıcı sürücüleri ile çalışır.
- Temel komutlar:
  - `driver.get(url)`: Belirtilen adrese gider.
  - `driver.quit()`: Tarayıcıyı kapatır.
  - `driver.manage().window().maximize()`: Pencereyi tam ekran yapar.

## 2. Web Elementleri Bulma ve Etkileşim
- Web sayfasındaki elementler çeşitli locator'lar ile bulunur:
  - `By.id`, `By.name`, `By.cssSelector`, `By.xpath` vb.
- Elementlerle etkileşim:
  - `sendKeys()`, `click()`, `clear()`, `getText()` gibi metotlar kullanılır.

## 3. Wait Kullanımı (Explicit/Implicit Wait)
- Web uygulamalarında elementlerin yüklenmesini beklemek için kullanılır.
- **Implicit Wait:**
  - `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));`
- **Explicit Wait:**
  - `WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));`
  - `wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));`

## 4. Page Object Model (POM) Tasarımı
- Kodun okunabilirliğini ve bakımını artırmak için kullanılır.
- Her sayfa için ayrı bir Java sınıfı oluşturulur (ör: `HomePage`, `ResultsPage`).
- Sayfa ile ilgili tüm işlemler ve locator'lar bu sınıflarda toplanır.

## 5. Uygulama Akışı (Örnek Senaryo)
1. WebDriver başlatılır ve Magento demo sitesine gidilir.
2. `HomePage` üzerinden arama işlemi yapılır (ör: "jacket").
3. `ResultsPage` üzerinden arama sonuçları kontrol edilir.
4. Sonuçlar ekrana yazdırılır ve tarayıcı kapatılır.
