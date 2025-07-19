package JavaDersleri.D13_JavaFileIOAndTestAutomation;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Test Data File Operations
 * ------------------------
 * Test otomasyonunda dosya işlemleri:
 * - CSV dosyasından test verilerini okuma
 * - Test sonuçlarını JSON formatında dosyaya yazma
 * - Test raporlarını HTML formatında oluşturma
 * 
 * Gerçek projede kullanım:
 * - Test verilerini merkezi dosyalardan okuma
 * - Test sonuçlarını raporlama için kaydetme
 * - Test raporlarını otomatik oluşturma
 */
public class C1_TestDataFileOperations {
    
    // Test verisi için basit bir sınıf
    static class TestData {
        String testName;
        String username;
        String password;
        String expectedResult;
        
        public TestData(String testName, String username, String password, String expectedResult) {
            this.testName = testName;
            this.username = username;
            this.password = password;
            this.expectedResult = expectedResult;
        }
        
        @Override
        public String toString() {
            return "TestData{testName='" + testName + "', username='" + username + 
                   "', password='" + password + "', expectedResult='" + expectedResult + "'}";
        }
    }
    
    // Test sonucu için basit bir sınıf
    static class TestResult {
        String testName;
        String status;
        String actualResult;
        String timestamp;
        
        public TestResult(String testName, String status, String actualResult) {
            this.testName = testName;
            this.status = status;
            this.actualResult = actualResult;
            this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
    
    /**
     * CSV dosyasından test verilerini okuma
     */
    public static List<TestData> readTestDataFromCSV(String filePath) {
        List<TestData> testDataList = new ArrayList<>();
        
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean firstLine = true;
            
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false; // Başlık satırını atla
                    continue;
                }
                
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    TestData testData = new TestData(
                        parts[0].trim(), // testName
                        parts[1].trim(), // username
                        parts[2].trim(), // password
                        parts[3].trim()  // expectedResult
                    );
                    testDataList.add(testData);
                }
            }
        } catch (IOException e) {
            System.err.println("CSV dosyası okuma hatası: " + e.getMessage());
        }
        
        return testDataList;
    }
    
    /**
     * Test sonuçlarını JSON formatında dosyaya yazma
     */
    public static void writeTestResultsToJSON(List<TestResult> results, String filePath) {
        StringBuilder json = new StringBuilder();
        json.append("{\n");
        json.append("  \"testResults\": [\n");
        
        for (int i = 0; i < results.size(); i++) {
            TestResult result = results.get(i);
            json.append("    {\n");
            json.append("      \"testName\": \"").append(result.testName).append("\",\n");
            json.append("      \"status\": \"").append(result.status).append("\",\n");
            json.append("      \"actualResult\": \"").append(result.actualResult).append("\",\n");
            json.append("      \"timestamp\": \"").append(result.timestamp).append("\"\n");
            json.append("    }");
            
            if (i < results.size() - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        
        json.append("  ]\n");
        json.append("}\n");
        
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(json.toString());
            System.out.println("Test sonuçları JSON dosyasına yazıldı: " + filePath);
        } catch (IOException e) {
            System.err.println("JSON dosyası yazma hatası: " + e.getMessage());
        }
    }
    
    /**
     * Test raporunu HTML formatında oluşturma
     */
    public static void generateHTMLReport(List<TestResult> results, String filePath) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("    <title>Test Raporu</title>\n");
        html.append("    <style>\n");
        html.append("        body { font-family: Arial, sans-serif; margin: 20px; }\n");
        html.append("        table { border-collapse: collapse; width: 100%; }\n");
        html.append("        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }\n");
        html.append("        th { background-color: #f2f2f2; }\n");
        html.append("        .pass { background-color: #d4edda; }\n");
        html.append("        .fail { background-color: #f8d7da; }\n");
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("    <h1>Test Raporu</h1>\n");
        html.append("    <p>Oluşturulma Tarihi: ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("</p>\n");
        html.append("    <table>\n");
        html.append("        <tr>\n");
        html.append("            <th>Test Adı</th>\n");
        html.append("            <th>Durum</th>\n");
        html.append("            <th>Sonuç</th>\n");
        html.append("            <th>Zaman</th>\n");
        html.append("        </tr>\n");
        
        for (TestResult result : results) {
            String rowClass = result.status.equals("PASS") ? "pass" : "fail";
            html.append("        <tr class=\"").append(rowClass).append("\">\n");
            html.append("            <td>").append(result.testName).append("</td>\n");
            html.append("            <td>").append(result.status).append("</td>\n");
            html.append("            <td>").append(result.actualResult).append("</td>\n");
            html.append("            <td>").append(result.timestamp).append("</td>\n");
            html.append("        </tr>\n");
        }
        
        html.append("    </table>\n");
        html.append("</body>\n");
        html.append("</html>");
        
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write(html.toString());
            System.out.println("HTML raporu oluşturuldu: " + filePath);
        } catch (IOException e) {
            System.err.println("HTML dosyası yazma hatası: " + e.getMessage());
        }
    }
    
    /**
     * Örnek test senaryosu: E-ticaret login testi
     */
    public static void runLoginTests() {
        System.out.println("=== E-ticaret Login Test Otomasyonu ===\n");
        
        // 1. Test verilerini CSV dosyasından oku
        List<TestData> testDataList = readTestDataFromCSV("testdata.csv");
        System.out.println("CSV'den okunan test verileri:");
        for (TestData data : testDataList) {
            System.out.println(data);
        }
        System.out.println();
        
        // 2. Testleri çalıştır ve sonuçları topla
        List<TestResult> testResults = new ArrayList<>();
        
        for (TestData testData : testDataList) {
            System.out.println("Test çalıştırılıyor: " + testData.testName);
            
            // Simüle edilmiş test çalıştırma
            String actualResult = simulateLoginTest(testData.username, testData.password);
            String status = actualResult.equals(testData.expectedResult) ? "PASS" : "FAIL";
            
            TestResult result = new TestResult(testData.testName, status, actualResult);
            testResults.add(result);
            
            System.out.println("Sonuç: " + status + " - " + actualResult);
            System.out.println();
        }
        
        // 3. Test sonuçlarını JSON dosyasına yaz
        writeTestResultsToJSON(testResults, "test-results.json");
        
        // 4. HTML raporu oluştur
        generateHTMLReport(testResults, "test-report.html");
        
        // 5. Özet rapor
        long passCount = testResults.stream().filter(r -> r.status.equals("PASS")).count();
        long failCount = testResults.stream().filter(r -> r.status.equals("FAIL")).count();
        
        System.out.println("=== Test Özeti ===");
        System.out.println("Toplam Test: " + testResults.size());
        System.out.println("Başarılı: " + passCount);
        System.out.println("Başarısız: " + failCount);
        System.out.println("Başarı Oranı: %" + (passCount * 100 / testResults.size()));
    }
    
    /**
     * Simüle edilmiş login testi
     */
    private static String simulateLoginTest(String username, String password) {
        // Gerçek test otomasyonunda burada Selenium veya başka bir test framework kullanılır
        if (username.equals("admin") && password.equals("123456")) {
            return "Login successful";
        } else if (username.equals("user") && password.equals("password")) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }
    
    /**
     * Örnek CSV dosyası oluşturma
     */
    public static void createSampleCSV() {
        String csvContent = "TestName,Username,Password,ExpectedResult\n" +
                           "Valid Admin Login,admin,123456,Login successful\n" +
                           "Valid User Login,user,password,Login successful\n" +
                           "Invalid Login,wrong,wrong,Login failed\n" +
                           "Empty Credentials,,,Login failed";
        
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("testdata.csv"))) {
            writer.write(csvContent);
            System.out.println("Örnek CSV dosyası oluşturuldu: testdata.csv");
        } catch (IOException e) {
            System.err.println("CSV dosyası oluşturma hatası: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        // Örnek CSV dosyası oluştur
        createSampleCSV();
        
        // Test otomasyonunu çalıştır
        runLoginTests();
    }
} 