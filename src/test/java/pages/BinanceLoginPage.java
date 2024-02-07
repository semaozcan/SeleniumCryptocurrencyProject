package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BinanceLoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailInputField = By.cssSelector("#username");
    private final By loginNextButton = By.cssSelector("#click_login_submit_v2");
    private final By errorMessage = By.cssSelector(".help_error.css-z72qxo");

    public BinanceLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loginWithCredentials(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailInputField));
        emailInput.sendKeys(email);
        WebElement loginSubmit = driver.findElement(loginNextButton);
        loginSubmit.click();
    }

    public String getErrorMessage() {
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));

        return errorElement.getText();
    }
}
