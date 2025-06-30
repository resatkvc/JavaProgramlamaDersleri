package JavaDersleri.D10_SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage {
    WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Magento demo sitesinde ürün sonuçları 'ol.product-items' class'ı ile listeleniyor
    By urunListesi = By.cssSelector("ol.products.list.items.product-items");

    public boolean sonucGorunuyorMu() {
        return driver.findElements(urunListesi).size() > 0;
    }
} 