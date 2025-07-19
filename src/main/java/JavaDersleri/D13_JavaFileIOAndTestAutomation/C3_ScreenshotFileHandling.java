package JavaDersleri.D13_JavaFileIOAndTestAutomation;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Screenshot File Handling
 * -----------------------
 * Test otomasyonunda screenshot yönetimi:
 * - Screenshot'ları belirli klasörlere kaydetme
 * - Dosya isimlendirme stratejileri (timestamp + test adı)
 * - Screenshot dosyalarını otomatik temizleme
 * 
 * Gerçek projede kullanım:
 * - Test hatalarında görsel kanıt toplama
 * - Test raporlarına screenshot ekleme
 * - Screenshot'ları organize etme ve yönetme
 */
public class C3_ScreenshotFileHandling {
    
    private static final String SCREENSHOT_DIR = "test-screenshots";
    private static final String PASS_SCREENSHOT_DIR = "pass-screenshots";
    private static final String FAIL_SCREENSHOT_DIR = "fail-screenshots";
    private static final AtomicInteger screenshotCounter = new AtomicInteger(1);
    
    /**
     * Screenshot yöneticisi sınıfı
     */
    static class ScreenshotManager {
        private String testName;
        private String screenshotBasePath;
        
        public ScreenshotManager(String testName) {
            this.testName = testName;
            this.screenshotBasePath = SCREENSHOT_DIR + "/" + testName;
            createScreenshotDirectories();
        }
        
        /**
         * Screenshot klasörlerini oluştur
         */
        private void createScreenshotDirectories() {
            try {
                Files.createDirectories(Paths.get(screenshotBasePath));
                Files.createDirectories(Paths.get(screenshotBasePath + "/pass"));
                Files.createDirectories(Paths.get(screenshotBasePath + "/fail"));
                System.out.println("Screenshot klasörleri oluşturuldu: " + screenshotBasePath);
            } catch (IOException e) {
                System.err.println("Screenshot klasörleri oluşturma hatası: " + e.getMessage());
            }
        }
        
        /**
         * Başarılı test için screenshot kaydet
         */
        public String capturePassScreenshot(String stepName) {
            return captureScreenshot(stepName, "pass");
        }
        
        /**
         * Başarısız test için screenshot kaydet
         */
        public String captureFailScreenshot(String stepName) {
            return captureScreenshot(stepName, "fail");
        }
        
        /**
         * Genel screenshot kaydetme
         */
        public String captureScreenshot(String stepName, String type) {
            try {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
                String fileName = String.format("%s_%s_%s_%03d.png", 
                    testName, stepName, timestamp, screenshotCounter.getAndIncrement());
                
                String filePath = screenshotBasePath + "/" + type + "/" + fileName;
                
                // Simüle edilmiş screenshot oluşturma
                createMockScreenshot(filePath, stepName, type);
                
                System.out.println("Screenshot kaydedildi: " + filePath);
                return filePath;
                
            } catch (IOException e) {
                System.err.println("Screenshot kaydetme hatası: " + e.getMessage());
                return null;
            }
        }
        
