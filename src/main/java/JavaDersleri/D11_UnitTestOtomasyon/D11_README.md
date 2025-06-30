# D11: Java ile Unit Test ve Test Otomasyonu Temelleri

Bu ders kapsamında, Java ile test otomasyonunun temelleri ve profesyonel kullanımına dair önemli başlıklar işlenmiştir.

---

## 1. JUnit/TestNG ile Test Yazma
- JUnit ve TestNG, Java'da en çok kullanılan test framework'leridir.
- Test sınıfları ve metotları, özel anotasyonlarla işaretlenir.
- Temel anotasyonlar:
  - `@Test`: Test metodu olduğunu belirtir.
  - `@BeforeEach`, `@AfterEach`: Her testten önce/sonra çalışır.
  - `@BeforeAll`, `@AfterAll`: Tüm testlerden önce/sonra bir kez çalışır.

## 2. Assertion'lar ve Test Sonuçlarının Değerlendirilmesi
- Assertion'lar, beklenen ve gerçek değerlerin karşılaştırılmasını sağlar.
- Temel assertion örnekleri:
  - `Assertions.assertEquals(expected, actual)`
  - `Assertions.assertTrue(condition)`
  - `Assertions.assertFalse(condition)`
  - `Assertions.assertNotNull(object)`
- Test başarısız olursa, hata mesajı ile raporlanır.

## 3. Test Lifecycle (Before/After Metotları)
- Testlerin başında ve sonunda çalışacak kodlar için kullanılır.
- Kaynak hazırlama, temizleme, driver başlatma/kapama gibi işlemler burada yapılır.

## 4. Parametrik Testler
- Farklı veri setleriyle aynı testin tekrar tekrar çalıştırılması için kullanılır.
- JUnit 5'te `@ParameterizedTest` ve `@ValueSource`, `@CsvSource` gibi anotasyonlar kullanılır.

## 5. Uygulama Akışı (Örnek Senaryo)
1. Test sınıfı oluşturulur ve gerekli setup işlemleri yapılır.
2. Test metotları ile arama fonksiyonu ve sonuçlar test edilir.
3. Assertion'lar ile test sonuçları doğrulanır.
4. Parametrik test ile farklı arama kelimeleri denenir.
