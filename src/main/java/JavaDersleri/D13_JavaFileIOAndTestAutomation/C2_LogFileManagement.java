package JavaDersleri.D13_JavaFileIOAndTestAutomation;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Log File Management
 * ------------------
 * Test otomasyonunda log dosyaları yönetimi:
 * - Test adımlarını log dosyasına yazma
 * - Hata durumlarını ayrı log dosyasına kaydetme
 * - Log dosyalarını tarih/saat ile organize etme
 * 
 * Gerçek projede kullanım:
 * - Test sürecini takip etme
 * - Hata ayıklama için detaylı log tutma
 * - Test raporları için log analizi
 */
public class C2_LogFileManagement {
    
    private static final String LOG_DIR = "test-logs";
    private static final String ERROR_LOG_DIR = "error-logs";
    private static final AtomicInteger testCounter = new AtomicInteger(1);
    
    /**
     * Log dosyası yöneticisi sınıfı
     */
    static class TestLogger {
        private BufferedWriter logWriter;
        private BufferedWriter errorWriter;
        private String testName;
        private String logFileName;
        private String errorLogFileName;
        
        public TestLogger(String testName) {
            this.testName = testName;
            initializeLogFiles();
        }
        
        /**
         * Log dosyalarını başlat
         */
        private void initializeLogFiles() {
            try {
                // Log klasörlerini oluştur
                Files.createDirectories(Paths.get(LOG_DIR));
                Files.createDirectories(Paths.get(ERROR_LOG_DIR));
                
                // Log dosya isimlerini oluştur
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                this.logFileName = LOG_DIR + "/" + testName + "_" + timestamp + ".log";
                this.errorLogFileName = ERROR_LOG_DIR + "/" + testName + "_ERROR_" + timestamp + ".log";
                
                // Log dosyalarını oluştur
                this.logWriter = Files.newBufferedWriter(Paths.get(logFileName));
                this.errorWriter = Files.newBufferedWriter(Paths.get(errorLogFileName));
                
                // Başlangıç log mesajı
                logInfo("Test başlatıldı: " + testName);
                logInfo("Log dosyası: " + logFileName);
                logInfo("Hata log dosyası: " + errorLogFileName);
                
            } catch (IOException e) {
                System.err.println("Log dosyaları oluşturma hatası: " + e.getMessage());
            }
        }
        
        /**
         * Bilgi mesajını log dosyasına yaz
         */
        public void logInfo(String message) {
            writeLog("INFO", message, logWriter);
        }
        
        /**
         * Uyarı mesajını log dosyasına yaz
         */
        public void logWarning(String message) {
            writeLog("WARNING", message, logWriter);
        }
        
        /**
         * Hata mesajını hem normal log hem de hata log dosyasına yaz
         */
        public void logError(String message, Exception exception) {
            writeLog("ERROR", message, logWriter);
            writeLog("ERROR", message + " - Exception: " + exception.getMessage(), errorWriter);
            
            // Stack trace'i hata log dosyasına yaz
            try {
                errorWriter.write("Stack Trace:\n");
                exception.printStackTrace(new PrintWriter(errorWriter));
                errorWriter.write("\n");
                errorWriter.flush();
            } catch (IOException e) {
                System.err.println("Stack trace yazma hatası: " + e.getMessage());
            }
        }
        
        /**
         * Test adımını log dosyasına yaz
         */
        public void logTestStep(String stepName, String description) {
            String message = "Test Adımı: " + stepName + " - " + description;
            writeLog("STEP", message, logWriter);
        }
        
        /**
         * Test sonucunu log dosyasına yaz
         */
        public void logTestResult(String result, String details) {
            String message = "Test Sonucu: " + result + " - " + details;
            writeLog("RESULT", message, logWriter);
        }
        
        /**
         * Log mesajını dosyaya yaz
         */
        private void writeLog(String level, String message, BufferedWriter writer) {
            try {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
                String logEntry = String.format("[%s] [%s] [%s] %s%n", 
                    timestamp, level, testName, message);
                
                writer.write(logEntry);
                writer.flush();
                
                // Konsola da yazdır
                System.out.print(logEntry);
                
            } catch (IOException e) {
                System.err.println("Log yazma hatası: " + e.getMessage());
            }
        }
        
