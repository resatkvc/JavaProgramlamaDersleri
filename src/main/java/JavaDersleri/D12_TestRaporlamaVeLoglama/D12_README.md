# D12: Test Raporlama ve Loglama

Bu ders kapsamında, Java ile test otomasyonunda raporlama ve loglama konularının temelleri ve profesyonel kullanımına dair önemli başlıklar işlenmiştir.

---

## 1. JUnit Raporları
- JUnit, testlerin sonucunu XML veya HTML formatında raporlayabilir.
- Maven Surefire Plugin ile otomatik raporlar alınabilir.
- Raporlar, CI/CD süreçlerinde test sonuçlarını izlemek için kullanılır.

## 2. Gelişmiş Raporlama: ExtentReports veya Allure
- ExtentReports ve Allure, test sonuçlarını görsel ve detaylı şekilde sunan popüler kütüphanelerdir.
- Test adımlarının, ekran görüntülerinin ve hata detaylarının rapora eklenmesi mümkündür.
- Raporlar HTML formatında, kolayca paylaşılabilir.

## 3. Loglama: Log4j veya Benzeri
- Log4j, test ve uygulama sırasında önemli olayların kaydını tutmak için kullanılır.
- Farklı log seviyeleri (INFO, DEBUG, ERROR, WARN) ile detaylı izleme yapılabilir.
- Loglar dosyaya, konsola veya başka bir hedefe yönlendirilebilir.

## 4. Uygulama Akışı (Örnek Senaryo)
1. Test başlatılırken ve her adımda loglama yapılır.
2. Testin başarılı veya başarısız olduğu durumlar rapora ve loglara kaydedilir.
3. Hata oluşursa ekran görüntüsü alınır ve rapora eklenir.
4. Test sonunda detaylı rapor ve loglar incelenebilir.

---

Bu dosya, D12 dersi için hem okuma rehberi hem de uygulama sırasında başvurulacak bir kaynak olarak hazırlanmıştır. 