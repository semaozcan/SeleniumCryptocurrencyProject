package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BinanceAvaxPage;
import pages.BinanceHomePage;
import pages.BinanceMarketsPage;

import static org.testng.AssertJUnit.assertEquals;

public class BinanceAvaxTest extends BaseTest{

    private BinanceHomePage homePage;

    @BeforeTest
    void setUp() throws InterruptedException {
        super.setUp();
        homePage = new BinanceHomePage(driver, wait);
        homePage.open();
        homePage.rejectCookies();
    }

    @Test
    void binanceAvaxTest() throws InterruptedException {
        BinanceMarketsPage marketsPage;
        marketsPage = homePage.navigateToSpotAndMarginMarkets();
        BinanceAvaxPage avaxPage = marketsPage.clickOnAvax();
        String actualUrl = avaxPage.getCurrentUrl();
        assertEquals("https://www.binance.com/tr/trade/AVAX_USDT?_from=markets&type=spot", actualUrl);
    }
}
