package tests;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static utilities.GenerateMarketSummaryFileName.generateMarketSummaryFileName;

public class BinanceGetDataToExcelTest {
    /*
    TODO: This task is not yet complete, it is in-progress, but I wanted to show the flow in general.
     */
    private WebDriver driver;
    private WebDriverWait wait;
    private Workbook workbook;
    private Sheet sheet;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Market Summary");
    }

    @Test
    public void testMarketSummary() {
        driver.get("https://www.binance.com/tr");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("#onetrust-reject-all-handler")).click();

        WebElement marketSummaryMenuItem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Piyasalar']")));
        marketSummaryMenuItem.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/tr/markets/coinInfo']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/tr/markets/coinInfo-']"))).click();

        for (int page = 1; page <= 3; page++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".css-fm5ed6")));

            List<WebElement> coinRows = driver.findElements(By.cssSelector(".css-1tfmum1"));

            for (WebElement coinRow : coinRows) {
                WebElement coinNameElement;
                coinNameElement = coinRow.findElement(By.xpath("(//div[@class='css-1y4fqhd'])[2]"));
                String coinName = coinNameElement.getText();

                WebElement priceChangeElement;
                priceChangeElement = coinRow.findElement(By.xpath("//div[contains(@class, 'css-vlibs4')]//div[contains(@class, 'css-1ydqfmf')]/div[2]"));
                String priceChange = priceChangeElement.getText();

                WebElement volumeElement;
                volumeElement = coinRow.findElement(By.xpath("//div[contains(@class, 'css-vlibs4')]//div[contains(@class, 'css-18yakpxx')][1]"));
                String volume = volumeElement.getText();

                int rowNumber = sheet.getLastRowNum() + 1;
                Row row = sheet.createRow(rowNumber);
                row.createCell(0).setCellValue(coinName);
                row.createCell(1).setCellValue(priceChange);
                row.createCell(2).setCellValue(volume);
            }

            if (page < 3) {
                WebElement nextPageButton = driver.findElement(By.xpath("(//*[name()='svg'][@class='css-3kwgah'])[3]"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextPageButton);
            }
        }
    }

    @AfterMethod
    public void tearDown() throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(generateMarketSummaryFileName())) {
            workbook.write(fileOut);
        }
        workbook.close();
        driver.quit();
    }
}
