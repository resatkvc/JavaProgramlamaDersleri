package JavaDersleri.D13_JavaFileIOAndTestAutomation;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Configuration File Reader
 * ------------------------
 * Test otomasyonunda konfigürasyon dosyası yönetimi:
 * - Properties dosyasından test ayarlarını okuma
 * - JSON/YAML dosyasından test konfigürasyonu
 * - Environment-specific dosyaları yönetme
 * 
 * Gerçek projede kullanım:
 * - Test ortamı ayarlarını merkezi yönetme
 * - Farklı ortamlar için farklı konfigürasyonlar
 * - Test parametrelerini dosyadan okuma
 */
public class C4_ConfigurationFileReader {
    
    private static final String CONFIG_DIR = "test-config";
    private static final String ENV_CONFIG_DIR = "env-config";
    
    /**
     * Test konfigürasyonu için basit bir sınıf
     */
    static class TestConfig {
        private Properties properties;
        private Map<String, String> customSettings;
        
        public TestConfig() {
            this.properties = new Properties();
            this.customSettings = new HashMap<>();
        }
        
        public void setProperty(String key, String value) {
            properties.setProperty(key, value);
        }
        
        public String getProperty(String key) {
            return properties.getProperty(key);
        }
        
        public String getProperty(String key, String defaultValue) {
            return properties.getProperty(key, defaultValue);
        }
        
        public void setCustomSetting(String key, String value) {
            customSettings.put(key, value);
        }
        
        public String getCustomSetting(String key) {
            return customSettings.get(key);
        }
        
        public void printConfig() {
            System.out.println("=== Test Konfigürasyonu ===");
            System.out.println("Properties:");
            for (String key : properties.stringPropertyNames()) {
                System.out.println("  " + key + " = " + properties.getProperty(key));
            }
            System.out.println("Custom Settings:");
            for (Map.Entry<String, String> entry : customSettings.entrySet()) {
                System.out.println("  " + entry.getKey() + " = " + entry.getValue());
            }
        }
    }
    
    /**
     * Properties dosyasından konfigürasyon okuma
     */
    public static TestConfig loadPropertiesConfig(String filePath) {
        TestConfig config = new TestConfig();
        
        try (InputStream input = Files.newInputStream(Paths.get(filePath))) {
            config.properties.load(input);
            System.out.println("Properties dosyası yüklendi: " + filePath);
        } catch (IOException e) {
            System.err.println("Properties dosyası okuma hatası: " + e.getMessage());
        }
        
        return config;
    }
    
