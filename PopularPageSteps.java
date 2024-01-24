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
public class PopularPageSteps {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public LoginPage login;
    public HomePage home;
    public PopularPage popularPage;

    @Given("navigates to Popularpage")
    public void navigates_to_Popular_page() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        popularPage = new PopularPage(driver);
        driver.get("https://qamoviesapp.ccbp.tech");
        login.loginToApplication("rahul", "rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL do not matching..");
        WebElement popularEl = home.getPopularEl();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        popularEl.click();
        String expUrl2 = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expUrl2));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Popular Section URL is not matching..");

    }

    @When("Test whether the movies are displayed")
    public void Testwhetherthemoviesaredisplayed() {
        List<WebElement> popularmovies = popularPage.getMovieList();
        for (WebElement movies : popularmovies) {
            System.out.println(movies.isDisplayed());

        }
    }
}
