package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PopularPage {


    WebDriverWait wait;
    WebDriver driver;

    public PopularPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @FindBy(xpath ="//*[@id=\"root\"]/div/div[1]/li[2]")
    List<WebElement> movieList;
    public List<WebElement> getMovieList() {
        wait.until(ExpectedConditions.visibilityOfAllElements(movieList));
        return movieList;
    }

    public void clickButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular")));
        button.click();
    }
    By button1 = By.className("play-button");
    By popularMoviesLocator = By.xpath("//li[@class='movie-icon-item']");
    public void clickSearchButton1() {
        driver.findElement(button1).click();
    }
    public List<WebElement> getPopularMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularMoviesLocator));
        List<WebElement> popularMovies = driver.findElements(popularMoviesLocator);

        return popularMovies;
    }
}
