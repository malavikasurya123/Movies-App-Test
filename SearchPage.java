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

public class SearchPage {
    WebDriverWait wait;
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clicksearch() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/nav/div[2]/button[1]")));
        button.click();
    }

    public void enterSearchText(String searchtext) {
        driver.findElement(searchInputFieldLocator).sendKeys(searchtext);
    }
    By searchInputFieldLocator=By.xpath("//*[@id=\"search\"]");
    public void clickSearchButton() {
        driver.findElement(searchButtonLocator).click();
    }
    By searchButtonLocator=By.className("search-button");
    public void search1(String searchText) {
        enterSearchText(searchText);
        clickSearchButton();

    }

    By movieListItemsLocator = By.className("movie-icon-item");

    public int getmovieCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieListItemsLocator));
        return driver.findElements(movieListItemsLocator).size();
    }
}

