package JavaDersleri.D12_TestRaporlamaVeLoglama;

import JavaDersleri.D10_SeleniumWebDriver.HomePage;
import JavaDersleri.D10_SeleniumWebDriver.ResultsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * D12: Test Raporlama ve Loglama
 * - JUnit ile test
 * - ExtentReports ile gelişmiş HTML raporlama
 * - Log4j ile detaylı loglama
 * - Hatalı durumda ekran görüntüsü alma
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitExtentLog4jTest {
    WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;
    static ExtentReports extent;
    ExtentTest test;
    static final Logger logger = LogManager.getLogger(JUnitExtentLog4jTest.class);

    @BeforeAll
    void setupReport() {
        // ExtentReports kurulumu (SparkReporter ile)
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("D12_ExtentReport.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("D12 Test Raporu");
        sparkReporter.config().setReportName("JUnit + ExtentReports + Log4j");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        logger.info("ExtentReports başlatıldı.");
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        logger.info("Tarayıcı başlatıldı ve siteye gidildi.");
    }

    @Test
    void aramaSonucuGorunuyorMu() {
        String urun = "jacket";
        test = extent.createTest("Arama Sonucu Görünüyor mu? - " + urun);
        logger.info("Arama testi başlatıldı: {}", urun);
        try {
            homePage.urunAra(urun);
            logger.info("{} için arama yapıldı.", urun);
            Thread.sleep(2000);
            boolean sonuc = resultsPage.sonucGorunuyorMu();
            assertTrue(sonuc, "Arama sonuçları görüntülenemedi!");
            test.pass("Arama sonuçları başarıyla görüntülendi.");
            logger.info("Arama sonuçları başarıyla görüntülendi.");
        } catch (Exception e) {
            String screenshotPath = ekranGoruntusuAl("arama_fail");
            test.fail("Test başarısız oldu. Hata: " + e.getMessage())
                .addScreenCaptureFromPath(screenshotPath);
            logger.error("Test başarısız oldu.", e);
            fail(e);
        }
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Tarayıcı kapatıldı.");
        }
        if (extent != null) {
            extent.flush();
            logger.info("ExtentReports kaydedildi.");
        }
    }

    // Hatalı durumda ekran görüntüsü alma metodu
    String ekranGoruntusuAl(String name) {
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "screenshots/" + name + "_" + time + ".png";
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.createDirectories(Paths.get("screenshots"));
            Files.copy(src.toPath(), Paths.get(path));
            logger.info("Ekran görüntüsü alındı: {}", path);
        } catch (IOException e) {
            logger.error("Ekran görüntüsü alınamadı!", e);
        }
        return path;
    }
} 