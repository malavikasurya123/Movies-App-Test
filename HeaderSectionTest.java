package stepdefinitions;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.testng.Assert;
import java.time.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class HeaderSection  {
    WebDriver driver = Hooks.getDriver();
    public WebDriverWait wait;
    HomePage home;
    LoginPage login;
    @Given("User is in Homepage")
    public void User_is_in_Homepage() {
        login = new LoginPage(driver);
        home= new HomePage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
        login.loginToApplication("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL do not matching..");

    }
    @When("User is testing HeaderSectionUi elements")
    public void user_is_testing_header_section_ui_elements() {
        WebElement moviesLogoEl = home.getMoviesLogoEl();
        String homeText = home.getHomeText();
        String popularText = home.getPopularText();
        WebElement avatarImgEl = home.getAvatarImgEl();

        String expHomeText = "Home";
        String expPopularText = "Popular";

        Assert.assertEquals(homeText, expHomeText, "Home Text is not matching..");
        Assert.assertEquals(popularText, expPopularText, "Popular Text is not matching..");
        Assert.assertTrue(moviesLogoEl.isDisplayed(), "Movies Logo is not displayed..");
        Assert.assertTrue(avatarImgEl.isDisplayed(), "Avatar Image is not displayed..");

    }
    @When("User is testing HeaderSection functionalities")
    public void user_is_testing_header_section_functionalities() {
        WebElement popularEl = home.getPopularEl();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        popularEl.click();

        String expUrl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Popular Section URL is not matching..");

        WebElement homeEl = home.getHomeEl();
        homeEl.click();

        expUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Home Section URL is not matching..");

        WebElement searchEl = home.getSearchEl();
        searchEl.click();

        expUrl = "https://qamoviesapp.ccbp.tech/search";
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Search Section URL is not matching..");

        WebElement avatarImgEl = home.getAvatarImgEl();
        avatarImgEl.click();

        expUrl = "https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Account Section URL is not matching..");

    }
    @When("close the browser")
    public void close_the_browser() {
        driver.close();
    }


}


