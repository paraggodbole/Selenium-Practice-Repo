package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imdb {
    WebDriver driver;
    public Imdb(){

        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    public void imdbTest() throws InterruptedException{
        // Navigate to URL " https://www.imdb.com/chart/top"  driver.get(URL);
        driver.get("https://www.imdb.com/chart/top/");
        // Find the highest rated movie element  Using Locator "XPath" //div/ul/li[1]/div[2]/div/div/div[1]/a/h3
        WebElement HighestRatedMovie = driver.findElement(By.xpath("//div/ul/li[1]/div[2]/div/div/div[1]/a/h3"));
        // Get the text of the element  .getText():
        System.out.println("Highest rated movie in IMDB is: " + HighestRatedMovie.getText());
        // Get count of movies included in the table Using Locator "Tag Name" ul and li Using Locator "XPath" .getSize():
        List<WebElement> countOfMovies = driver.findElements(By.xpath("//li[@class='ipc-metadata-list-summary-item sc-bca49391-0 eypSaE cli-parent']"));
        System.out.println("Count of movies in IMDB site is: " + countOfMovies.size());
        // Sort by the condition,by "RELEASE DATE","NUMBER OF RATINGS"  to find oldest movie Using Locator "ID" sort-by-selector
        Select sortbyRelease = new Select(driver.findElement(By.id("sort-by-selector")));
        sortbyRelease.selectByVisibleText("Release date");
        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(2000);
        // Get the oldest movie Using Locator "XPath" //div[contains(@class, 'cli-children')]/div/a/h3[1]
        WebElement oldestMovie = driver.findElement(By.xpath("//div[contains(@class, 'cli-children')]/div/a/h3[1]"));
        System.out.println("Oldest movie name in IMDB is: " + oldestMovie.getText());
        // Get the most recent movie Using Locator "XPath" //div[contains(@class, 'cli-children')]/div/a/h3[1]
        driver.findElement(By.xpath("//button[@id='swap-sort-order-button']")).click();
        Thread.sleep(4000);

        WebElement LatestMovie = driver.findElement(By.xpath("//div[contains(@class, 'cli-children')]/div/a/h3[1]"));
        System.out.println("Latest movie name in IMDB is: " + LatestMovie.getText());
        // Find out which movie has most user ratings Using Locator "XPath" //div[contains(@class, 'cli-children')]/div/a/h3[1]
        Select sortByRating = new Select(driver.findElement(By.id("sort-by-selector")));
        sortByRating.selectByVisibleText("Number of ratings");
        Thread.sleep(2000);
        WebElement UserRating = driver.findElement(By.xpath("//div[contains(@class, 'cli-children')]/div/a/h3[1]"));
        System.out.println("Most user rating movie is: " + UserRating.getText());
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }
}

