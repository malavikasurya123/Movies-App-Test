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
public class SearchPageSteps {
    WebDriver driver = Hooks.getDriver();
    //WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public LoginPage login;
    public HomePage home;
    public PopularPage popularPage;
    public SearchPage searchPage;
    @Given("Navigate to the Search page")
    public void navigates_to_Search_page() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        popularPage = new PopularPage(driver);
        searchPage = new SearchPage(driver);
        login.loginToApplication("rahul", "rahul@2021");
        popularPage.clickButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/search";
        searchPage.clicksearch();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }
    @When("Test the Search functionality1 by searching with some movie1 names and the count of movies displayed")
    public void TesttheSearchfunctionalityandcountofmoviesdisplayed1(){
        searchPage.search1("venom");
        System.out.println(searchPage.getmovieCount());
    }
    @When("Test the Search functionality2 by searching with some movie2 names and the count of movies displayed")
    public void TesttheSearchfunctionalityandcountofmoviesdisplayed2(){
        searchPage.search1("Avatar");
        System.out.println(searchPage.getmovieCount());
    }
}
