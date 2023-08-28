package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleNameLinks {
    
    WebDriver driver;

    public GoogleNameLinks() {

        System.out.println("Constructor: TestCases");
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

    public  void CountLinks() throws InterruptedException{
        // Navigate to google  https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        //Enter your name in search text box Using Locator "Name" q | sendKeys('Parag')
        WebElement textBox = driver.findElement(By.name("q"));
        textBox.sendKeys("Parag");
        //Press Enter key Using Locator "Name" q | sendKeys(Keys.RETURN)
        textBox.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
        //Find list of links with variable ListOfName Using Locator "XPath" //a[contains(@href,'parag')]
        List <WebElement> ListofName = driver.findElements(By.xpath("//a[contains(@href,'parag')]"));
        //Get Count of links   ListOfName.size()
        System.out.println("The count of links in the search result with your name is :" +ListofName.size());
    
    }

}
