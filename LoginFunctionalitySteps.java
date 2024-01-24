package stepdefinitions;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.After;
public class LoginFunctionalitySteps {
    WebDriver driver = Hooks.getDriver();
    WebDriverWait wait;
   private LoginPage login;

    @Given("User is on the login page")
    public void Userisontheloginpage(){
        login = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://qamoviesapp.ccbp.tech/login");


    }
    @Then("Website logo image should be displayed")
    public void websiteLogoImageShouldBeDisplayed()
    {
        WebElement loginImgEl = login.isLogoImageDisplayed();
        Assert.assertTrue(loginImgEl.isDisplayed(), "Website Logo Image is not displaying...");

    }

    @Then("Heading text should be {string}")
    public void headingTextIs(String expected) {
        String loginHeading = login.getHeading();
        Assert.assertEquals(loginHeading, expected, "Login heading is not matching..");

    }
    @Then("Username label text should be {string}")
    public void username_Label_Text_should_be(String expected) {
        String actualLabelText = login.getUsernameLabelText();
        Assert.assertEquals(actualLabelText, expected, "Username label text is incorrect");
    }

    @Then("Password label text should be {string}")
    public void passwordLabelTextIs(String expected) {
        String actualLabelText = login.getPasswordLabelText();
        Assert.assertEquals(actualLabelText, expected, "Password label text is incorrect");
    }

    @Then("Login button should be displayed")
    public void loginButtonshouldbeDisplayed() {
        Assert.assertTrue(login.isLoginButtonDisplayed(), "Login button is not displayed");
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        login.clickOnLoginButton();
    }
    @Then("User should get a error message")
    public void user_should_get_a_error_message() {
        String errorMessage = login.getErrorMessage();
        String expected1 = "*Username or password is invalid";
        Assert.assertEquals(errorMessage, expected1, "Error message with empty input fields");
    }
    @When("User don't enter any username field and enter password")
    public void user_don_t_enter_any_username_field_and_enter_password() {
        login.enterPassword("rahul@2021");
        login.clickOnLoginButton();
        String errorMessage1 = login.getErrorMessage();
        String expected2 = "*Username or password is invalid";
        Assert.assertEquals(errorMessage1, expected2, "Error message with empty user name field is not matching..");
    }
    @When("User enter username field and don't enter password")
    public void user_enter_username_field_and_don_t_enter_password() {
        login.enterUsername("rahul");
        login.clickOnLoginButton();
        String errorMessage2 = login.getErrorMessage();
        String expected3 = "*Username or password is invalid";

        Assert.assertEquals(errorMessage2, expected3, "Error message with empty password field is not matching..");
    }
    @When("User enter wrong username and correct password")
    public void user_enter_wrong_username_and_correct_password() {
        login.loginToApplication("ravi", "rahul@2021");


    }
    @Then("User should get a error message as {string}")
    public void user_should_get_a_error_message_as(String string) {
        String actual = login.getErrorMessage();
        String expErrMsg = "*invalid username";
        Assert.assertEquals(actual, expErrMsg, "Error message with invalid user name is not matching..");
    }
    @When("User enter correct username and wrong password")
    public void user_enter_correct_username_and_wrong_password() {
        login.loginToApplication("rahul", "rahul@222");

    }

    @Then("User should get a error message as 'username and password didn't match'")
    public void user_should_get_a_error_message_as_username_and_password_didn_t_match() {

        String errMsg = login.getErrorMessage();
        String expErrMsg = "*username and password didn't match";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with invalid password is not match");
    }
    @When("User enter incorrect username and correct password")
    public void user_enter_incorrect_username_and_correct_password() {
        login.loginToApplication("ravi", "rahul@222");
        String errMsg = login.getErrorMessage();
        String expErrMsg = "*invalid username";

        Assert.assertEquals(errMsg, expErrMsg, "Error message with both invalid username and password is not matching..");
    }
    @When("User enter correct username and correct password")
    public void user_enter_correct_username_and_correct_password() {
        login.loginToApplication("rahul", "rahul@2021");
    }
    @Then("User should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() {
        String expUrl = "https://qamoviesapp.ccbp.tech/";
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expUrl));

        Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");


    }

    @After
    public void tearDown() {
        driver.quit();

    }



}
