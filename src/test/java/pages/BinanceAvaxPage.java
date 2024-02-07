package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BinanceAvaxPage {
    private final WebDriver driver;

    public BinanceAvaxPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
