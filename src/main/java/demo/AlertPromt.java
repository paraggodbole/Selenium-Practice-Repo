package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPromt {
    WebDriver driver;
    public AlertPromt(){
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void alerthandling() throws InterruptedException{

        //Navigate to URL "https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt"  driver.get(URL);
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
        
        //Switch to iFrame we want  driver.switch().to().frame().("iframeResult");
        driver.switchTo().frame("iframeResult");
        //Click on button Try it Using Locator "XPath" //button[text()='Try it']
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        //switch to alert  //button[text()='Try it']
        Alert alert = driver.switchTo().alert();
        //Type Parag in alert  alert.sendKeys("Parag");
        alert.sendKeys("Parag");
        //close the alert alert.accept();
        alert.accept();
        
        //Check that text gets printed Using Locator "XPath" //p[@id='demo']
        WebElement verifyText = driver.findElement(By.xpath("//p[@id='demo']"));
        //get the text printed  System.out.println(.getText());
        System.out.println(verifyText.getText());


    }
}