        /**
         * Log dosyalarını kapat
         */
        public void close() {
            try {
                logInfo("Test tamamlandı: " + testName);
                if (logWriter != null) {
                    logWriter.close();
                }
                if (errorWriter != null) {
                    errorWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Log dosyaları kapatma hatası: " + e.getMessage());
            }
        }
    }
    
    /**
     * Log dosyalarını temizleme (eski logları silme)
     */
    public static void cleanOldLogs(int daysToKeep) {
        try {
            LocalDateTime cutoffDate = LocalDateTime.now().minusDays(daysToKeep);
            
            // Normal log dosyalarını temizle
            cleanDirectory(LOG_DIR, cutoffDate);
            
            // Hata log dosyalarını temizle
            cleanDirectory(ERROR_LOG_DIR, cutoffDate);
            
            System.out.println("Eski log dosyaları temizlendi (son " + daysToKeep + " gün korundu)");
            
        } catch (IOException e) {
            System.err.println("Log temizleme hatası: " + e.getMessage());
        }
    }
    
    /**
     * Belirtilen klasördeki eski dosyaları temizle
     */
    private static void cleanDirectory(String directory, LocalDateTime cutoffDate) throws IOException {
        if (!Files.exists(Paths.get(directory))) {
            return;
        }
        
        Files.list(Paths.get(directory))
            .filter(Files::isRegularFile)
            .forEach(file -> {
                try {
                    LocalDateTime fileTime = LocalDateTime.parse(
                        file.getFileName().toString().split("_")[1].split("\\.")[0],
                        DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")
                    );
                    
                    if (fileTime.isBefore(cutoffDate)) {
                        Files.delete(file);
                        System.out.println("Silinen dosya: " + file.getFileName());
                    }
                } catch (Exception e) {
                    System.err.println("Dosya silme hatası: " + file.getFileName() + " - " + e.getMessage());
                }
            });
    }
    
    /**
     * Log dosyalarını analiz etme
     */
    public static void analyzeLogs() {
        try {
            System.out.println("\n=== Log Analizi ===");
            
            // Normal log dosyalarını analiz et
            analyzeDirectory(LOG_DIR, "Normal Loglar");
            
            // Hata log dosyalarını analiz et
            analyzeDirectory(ERROR_LOG_DIR, "Hata Logları");
            
        } catch (IOException e) {
            System.err.println("Log analizi hatası: " + e.getMessage());
        }
    }
    
