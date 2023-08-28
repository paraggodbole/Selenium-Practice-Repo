package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bookmyshow {

    WebDriver driver;

    public Bookmyshow() {

        // System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void BookMyShow() throws InterruptedException{
        // Navigate to URL  https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //Find list of links with variable ListOfLinks Using Locator "Tag Name" a 
        List<WebElement> ListOfLinks = driver.findElements(By.tagName("a"));
        Thread.sleep(3000);
        //Get and Print Count of links  ListOfLinks.size()
        System.out.println("Total count of hyperlinks is :  "  +ListOfLinks.size());
    }

}