    /**
     * Basit JSON dosyasından konfigürasyon okuma
     */
    public static TestConfig loadJsonConfig(String filePath) {
        TestConfig config = new TestConfig();
        
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("\"") && line.contains(":")) {
                    // Basit JSON parsing
                    String[] parts = line.split(":", 2);
                    if (parts.length == 2) {
                        String key = parts[0].replace("\"", "").trim();
                        String value = parts[1].replace("\"", "").replace(",", "").trim();
                        config.setCustomSetting(key, value);
                    }
                }
            }
            System.out.println("JSON dosyası yüklendi: " + filePath);
        } catch (IOException e) {
            System.err.println("JSON dosyası okuma hatası: " + e.getMessage());
        }
        
        return config;
    }
    
    /**
     * Environment-specific konfigürasyon yükleme
     */
    public static TestConfig loadEnvironmentConfig(String environment) {
        TestConfig config = new TestConfig();
        
        // Environment-specific properties dosyası
        String envPropertiesFile = ENV_CONFIG_DIR + "/" + environment + ".properties";
        if (Files.exists(Paths.get(envPropertiesFile))) {
            TestConfig envConfig = loadPropertiesConfig(envPropertiesFile);
            // Environment ayarlarını ana konfigürasyona ekle
            for (String key : envConfig.properties.stringPropertyNames()) {
                config.setProperty(key, envConfig.getProperty(key));
            }
        }
        
        // Environment-specific JSON dosyası
        String envJsonFile = ENV_CONFIG_DIR + "/" + environment + ".json";
        if (Files.exists(Paths.get(envJsonFile))) {
            TestConfig envConfig = loadJsonConfig(envJsonFile);
            // Environment ayarlarını ana konfigürasyona ekle
            for (Map.Entry<String, String> entry : envConfig.customSettings.entrySet()) {
                config.setCustomSetting(entry.getKey(), entry.getValue());
            }
        }
        
        return config;
    }
    
    /**
     * Konfigürasyon dosyalarını oluşturma
     */
    public static void createSampleConfigFiles() {
        try {
            // Konfigürasyon klasörlerini oluştur
            Files.createDirectories(Paths.get(CONFIG_DIR));
            Files.createDirectories(Paths.get(ENV_CONFIG_DIR));
            
            // Ana test konfigürasyonu (properties)
            String mainConfig = "# Test Otomasyonu Ana Konfigürasyonu\n" +
                               "browser=chrome\n" +
                               "implicit.wait=10\n" +
                               "explicit.wait=20\n" +
                               "page.load.timeout=30\n" +
                               "screenshot.on.failure=true\n" +
                               "retry.count=3\n" +
                               "parallel.execution=false\n" +
                               "headless.mode=false\n" +
                               "test.data.path=testdata/\n" +
                               "report.path=reports/\n" +
                               "log.level=INFO";
            
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CONFIG_DIR + "/test-config.properties"))) {
                writer.write(mainConfig);
                System.out.println("Ana konfigürasyon dosyası oluşturuldu: test-config.properties");
            }
            
            // Test verisi konfigürasyonu (JSON)
            String testDataConfig = "{\n" +
                                   "  \"baseUrl\": \"https://example.com\",\n" +
                                   "  \"apiUrl\": \"https://api.example.com\",\n" +
                                   "  \"databaseUrl\": \"jdbc:mysql://localhost:3306/testdb\",\n" +
                                   "  \"username\": \"testuser\",\n" +
                                   "  \"password\": \"testpass\",\n" +
                                   "  \"email\": \"test@example.com\",\n" +
                                   "  \"phone\": \"+905551234567\"\n" +
                                   "}";
            
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CONFIG_DIR + "/test-data.json"))) {
                writer.write(testDataConfig);
                System.out.println("Test verisi konfigürasyonu oluşturuldu: test-data.json");
            }
            
            // Development ortamı konfigürasyonu
            String devConfig = "# Development Ortamı Konfigürasyonu\n" +
                              "browser=chrome\n" +
                              "base.url=http://localhost:8080\n" +
                              "api.url=http://localhost:3000\n" +
                              "database.url=jdbc:mysql://localhost:3306/devdb\n" +
                              "headless.mode=false\n" +
                              "log.level=DEBUG";
            
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ENV_CONFIG_DIR + "/development.properties"))) {
                writer.write(devConfig);
                System.out.println("Development konfigürasyonu oluşturuldu: development.properties");
            }
            
            // Production ortamı konfigürasyonu
            String prodConfig = "# Production Ortamı Konfigürasyonu\n" +
                               "browser=chrome\n" +
                               "base.url=https://production.example.com\n" +
                               "api.url=https://api.production.example.com\n" +
                               "database.url=jdbc:mysql://prod-server:3306/proddb\n" +
                               "headless.mode=true\n" +
                               "log.level=WARN";
            
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ENV_CONFIG_DIR + "/production.properties"))) {
                writer.write(prodConfig);
                System.out.println("Production konfigürasyonu oluşturuldu: production.properties");
            }
            
            // Test ortamı konfigürasyonu
            String testConfig = "# Test Ortamı Konfigürasyonu\n" +
                               "browser=firefox\n" +
                               "base.url=https://test.example.com\n" +
                               "api.url=https://api.test.example.com\n" +
                               "database.url=jdbc:mysql://test-server:3306/testdb\n" +
                               "headless.mode=true\n" +
                               "log.level=INFO";
            
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(ENV_CONFIG_DIR + "/test.properties"))) {
                writer.write(testConfig);
                System.out.println("Test ortamı konfigürasyonu oluşturuldu: test.properties");
            }
            
        } catch (IOException e) {
            System.err.println("Konfigürasyon dosyaları oluşturma hatası: " + e.getMessage());
        }
    }
    
    /**
     * Konfigürasyon doğrulama
     */
    public static boolean validateConfig(TestConfig config) {
        List<String> requiredProperties = Arrays.asList(
            "browser", "base.url", "implicit.wait", "explicit.wait"
        );
        
        List<String> missingProperties = new ArrayList<>();
        
        for (String required : requiredProperties) {
            if (config.getProperty(required) == null) {
                missingProperties.add(required);
            }
        }
        
        if (!missingProperties.isEmpty()) {
            System.err.println("Eksik konfigürasyon özellikleri: " + missingProperties);
            return false;
        }
        
        // Browser değerini kontrol et
        String browser = config.getProperty("browser").toLowerCase();
        if (!Arrays.asList("chrome", "firefox", "edge", "safari").contains(browser)) {
            System.err.println("Geçersiz browser değeri: " + browser);
            return false;
        }
        
        // Timeout değerlerini kontrol et
        try {
            int implicitWait = Integer.parseInt(config.getProperty("implicit.wait"));
            int explicitWait = Integer.parseInt(config.getProperty("explicit.wait"));
            
            if (implicitWait <= 0 || explicitWait <= 0) {
                System.err.println("Timeout değerleri pozitif olmalıdır");
                return false;
            }
            
        } catch (NumberFormatException e) {
            System.err.println("Timeout değerleri sayısal olmalıdır");
            return false;
        }
        
        System.out.println("Konfigürasyon doğrulaması başarılı");
        return true;
    }
    
    /**
     * Konfigürasyon karşılaştırma
     */
    public static void compareConfigurations(String env1, String env2) {
        System.out.println("\n=== Konfigürasyon Karşılaştırması: " + env1 + " vs " + env2 + " ===");
        
        TestConfig config1 = loadEnvironmentConfig(env1);
        TestConfig config2 = loadEnvironmentConfig(env2);
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(config1.properties.stringPropertyNames());
        allKeys.addAll(config2.properties.stringPropertyNames());
        
        for (String key : allKeys) {
            String value1 = config1.getProperty(key);
            String value2 = config2.getProperty(key);
            
            if (value1 == null) {
                System.out.println(key + ": " + env1 + " (YOK) vs " + env2 + " (" + value2 + ")");
            } else if (value2 == null) {
                System.out.println(key + ": " + env1 + " (" + value1 + ") vs " + env2 + " (YOK)");
            } else if (!value1.equals(value2)) {
                System.out.println(key + ": " + env1 + " (" + value1 + ") vs " + env2 + " (" + value2 + ") [FARKLI]");
            } else {
                System.out.println(key + ": " + env1 + " (" + value1 + ") vs " + env2 + " (" + value2 + ") [Aynı]");
            }
        }
    }
    
    /**
     * Örnek test senaryosu: Konfigürasyon tabanlı test
     */
    public static void runConfigurationBasedTest(String environment) {
        System.out.println("\n=== Konfigürasyon Tabanlı Test: " + environment + " ===");
        
        // 1. Environment konfigürasyonunu yükle
        TestConfig envConfig = loadEnvironmentConfig(environment);
        
        // 2. Ana konfigürasyonu yükle
        TestConfig mainConfig = loadPropertiesConfig(CONFIG_DIR + "/test-config.properties");
        
        // 3. Test verisi konfigürasyonunu yükle
        TestConfig dataConfig = loadJsonConfig(CONFIG_DIR + "/test-data.json");
        
        // 4. Konfigürasyonları birleştir
        TestConfig finalConfig = new TestConfig();
        
        // Ana konfigürasyonu ekle
        for (String key : mainConfig.properties.stringPropertyNames()) {
            finalConfig.setProperty(key, mainConfig.getProperty(key));
        }
        
        // Environment konfigürasyonunu ekle (override)
        for (String key : envConfig.properties.stringPropertyNames()) {
            finalConfig.setProperty(key, envConfig.getProperty(key));
        }
        
        // Test verisi konfigürasyonunu ekle
        for (Map.Entry<String, String> entry : dataConfig.customSettings.entrySet()) {
            finalConfig.setCustomSetting(entry.getKey(), entry.getValue());
        }
        
        // 5. Konfigürasyonu doğrula
        if (!validateConfig(finalConfig)) {
            System.err.println("Konfigürasyon doğrulaması başarısız!");
            return;
        }
        
        // 6. Konfigürasyonu göster
        finalConfig.printConfig();
        
        // 7. Test senaryosunu simüle et
        simulateTestWithConfig(finalConfig);
    }
    
    /**
     * Konfigürasyon ile test simülasyonu
     */
    private static void simulateTestWithConfig(TestConfig config) {
        System.out.println("\n=== Test Simülasyonu ===");
        
        String browser = config.getProperty("browser");
        String baseUrl = config.getProperty("base.url");
        int implicitWait = Integer.parseInt(config.getProperty("implicit.wait"));
        boolean headlessMode = Boolean.parseBoolean(config.getProperty("headless.mode"));
        
        System.out.println("Browser: " + browser);
        System.out.println("Base URL: " + baseUrl);
        System.out.println("Implicit Wait: " + implicitWait + " saniye");
        System.out.println("Headless Mode: " + headlessMode);
        
        // Simüle edilmiş test adımları
        try {
            System.out.println("1. Browser başlatılıyor: " + browser);
            Thread.sleep(1000);
            
            System.out.println("2. Sayfa açılıyor: " + baseUrl);
            Thread.sleep(800);
            
            System.out.println("3. Implicit wait uygulanıyor: " + implicitWait + " saniye");
            Thread.sleep(implicitWait * 100);
            
            System.out.println("4. Test adımları çalıştırılıyor...");
            Thread.sleep(1200);
            
            System.out.println("5. Test tamamlandı");
            
        } catch (InterruptedException e) {
            System.err.println("Test simülasyonu kesintiye uğradı: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Konfigürasyon Dosyası Yönetimi Örneği ===\n");
        
        // Örnek konfigürasyon dosyalarını oluştur
        createSampleConfigFiles();
        
        // Farklı ortamlar için test çalıştır
        runConfigurationBasedTest("development");
        runConfigurationBasedTest("test");
        runConfigurationBasedTest("production");
        
        // Konfigürasyon karşılaştırması
        compareConfigurations("development", "production");
        
        System.out.println("\n=== Konfigürasyon Yönetimi Tamamlandı ===");
    }
} 