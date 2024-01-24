package stepdefinitions;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
public class AccountPageSteps {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public LoginPage login;
    public HomePage home;
    public PopularPage popularPage;
    public SearchPage searchPage;
    public AccountPage accountPage;

    @Given("User is in Account page")
    public void navigates_to_Account_page() {

        driver.get("https://qamoviesapp.ccbp.tech");

        login = new LoginPage(driver);
        home = new HomePage(driver);
        accountPage = new AccountPage(driver);

        login.loginToApplication("rahul", "rahul@2021");

        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");

        WebElement accountEl = home.getAvatarImgEl();
        accountEl.click();

        String expUrl2 = "https://qamoviesapp.ccbp.tech/account";

        Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Account page URL is not matching..");
    }




    @When("Test all the UI elements present on the web page")
    public void TestalltheUIelementspresentonthewebpage() {
        //accountPage.clickButton1();
        String actual = accountPage.getHeading();
        Assert.assertEquals(actual, "Account", "heading does not match");
        String actual1 = accountPage.getUserNameElement();
        Assert.assertEquals(actual1, "User name : rahul", "heading does not match");
        String actual2 = accountPage.getPasswordElement();
        Assert.assertEquals(actual2, "Password : **********", "heading does not match");


        String actual3 = accountPage.getHeadingElement();
        Assert.assertEquals(actual3, "Member ship", "heading does not match");
        String actual5 = accountPage.getplanDetails();
        Assert.assertEquals(actual5, "Plan details");
        String actual4 = accountPage.getplanElement();
        Assert.assertEquals(actual4, "Premium");
        String actual6 = accountPage.getultraDetails();
        Assert.assertEquals(actual6, "Ultra HD");

    }
@Then("Test the Logout functionality")
    public void TesttheLogoutfunctionality(){
    WebElement logoutBtnEl = accountPage.getLogoutButton();
    logoutBtnEl.click();
    String expUrl = "https://qamoviesapp.ccbp.tech/login";
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(expUrl));
    Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URLs are not matching..");
}

}
