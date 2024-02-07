package tests;

import constants.ErrorMessages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BinanceHomePage;

import java.util.List;
import java.util.Random;

public class BinanceRandomLinksTest extends BaseTest{
    private BinanceHomePage homePage;

    @BeforeTest
    void setUp() throws InterruptedException {
        super.setUp();
        homePage = new BinanceHomePage(driver, wait);
        homePage.open();
        homePage.rejectCookies();
    }

    @Test
    public void testRandomLinks() {
        List<WebElement> links = homePage.getAboutSectionLinks();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(links.size());
            WebElement randomLink = links.get(randomIndex);
            String expectedUrl = randomLink.getAttribute("href");
            String linkText = randomLink.getText();

            homePage.openLinkInNewTab(randomLink);
            homePage.switchToNewTab();

            String actualUrl = driver.getCurrentUrl();
            System.out.println(
                    "Tıklanan Link: " + linkText + " | Beklenen URL: " + expectedUrl + " | Gerçek URL: " + actualUrl
            );

            Assert.assertEquals(actualUrl, expectedUrl, ErrorMessages.ERROR_MESSAGES.URL_NOT_VERIFIED.getMessage());

            homePage.closeCurrentTab();
            homePage.switchToFirstTab();
        }
    }
}
