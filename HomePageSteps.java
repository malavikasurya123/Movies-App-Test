package stepdefinitions;
import java.util.*;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
public class HomePageSteps  {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public LoginPage login;
    public HomePage home;

    @Given("User is in home page")
    public void User_is_in_home_page() {
        login = new LoginPage(driver);
        home= new HomePage(driver);
      driver.get("https://qamoviesapp.ccbp.tech");
       login.loginToApplication("rahul","rahul@2021");
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "URL do not matching..");

    }
    @When("verify home text")
    public void verifyhometext(){
        String HomeText = home.getHomeText();
        String expHomeText = "Home";

        Assert.assertEquals(HomeText, expHomeText, "Home Text is not matching..");
    }
    @When("test heading texts of each section")
    public void test_heading_texts_of_each_section() {
        List<WebElement> headingTexts = home.getHeadingTexts();
        String headingText1 = headingTexts.get(0).getText();
        String expHeadingText1 = "Trending Now";

        Assert.assertEquals(headingText1, expHeadingText1, "First Section heading is not matching..");

        String headingText2 = headingTexts.get(1).getText();
        String expHeadingText2 = "Originals";

        Assert.assertEquals(headingText2, expHeadingText2, "Second Section heading is not matching..");

    }

    @Then("Test whether the play button is displayed or not")
    public void test_whether_the_play_button_is_displayed_or_not() {
        WebElement playButton = home.clickOnLoginButton1();
        Assert.assertTrue(playButton.isDisplayed());
    }
    @Then("Test whether the Movies are displayed, in the corresponding movies sections")
    public void test_whether_the_movies_are_displayed_in_the_corresponding_movies_sections() {
        List<WebElement> moviesList = home.getMoviesList();
        Assert.assertEquals(moviesList.size(), 20, "Movies count is not matching..");

    }
    @Then("Test the contact us section")
    public void test_the_contact_us_section() {
        String contactUsText = home.getContactUsHeading();
        String expContactUsText = "Contact Us";
        Assert.assertEquals(contactUsText, expContactUsText, "Contact Us text is not matching..");
        List<WebElement> contactUsIcons = home.getContactIcons();
        Assert.assertEquals(contactUsIcons.size(), 4, "Contact Us Icons count is not matching..");

    }
    
}