    /**
     * Belirtilen klasördeki log dosyalarını analiz et
     */
    private static void analyzeDirectory(String directory, String title) throws IOException {
        if (!Files.exists(Paths.get(directory))) {
            System.out.println(title + ": Klasör bulunamadı");
            return;
        }
        
        System.out.println("\n" + title + ":");
        
        Files.list(Paths.get(directory))
            .filter(Files::isRegularFile)
            .forEach(file -> {
                try {
                    long size = Files.size(file);
                    String fileName = file.getFileName().toString();
                    
                    // Dosya adından tarihi çıkar (TestName_YYYYMMDD_HHMMSS.log veya TestName_ERROR_YYYYMMDD_HHMMSS.log formatı)
                    if (fileName.contains("_") && fileName.contains(".")) {
                        String[] parts = fileName.split("_");
                        String datePart = null;
                        
                        if (parts.length >= 3) {
                            if (fileName.contains("_ERROR_")) {
                                // Hata log dosyası: TestName_ERROR_YYYYMMDD_HHMMSS.log
                                datePart = parts[2] + "_" + parts[3].split("\\.")[0];
                            } else {
                                // Normal log dosyası: TestName_YYYYMMDD_HHMMSS.log
                                datePart = parts[1] + "_" + parts[2].split("\\.")[0];
                            }
                            
                            LocalDateTime creationTime = LocalDateTime.parse(datePart, 
                                DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
                            
                            System.out.printf("  %s - Boyut: %d bytes - Tarih: %s%n", 
                                fileName, size, creationTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                        } else {
                            System.out.printf("  %s - Boyut: %d bytes - Tarih: Bilinmiyor%n", fileName, size);
                        }
                    } else {
                        System.out.printf("  %s - Boyut: %d bytes - Tarih: Bilinmiyor%n", fileName, size);
                    }
                    
                } catch (Exception e) {
                    System.err.println("Dosya analiz hatası: " + file.getFileName() + " - " + e.getMessage());
                }
            });
    }
    
    /**
     * Örnek test senaryosu: E-ticaret ürün arama testi
     */
    public static void runProductSearchTest() {
        TestLogger logger = new TestLogger("ProductSearchTest");
        
        try {
            logger.logInfo("E-ticaret ürün arama testi başlatıldı");
            
            // Test adımı 1: Sayfa açma
            logger.logTestStep("Sayfa Açma", "E-ticaret ana sayfası açılıyor");
            Thread.sleep(1000); // Simüle edilmiş bekleme
            logger.logInfo("Ana sayfa başarıyla açıldı");
            
            // Test adımı 2: Arama kutusuna tıklama
            logger.logTestStep("Arama Kutusu", "Arama kutusuna tıklanıyor");
            Thread.sleep(500);
            logger.logInfo("Arama kutusuna tıklandı");
            
            // Test adımı 3: Ürün arama
            String searchTerm = "laptop";
            logger.logTestStep("Ürün Arama", "'" + searchTerm + "' aranıyor");
            Thread.sleep(1000);
            logger.logInfo("Arama terimi girildi: " + searchTerm);
            
            // Test adımı 4: Sonuçları kontrol etme
            logger.logTestStep("Sonuç Kontrolü", "Arama sonuçları kontrol ediliyor");
            Thread.sleep(800);
            
            // Simüle edilmiş hata durumu
            if (Math.random() < 0.3) { // %30 ihtimalle hata
                throw new RuntimeException("Ürün bulunamadı: " + searchTerm);
            }
            
            logger.logInfo("Arama sonuçları başarıyla görüntülendi");
            logger.logTestResult("PASS", "Ürün arama testi başarıyla tamamlandı");
            
        } catch (InterruptedException e) {
            logger.logError("Test kesintiye uğradı", e);
            logger.logTestResult("FAIL", "Test kesintiye uğradı");
        } catch (Exception e) {
            logger.logError("Test sırasında hata oluştu", e);
            logger.logTestResult("FAIL", "Test hatası: " + e.getMessage());
        } finally {
            logger.close();
        }
    }
    
    /**
     * Örnek test senaryosu: Kullanıcı kayıt testi
     */
    public static void runUserRegistrationTest() {
        TestLogger logger = new TestLogger("UserRegistrationTest");
        
        try {
            logger.logInfo("Kullanıcı kayıt testi başlatıldı");
            
            // Test adımı 1: Kayıt sayfasına gitme
            logger.logTestStep("Sayfa Navigasyonu", "Kayıt sayfasına yönlendiriliyor");
            Thread.sleep(1000);
            logger.logInfo("Kayıt sayfası açıldı");
            
            // Test adımı 2: Form doldurma
            logger.logTestStep("Form Doldurma", "Kullanıcı bilgileri giriliyor");
            Thread.sleep(1500);
            logger.logInfo("Kullanıcı bilgileri girildi");
            
            // Test adımı 3: Doğrulama
            logger.logTestStep("Doğrulama", "Girilen bilgiler doğrulanıyor");
            Thread.sleep(800);
            logger.logInfo("Bilgiler doğrulandı");
            
            // Test adımı 4: Kayıt işlemi
            logger.logTestStep("Kayıt İşlemi", "Kullanıcı kaydı tamamlanıyor");
            Thread.sleep(1200);
            logger.logInfo("Kullanıcı kaydı tamamlandı");
            
            logger.logTestResult("PASS", "Kullanıcı kayıt testi başarıyla tamamlandı");
            
        } catch (InterruptedException e) {
            logger.logError("Test kesintiye uğradı", e);
            logger.logTestResult("FAIL", "Test kesintiye uğradı");
        } catch (Exception e) {
            logger.logError("Test sırasında hata oluştu", e);
            logger.logTestResult("FAIL", "Test hatası: " + e.getMessage());
        } finally {
            logger.close();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Test Log Yönetimi Örneği ===\n");
        
        // Eski logları temizle (7 günden eski)
        cleanOldLogs(7);
        
        // Test senaryolarını çalıştır
        runProductSearchTest();
        runUserRegistrationTest();
        
        // Log analizi yap
        analyzeLogs();
        
        System.out.println("\n=== Test Log Yönetimi Tamamlandı ===");
    }
} 