package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearch {

    WebDriver driver;
    public AmazonSearch(){

        // System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: AmazonSearch");
        driver.close();
        driver.quit();

    }

    public  void testCase01(){
    //Navigate to google  https://www.google.com/
    driver.get("www.google.com");
    //Enter amazon in search text box Using Locator "Name" q | sendKeys("amazon")
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("amazon");
    //Verify that "amazon.in" or "amazon.com" is present on page  Using Locator "XPath" //span[text()='Amazon.in' or text()='Amazon.com'] | sendKeys(Keys.RETURN)
    driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    boolean result = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']")).isDisplayed();
    System.out.println("Is Amazon present in results:" +result);
 
    }
    
}
