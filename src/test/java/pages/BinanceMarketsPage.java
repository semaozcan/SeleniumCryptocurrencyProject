package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BinanceMarketsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BinanceMarketsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public BinanceAvaxPage clickOnAvax() throws InterruptedException {
        String originalWindow = driver.getWindowHandle();

        WebElement avaxElement = driver.findElement(By.xpath("//div[normalize-space()='AVAX']"));

        avaxElement.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Thread.sleep(5000);

        return new BinanceAvaxPage(driver, wait);
    }
}
