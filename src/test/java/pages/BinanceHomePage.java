package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import static constants.GlobalVariables.BASE_URL;

public class BinanceHomePage {
    private final WebDriver driver;
    private WebDriverWait wait;

    private final By cookiesRejectButton = By.cssSelector("#onetrust-reject-all-handler");
    private final By marketsTab = By.cssSelector("#ba-tableMarkets");
    private final By spotMarginMarketsLink = By.cssSelector("a[href='/tr/markets/spot_margin']");
    private final By spotMenuButton = By.cssSelector("#ba-trade");
    private final By toLoginButton = By.cssSelector("#toLoginPage");
    private final By aboutSectionLinks = By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > footer:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(2) > li > a");
    private String firstTabHandle;

    public BinanceHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void rejectCookies() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(cookiesRejectButton).click();
    }

    public BinanceMarketsPage navigateToSpotAndMarginMarkets() {
        driver.findElement(marketsTab).click();
        driver.findElement(spotMarginMarketsLink).click();

        return new BinanceMarketsPage(driver, wait);
    }

    public BinanceLoginPage navigateToLoginPage() {
        WebElement spotMenuElement;
        spotMenuElement = wait.until(ExpectedConditions.elementToBeClickable(spotMenuButton));
        spotMenuElement.click();
        WebElement loginButton = driver.findElement(toLoginButton);
        loginButton.click();

        return new BinanceLoginPage(driver, wait);
    }

    public List<WebElement> getAboutSectionLinks() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(aboutSectionLinks));
    }

    public void openLinkInNewTab(WebElement link) {
        firstTabHandle = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", link.getAttribute("href"));
    }

    public void switchToNewTab() {
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(firstTabHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public void switchToFirstTab() {
        driver.switchTo().window(firstTabHandle);
    }
}
