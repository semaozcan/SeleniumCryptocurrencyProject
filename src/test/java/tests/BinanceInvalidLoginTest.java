package tests;

import constants.ErrorMessages;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BinanceHomePage;
import pages.BinanceLoginPage;

public class BinanceInvalidLoginTest extends BaseTest {
    private BinanceHomePage homePage;
    String INVALID_USERNAME = "semaozcan20@gmail.com";

    @BeforeTest
    void setUp() throws InterruptedException {
        super.setUp();
        homePage = new BinanceHomePage(driver, wait);
        homePage.open();
        homePage.rejectCookies();
    }

    @Test
    void testInvalidLogin() {
        BinanceLoginPage loginPage;
        loginPage = homePage.navigateToLoginPage();
        loginPage.loginWithCredentials(INVALID_USERNAME);

        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, ErrorMessages.ERROR_MESSAGES.ACCOUNT_NOT_FOUND.getMessage(),
                ErrorMessages.ERROR_MESSAGES.ERROR_MESSAGE_NOT_VERIFIED.getMessage());
    }
}
