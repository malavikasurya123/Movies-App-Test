package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By logoImage = By.className("login-website-logo");
    By loginHeading = By.className("sign-in-heading");
    By usernameLabel = By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[1]/label");
    By passwordLabel = By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[2]/label");
    By loginButton = By.className("login-button");
    By errorMessage = By.className("error-message");

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return driver.findElement(errorMessage).getText();
    }

    public WebElement isLogoImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoImage));
        return driver.findElement(logoImage);
    }

    public String getHeading() {
        WebElement loginHeadingEl = driver.findElement(loginHeading);
        return loginHeadingEl.getText();
    }

    public String getUsernameLabelText() {
        return driver.findElement(usernameLabel).getText();
    }

    public String getPasswordLabelText() {
        return driver.findElement(passwordLabel).getText();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }

    @FindBy(id = "usernameInput")
    WebElement usernameInputElement;

    @FindBy(id = "passwordInput")
    WebElement passwordInputElement;

    @FindBy(className = "login-button")
    WebElement loginButtonElement;

    public void enterUsername(String username) {
        usernameInputElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInputElement.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButtonElement.click();
    }

    public void loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnLoginButton();
    }
}
