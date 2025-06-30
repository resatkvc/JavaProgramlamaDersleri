package JavaDersleri.D10_SeleniumWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AramaTestiMain {
    public static void main(String[] args) {
        // ChromeDriver'ın path'i sistemde tanımlı olmalı!
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://magento.softwaretestingboard.com/"); // Magento demo sitesi
            HomePage homePage = new HomePage(driver);
            ResultsPage resultsPage = new ResultsPage(driver);

            homePage.urunAra("jacket"); // Örnek ürün araması

            // Sonuçların yüklenmesi için kısa bir bekleme
            Thread.sleep(2000);

            if (resultsPage.sonucGorunuyorMu()) {
                System.out.println("Test Başarılı: Sonuçlar görüntülendi!");
            } else {
                System.out.println("Test Başarısız: Sonuçlar görüntülenemedi!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Sonucu gözlemlemek için 3 saniye bekle, sonra kapat
            try { Thread.sleep(3000); } catch (InterruptedException ignored) {}
            driver.quit();
        }
    }
} 