        /**
         * Simüle edilmiş screenshot oluşturma
         * Gerçek projede burada Selenium veya başka bir tool kullanılır
         */
        private void createMockScreenshot(String filePath, String stepName, String type) throws IOException {
            // Basit bir HTML dosyası oluştur (gerçek screenshot yerine)
            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html>\n");
            html.append("<html>\n");
            html.append("<head>\n");
            html.append("    <title>Screenshot - ").append(stepName).append("</title>\n");
            html.append("    <style>\n");
            html.append("        body { font-family: Arial, sans-serif; margin: 20px; }\n");
            html.append("        .screenshot { border: 2px solid #333; padding: 20px; }\n");
            html.append("        .pass { background-color: #d4edda; }\n");
            html.append("        .fail { background-color: #f8d7da; }\n");
            html.append("    </style>\n");
            html.append("</head>\n");
            html.append("<body>\n");
            html.append("    <div class=\"screenshot ").append(type).append("\">\n");
            html.append("        <h2>Screenshot: ").append(stepName).append("</h2>\n");
            html.append("        <p><strong>Test:</strong> ").append(testName).append("</p>\n");
            html.append("        <p><strong>Tip:</strong> ").append(type.toUpperCase()).append("</p>\n");
            html.append("        <p><strong>Zaman:</strong> ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("</p>\n");
            html.append("        <p>Bu bir simüle edilmiş screenshot'tır. Gerçek projede burada web sayfasının görüntüsü olur.</p>\n");
            html.append("    </div>\n");
            html.append("</body>\n");
            html.append("</html>");
            
            // HTML dosyasını kaydet
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath.replace(".png", ".html")))) {
                writer.write(html.toString());
            }
        }
        
        /**
         * Screenshot'ları HTML raporuna ekleme
         */
        public void generateScreenshotReport() {
            try {
                String reportPath = screenshotBasePath + "/screenshot-report.html";
                StringBuilder html = new StringBuilder();
                
                html.append("<!DOCTYPE html>\n");
                html.append("<html>\n");
                html.append("<head>\n");
                html.append("    <title>Screenshot Raporu - ").append(testName).append("</title>\n");
                html.append("    <style>\n");
                html.append("        body { font-family: Arial, sans-serif; margin: 20px; }\n");
                html.append("        .screenshot-item { margin: 20px 0; padding: 10px; border: 1px solid #ddd; }\n");
                html.append("        .pass { background-color: #d4edda; }\n");
                html.append("        .fail { background-color: #f8d7da; }\n");
                html.append("    </style>\n");
                html.append("</head>\n");
                html.append("<body>\n");
                html.append("    <h1>Screenshot Raporu</h1>\n");
                html.append("    <h2>Test: ").append(testName).append("</h2>\n");
                html.append("    <p>Oluşturulma Tarihi: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("</p>\n");
                
                // Başarılı screenshot'ları listele
                html.append("    <h3>Başarılı Screenshot'lar</h3>\n");
                listScreenshots(screenshotBasePath + "/pass", html, "pass");
                
                // Başarısız screenshot'ları listele
                html.append("    <h3>Başarısız Screenshot'lar</h3>\n");
                listScreenshots(screenshotBasePath + "/fail", html, "fail");
                
                html.append("</body>\n");
                html.append("</html>");
                
                try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(reportPath))) {
                    writer.write(html.toString());
                    System.out.println("Screenshot raporu oluşturuldu: " + reportPath);
                }
                
            } catch (IOException e) {
                System.err.println("Screenshot raporu oluşturma hatası: " + e.getMessage());
            }
        }
        
        /**
         * Screenshot'ları HTML'e listele
         */
        private void listScreenshots(String directory, StringBuilder html, String type) throws IOException {
            if (!Files.exists(Paths.get(directory))) {
                html.append("    <p>Bu kategoride screenshot bulunamadı.</p>\n");
                return;
            }
            
            Files.list(Paths.get(directory))
                .filter(Files::isRegularFile)
                .filter(file -> file.toString().endsWith(".html"))
                .forEach(file -> {
                    String fileName = file.getFileName().toString();
                    String stepName = fileName.split("_")[1];
                    
                    html.append("    <div class=\"screenshot-item ").append(type).append("\">\n");
                    html.append("        <h4>").append(stepName).append("</h4>\n");
                    html.append("        <p><strong>Dosya:</strong> ").append(fileName).append("</p>\n");
                    html.append("        <p><strong>Boyut:</strong> ").append(getFileSize(file)).append(" bytes</p>\n");
                    html.append("        <a href=\"").append(file.getFileName()).append("\" target=\"_blank\">Screenshot'ı Görüntüle</a>\n");
                    html.append("    </div>\n");
                });
        }
        
        /**
         * Dosya boyutunu al
         */
        private long getFileSize(Path file) {
            try {
                return Files.size(file);
            } catch (IOException e) {
                return 0;
            }
        }
    }
    
    /**
     * Eski screenshot'ları temizleme
     */
    public static void cleanOldScreenshots(int daysToKeep) {
        try {
            LocalDateTime cutoffDate = LocalDateTime.now().minusDays(daysToKeep);
            
            if (Files.exists(Paths.get(SCREENSHOT_DIR))) {
                Files.walk(Paths.get(SCREENSHOT_DIR))
                    .filter(Files::isRegularFile)
                    .forEach(file -> {
                        try {
                            // Dosya adından tarihi çıkar
                            String fileName = file.getFileName().toString();
                            if (fileName.contains("_")) {
                                String[] parts = fileName.split("_");
                                if (parts.length >= 2) {
                                    String datePart = parts[1];
                                    LocalDateTime fileTime = LocalDateTime.parse(datePart, 
                                        DateTimeFormatter.ofPattern("yyyyMMdd"));
                                    
                                    if (fileTime.isBefore(cutoffDate)) {
                                        Files.delete(file);
                                        System.out.println("Silinen screenshot: " + fileName);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("Screenshot silme hatası: " + file.getFileName() + " - " + e.getMessage());
                        }
                    });
            }
            
            System.out.println("Eski screenshot'lar temizlendi (son " + daysToKeep + " gün korundu)");
            
        } catch (IOException e) {
            System.err.println("Screenshot temizleme hatası: " + e.getMessage());
        }
    }
    
    /**
     * Screenshot istatistiklerini göster
     */
    public static void showScreenshotStats() {
        try {
            System.out.println("\n=== Screenshot İstatistikleri ===");
            
            if (!Files.exists(Paths.get(SCREENSHOT_DIR))) {
                System.out.println("Screenshot klasörü bulunamadı.");
                return;
            }
            
            AtomicLong totalScreenshots = new AtomicLong(0);
            AtomicLong passScreenshots = new AtomicLong(0);
            AtomicLong failScreenshots = new AtomicLong(0);
            
            // Tüm screenshot'ları say
            Files.walk(Paths.get(SCREENSHOT_DIR))
                .filter(Files::isRegularFile)
                .filter(file -> file.toString().endsWith(".html"))
                .forEach(file -> {
                    totalScreenshots.incrementAndGet();
                    String filePath = file.toString();
                    if (filePath.contains("\\pass\\") || filePath.contains("/pass/")) {
                        passScreenshots.incrementAndGet();
                    } else if (filePath.contains("\\fail\\") || filePath.contains("/fail/")) {
                        failScreenshots.incrementAndGet();
                    }
                });
            
            System.out.println("Toplam Screenshot: " + totalScreenshots.get());
            System.out.println("Başarılı Screenshot: " + passScreenshots.get());
            System.out.println("Başarısız Screenshot: " + failScreenshots.get());
            
            if (totalScreenshots.get() > 0) {
                double passRate = (double) passScreenshots.get() / totalScreenshots.get() * 100;
                System.out.printf("Başarı Oranı: %.1f%%\n", passRate);
            }
            
        } catch (IOException e) {
            System.err.println("Screenshot istatistikleri hatası: " + e.getMessage());
        }
    }
    
    /**
     * Örnek test senaryosu: E-ticaret ürün detay testi
     */
    public static void runProductDetailTest() {
        ScreenshotManager screenshotManager = new ScreenshotManager("ProductDetailTest");
        
        try {
            System.out.println("=== Ürün Detay Testi Başlatıldı ===");
            
            // Test adımı 1: Ürün listesi sayfası
            System.out.println("Adım 1: Ürün listesi sayfası açılıyor...");
            Thread.sleep(1000);
            screenshotManager.capturePassScreenshot("ProductList");
            
            // Test adımı 2: Ürün seçimi
            System.out.println("Adım 2: Ürün seçiliyor...");
            Thread.sleep(800);
            screenshotManager.capturePassScreenshot("ProductSelection");
            
            // Test adımı 3: Ürün detay sayfası
            System.out.println("Adım 3: Ürün detay sayfası açılıyor...");
            Thread.sleep(1200);
            screenshotManager.capturePassScreenshot("ProductDetail");
            
            // Test adımı 4: Sepete ekleme
            System.out.println("Adım 4: Ürün sepete ekleniyor...");
            Thread.sleep(600);
            
            // Simüle edilmiş hata durumu
            if (Math.random() < 0.2) { // %20 ihtimalle hata
                screenshotManager.captureFailScreenshot("AddToCart");
                throw new RuntimeException("Sepete ekleme başarısız");
            }
            
            screenshotManager.capturePassScreenshot("AddToCart");
            System.out.println("Adım 4: Ürün başarıyla sepete eklendi");
            
            // Test adımı 5: Sepet sayfası
            System.out.println("Adım 5: Sepet sayfası kontrol ediliyor...");
            Thread.sleep(1000);
            screenshotManager.capturePassScreenshot("CartPage");
            
            System.out.println("=== Ürün Detay Testi Başarıyla Tamamlandı ===");
            
        } catch (InterruptedException e) {
            System.err.println("Test kesintiye uğradı: " + e.getMessage());
            screenshotManager.captureFailScreenshot("TestInterrupted");
        } catch (Exception e) {
            System.err.println("Test hatası: " + e.getMessage());
            screenshotManager.captureFailScreenshot("TestError");
        } finally {
            // Screenshot raporu oluştur
            screenshotManager.generateScreenshotReport();
        }
    }
    
    /**
     * Örnek test senaryosu: Kullanıcı profil testi
     */
    public static void runUserProfileTest() {
        ScreenshotManager screenshotManager = new ScreenshotManager("UserProfileTest");
        
        try {
            System.out.println("=== Kullanıcı Profil Testi Başlatıldı ===");
            
            // Test adımı 1: Giriş sayfası
            System.out.println("Adım 1: Giriş sayfası açılıyor...");
            Thread.sleep(1000);
            screenshotManager.capturePassScreenshot("LoginPage");
            
            // Test adımı 2: Giriş yapma
            System.out.println("Adım 2: Giriş yapılıyor...");
            Thread.sleep(800);
            screenshotManager.capturePassScreenshot("LoginProcess");
            
            // Test adımı 3: Profil sayfası
            System.out.println("Adım 3: Profil sayfası açılıyor...");
            Thread.sleep(1000);
            screenshotManager.capturePassScreenshot("ProfilePage");
            
            // Test adımı 4: Profil düzenleme
            System.out.println("Adım 4: Profil düzenleniyor...");
            Thread.sleep(1200);
            screenshotManager.capturePassScreenshot("ProfileEdit");
            
            // Test adımı 5: Değişiklikleri kaydetme
            System.out.println("Adım 5: Değişiklikler kaydediliyor...");
            Thread.sleep(600);
            screenshotManager.capturePassScreenshot("ProfileSave");
            
            System.out.println("=== Kullanıcı Profil Testi Başarıyla Tamamlandı ===");
            
        } catch (InterruptedException e) {
            System.err.println("Test kesintiye uğradı: " + e.getMessage());
            screenshotManager.captureFailScreenshot("TestInterrupted");
        } catch (Exception e) {
            System.err.println("Test hatası: " + e.getMessage());
            screenshotManager.captureFailScreenshot("TestError");
        } finally {
            // Screenshot raporu oluştur
            screenshotManager.generateScreenshotReport();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Screenshot Yönetimi Örneği ===\n");
        
        // Eski screenshot'ları temizle (30 günden eski)
        cleanOldScreenshots(30);
        
        // Test senaryolarını çalıştır
        runProductDetailTest();
        runUserProfileTest();
        
        // Screenshot istatistiklerini göster
        showScreenshotStats();
        
        System.out.println("\n=== Screenshot Yönetimi Tamamlandı ===");
    }
} 