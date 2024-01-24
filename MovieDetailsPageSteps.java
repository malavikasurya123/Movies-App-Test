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
import java.util.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
    public class MovieDetailsSteps {
        WebDriver driver = Hooks.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        public LoginPage login;
        public HomePage home;
        public PopularPage popularPage;
        public SearchPage searchPage;
        public AccountPage accountPage;
        public MovieDetailsPage moviespage;

            @Given("the user is on the Home Page")
            public void the_user_is_on_the_home_page() {
                login = new LoginPage(driver);
                home = new HomePage(driver);
                popularPage = new PopularPage(driver);
                moviespage = new MovieDetailsPage(driver);
                driver.get("https://qamoviesapp.ccbp.tech");

                login.loginToApplication("rahul", "rahul@2021");

                String expUrl = "https://qamoviesapp.ccbp.tech/";
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.urlToBe(expUrl));

                Assert.assertEquals(driver.getCurrentUrl(), expUrl, "URL do not matching..");

            }
        @When("checking popular Movie Details Ui Test")
        public void checking_popular_movie_details_ui_test() {
                WebElement popularEl = home.getPopularEl();
            popularEl.click();
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                String expUrl2 = "https://qamoviesapp.ccbp.tech/popular";
                wait.until(ExpectedConditions.urlToBe(expUrl2));

                Assert.assertEquals(driver.getCurrentUrl(), expUrl2, "Popular Section URL is not matching..");
            List<WebElement> popularMovies = popularPage.getPopularMoviesList();
            popularMovies.get(3).click();

            String expUrl = "https://qamoviesapp.ccbp.tech/movies/b2872586-3e64-4fc0-a244-f21c2e62fb37";
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expUrl));

            Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Movie details page URL is not matching..");

            String movieTitle = moviespage.getMovieTitle();
            String expMovieTitle = "Luca";

            Assert.assertEquals(movieTitle, expMovieTitle, "Movie title is not matching..");

            List<WebElement> movieReview = moviespage.getMovieReview();

            String watchTime = movieReview.get(0).getText();
            String sensorRating = movieReview.get(1).getText();
            String releaseYear = movieReview.get(2).getText();

            String expWatchTime = "2h 7m";
            String expSensorRating = "U/A";
            String expReleaseYear = "2021";

            Assert.assertEquals(watchTime, expWatchTime, "Watch time is not matching..");
            Assert.assertEquals(sensorRating, expSensorRating, "Sensor Rating is not matching..");
            Assert.assertEquals(releaseYear, expReleaseYear, "Release year is not matching..");

            String movieOverview = moviespage.getMovieOverview();
            String expMovieOverview = "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.";

            Assert.assertEquals(movieOverview, expMovieOverview, "Movie overview is not matching..");

            WebElement playBtnEl = moviespage.getPlayBtn();

            Assert.assertTrue(playBtnEl.isDisplayed(), "Play button is not displayed..");

            String genresHeading = moviespage.getGenresHeading();
            String expGenreHeading = "Genres";

            Assert.assertEquals(genresHeading, expGenreHeading, "Genres Heading is not matching..");

            List<WebElement> genresContainer = moviespage.getGenresContainer();

            String[] expGenresContent = {"Action","Crime","Thriller"};

            ArrayList<String> genresContent = new ArrayList<String>();

            for(WebElement genreEl : genresContainer){
                genresContent.add(genreEl.getText());
            }

            ArrayList<String> expGenresContentList = new ArrayList<String>(Arrays.asList(expGenresContent));

            Assert.assertEquals(genresContent, expGenresContentList, "Genres Content is not matching..");

            String audioHeading = moviespage.getAudioHeading();
            String expAudioHeading = "Audio Available";

            Assert.assertEquals(audioHeading, expAudioHeading, "Audio heading is not matching..");

            List<WebElement> audioContainer = moviespage.getAudioContainer();

            String[] expAudioContent = {"German","English","Czech","French"};

            ArrayList<String> audioContent = new ArrayList<String>();

            for(WebElement audioEl : audioContainer){
                audioContent.add(audioEl.getText());
            }

            ArrayList<String> expAudioContentList = new ArrayList<String>(Arrays.asList(expAudioContent));

            Assert.assertEquals(audioContent, expAudioContentList, "Audio content is not matching..");

            List<WebElement> ratingCategory = moviespage.getRatingCategory();

            String ratingHeading = ratingCategory.get(0).getText();
            String ratingText = ratingCategory.get(1).getText();
            String ratingAvgHeading = ratingCategory.get(2).getText();
            String ratingAvgText = ratingCategory.get(3).getText();

            Assert.assertEquals(ratingHeading, "Rating Count", "Rating heading is not matching..");
            Assert.assertEquals(ratingText, "645", "Rating text is not matching..");
            Assert.assertEquals(ratingAvgHeading, "Rating Average", "Rating average heading is not matching..");
            Assert.assertEquals(ratingAvgText, "6.9", "Rating average text is not matching..");

            List<WebElement> budgetCategory = moviespage.getBudgetCategory();

            String budgetHeading = budgetCategory.get(0).getText();
            String budgetText = budgetCategory.get(1).getText();
            String releaseDateHeading = budgetCategory.get(2).getText();
            String releaseDateText = budgetCategory.get(3).getText();

            Assert.assertEquals(budgetHeading, "Budget", "Budget Heading is not matching..");
            Assert.assertEquals(budgetText, "23 Crores", "Budget text is not matching..");
            Assert.assertEquals(releaseDateHeading, "Release Date", "Release Date heading is not matching..");
            Assert.assertEquals(releaseDateText, "27th October 2021", "Release date text is not matching..");

            String similarMoviesHeading = moviespage.getSimilarMoviesHeading();

            Assert.assertEquals(similarMoviesHeading, "More like this", "Similar movies heading is not matching..");

            List<WebElement> similarMovies = moviespage.getSimilarMoviesList();

            Assert.assertEquals(similarMovies.size(), 35, "Similar movies count is not matching..");

        }
        @When("checking home Movie Details Ui Test")
        public void checking_home_movie_details_ui_test() {
            List<WebElement> homeMovies = home.getMoviesList();
            homeMovies.get(12).click();

            String expUrl = "https://qamoviesapp.ccbp.tech/movies/33119fe5-3966-4bba-b98c-10b241ffc9f8";
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe(expUrl));

            Assert.assertEquals(driver.getCurrentUrl(), expUrl, "Movie details page URL is not matching..");

            String movieTitle = moviespage.getMovieTitle();
            String expMovieTitle = "Titanic";

            Assert.assertEquals(movieTitle, expMovieTitle, "Movie title is not matching..");

            List<WebElement> movieReview = moviespage.getMovieReview();

            String watchTime = movieReview.get(0).getText();
            String sensorRating = movieReview.get(1).getText();
            String releaseYear = movieReview.get(2).getText();

            String expWatchTime = "1h 35m";
            String expSensorRating = "U/A";
            String expReleaseYear = "1981";

            Assert.assertEquals(watchTime, expWatchTime, "Watch time is not matching..");
            Assert.assertEquals(sensorRating, expSensorRating, "Sensor Rating is not matching..");
            Assert.assertEquals(releaseYear, expReleaseYear, "Release year is not matching..");

            String movieOverview = moviespage.getMovieOverview();
            String expMovieOverview = "Incorporating both historical and fictionalized aspects, it is based on accounts of the sinking of the RMS Titanic, and stars Leonardo DiCaprio and Kate Winslet";

            Assert.assertEquals(movieOverview, expMovieOverview, "Movie overview is not matching..");

            WebElement playBtnEl = moviespage.getPlayBtn();

            Assert.assertTrue(playBtnEl.isDisplayed(), "Play button is not displayed..");

            String genresHeading = moviespage.getGenresHeading();
            String expGenreHeading = "Genres";

            Assert.assertEquals(genresHeading, expGenreHeading, "Genres Heading is not matching..");

            List<WebElement> genresContainer = moviespage.getGenresContainer();

            String[] expGenresContent = {"Drama"};

            ArrayList<String> genresContent = new ArrayList<String>();

            for(WebElement genreEl : genresContainer){
                genresContent.add(genreEl.getText());
            }

            ArrayList<String> expGenresContentList = new ArrayList<String>(Arrays.asList(expGenresContent));

            Assert.assertEquals(genresContent, expGenresContentList, "Genres Content is not matching..");

            String audioHeading = moviespage.getAudioHeading();
            String expAudioHeading = "Audio Available";

            Assert.assertEquals(audioHeading, expAudioHeading, "Audio heading is not matching..");

            List<WebElement> audioContainer = moviespage.getAudioContainer();

            String[] expAudioContent = {"French"};

            ArrayList<String> audioContent = new ArrayList<String>();

            for(WebElement audioEl : audioContainer){
                audioContent.add(audioEl.getText());
            }

            ArrayList<String> expAudioContentList = new ArrayList<String>(Arrays.asList(expAudioContent));

            Assert.assertEquals(audioContent, expAudioContentList, "Audio content is not matching..");

            List<WebElement> ratingCategory = moviespage.getRatingCategory();

            String ratingHeading = ratingCategory.get(0).getText();
            String ratingText = ratingCategory.get(1).getText();
            String ratingAvgHeading = ratingCategory.get(2).getText();
            String ratingAvgText = ratingCategory.get(3).getText();

            Assert.assertEquals(ratingHeading, "Rating Count", "Rating heading is not matching..");
            Assert.assertEquals(ratingText, "39", "Rating text is not matching..");
            Assert.assertEquals(ratingAvgHeading, "Rating Average", "Rating average heading is not matching..");
            Assert.assertEquals(ratingAvgText, "7.6", "Rating average text is not matching..");

            List<WebElement> budgetCategory = moviespage.getBudgetCategory();

            String budgetHeading = budgetCategory.get(0).getText();
            String budgetText = budgetCategory.get(1).getText();
            String releaseDateHeading = budgetCategory.get(2).getText();
            String releaseDateText = budgetCategory.get(3).getText();

            Assert.assertEquals(budgetHeading, "Budget", "Budget Heading is not matching..");
            Assert.assertEquals(budgetText, "1.6 Crores", "Budget text is not matching..");
            Assert.assertEquals(releaseDateHeading, "Release Date", "Release Date heading is not matching..");
            Assert.assertEquals(releaseDateText, "25th March 1981", "Release date text is not matching..");

            String similarMoviesHeading = moviespage.getSimilarMoviesHeading();

            Assert.assertEquals(similarMoviesHeading, "More like this", "Similar movies heading is not matching..");

            List<WebElement> similarMovies = moviespage.getSimilarMoviesList();

            Assert.assertEquals(similarMovies.size(), 13, "Similar movies count is not matching..");

        }
    }
