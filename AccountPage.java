package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    public WebDriver driver;
    WebDriverWait wait;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By Heading=By.className("account-heading");
    public String getHeading() {
        return driver.findElement(Heading).getText();
    }
    By userheading=By.className("membership-username");
    public String getUserNameElement() {
        return driver.findElement(userheading).getText();
    }
    By paswordheading=By.className("membership-password");
    public String getPasswordElement() {
        return driver.findElement(paswordheading).getText();
    }
    By planpara=By.className("plan-paragraph");

    public String getplanElement() {
        return driver.findElement(planpara).getText();
    }
    By heading=By.className("membership-heading");

    public String getHeadingElement() {
        return driver.findElement(heading).getText();
    }

    By plandetails=By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/p");

    public String getplanDetails() {
        return driver.findElement(plandetails).getText();
    }

    By ultra=By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div/p[2]");
    public String getultraDetails() {
        return driver.findElement(ultra).getText();
    }



    public WebElement getLogoutButton() {
        return driver.findElement(By.className("logout-button"));
    }
    public void clickButton1() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
        button.click();
    }
}
