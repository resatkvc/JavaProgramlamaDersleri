package JavaDersleri.D11_UnitTestOtomasyon;

import JavaDersleri.D10_SeleniumWebDriver.HomePage;
import JavaDersleri.D10_SeleniumWebDriver.ResultsPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * D11: JUnit ile Test Otomasyon
 * --------------------------------------
 * Bu sınıf, JUnit ile test otomasyonunun temel başlıklarını profesyonel ve açıklamalı şekilde gösterir:
 * - JUnit ile test yazımı
 * - Assertion'lar ile doğrulama
 * - Test lifecycle (Before/After metotları)
 * - Parametrik test örneği
 * Magento demo sitesi üzerinde gerçek örneklerle uygulanmıştır.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitIleTestOtomasyon {
    WebDriver driver;
    HomePage homePage;
    ResultsPage resultsPage;

    @BeforeAll
    void setupClass() {
        // Tüm testlerden önce bir kez çalışır
        System.out.println("Test sınıfı başlatılıyor...");
    }

    @BeforeEach
    void setup() {
        // Her testten önce çalışır
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @Test
    void aramaSonucuGorunuyorMu() {
        // Temel arama testi
        homePage.urunAra("jacket");
        // Sonuçların yüklenmesi için kısa bir bekleme
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        assertTrue(resultsPage.sonucGorunuyorMu(), "Arama sonuçları görüntülenemedi!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"jacket", "bag", "pants"})
    void farkliUrunlerIcinAramaTesti(String urun) {
        // Parametrik test: Farklı ürünler için arama
        homePage.urunAra(urun);
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
        assertTrue(resultsPage.sonucGorunuyorMu(), urun + " araması başarısız!");
    }

    @AfterEach
    void tearDown() {
        // Her testten sonra çalışır
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    void tearDownClass() {
        // Tüm testlerden sonra bir kez çalışır
        System.out.println("Test sınıfı tamamlandı.");
    }
} 