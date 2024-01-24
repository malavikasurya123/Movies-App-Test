package Pages;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    By homeLocator = By.xpath("//a[text()='Home']");
    public String getHomeText1(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLocator));
        return driver.findElement(homeLocator).getText();
    }

    By logo = By.className("website-logo");

    public WebElement getMoviesLogoEl() {
        return driver.findElement(logo);
    }

    By hometext = By.linkText("Home");

    public String getHomeText() {
        return driver.findElement(hometext).getText();

    }

    By populartext = By.linkText("Popular");

    public String getPopularText() {
        return driver.findElement(populartext).getText();

    }
    By headingTexts= By.xpath("//h1[@class = 'movies-list-heading']");
    public List<WebElement> getHeadingTexts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingTexts));
        return driver.findElements(headingTexts);
    }
    By moviesLocator = By.xpath("//div[@class='react-slick-item']");
    public List<WebElement> getMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesLocator));
        List<WebElement> moviesList = driver.findElements(moviesLocator);
        return moviesList;
    }
    public void clickButton1() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.className("avatar-button")));
        button.click();
    }
    By contactIcons1= By.xpath("//div[@class='footer-icons-container']/child::*");
    By contactUsLocator = By.className("contact-us-paragraph");
    public List<WebElement> getContactIcons(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactIcons1));
        List<WebElement> contactIcons = driver.findElements(contactIcons1);
        return contactIcons;
    }

    public String getContactUsHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsLocator));
        return driver.findElement(contactUsLocator).getText();
    }

    By avatartext = By.className("avatar-button");

    public WebElement getAvatarImgEl() {
        return driver.findElement(avatartext);
    }

    By populartext1 = By.linkText("Popular");

    public WebElement getPopularEl() {
        return driver.findElement(By.linkText("Popular"));
    }

    public WebElement getHomeEl() {
        return driver.findElement(By.linkText("Home"));
    }


    //homepagetest
    @FindBy(className = "movies-list-heading")
    List<WebElement> labelElements1;
    @FindBy(className = "home-movie-play-button")
    WebElement loginButtonElement1;
    @FindBy(className = "home-movie-details-container")
    WebElement moviesection;
    @FindBy(className = "contact-us-paragraph")
    WebElement contactus;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getLabelTextAt(int index) {
        return labelElements1.get(index).getText();
    }

    public WebElement clickOnLoginButton1() {
        return loginButtonElement1;
    }

    public WebElement moviesection() {
        return moviesection;
    }

    public WebElement contact() {
        return contactus;
    }

    public void clickButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular")));
        button.click();
    }
    By search = By.xpath("//button[@class='search-empty-button']/child::*");
    public String getHeadingText(String headingCssSelector) {
        WebElement headingElement = driver.findElement(By.cssSelector(headingCssSelector));
        return headingElement.getText();
    }
    public WebElement getSearchEl(){
        wait.until(ExpectedConditions.elementToBeClickable(search));
        return driver.findElement(search);
    }

}


