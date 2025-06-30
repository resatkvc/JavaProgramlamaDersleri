package JavaDersleri.D10_SeleniumWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By aramaKutusu = By.id("search"); // Magento demo sitesinde arama kutusunun id'si 'search'
    By aramaButonu = By.cssSelector("button.action.search"); // Arama butonu

    public void urunAra(String urun) {
        WebElement kutu = driver.findElement(aramaKutusu);
        kutu.clear();
        kutu.sendKeys(urun);
        driver.findElement(aramaButonu).click();
    }
} 