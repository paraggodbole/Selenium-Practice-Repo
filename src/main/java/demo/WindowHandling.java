package demo;

import java.io.File;
import java.io.IOException;
import java.nio.channels.AsynchronousByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
    WebDriver driver;
    public WindowHandling(){

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

    public void window() throws InterruptedException, IOException{
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        //Switch to iFrame we want  driver.switch().to().frame().("iframeResult");
        driver.switchTo().frame("iframeResult");
        //Click on button Try it Using Locator "XPath" //button[text()='Try it']
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());
        // Handle windows   Set <String> s = driver.getWindowHandles();
        Set <String> s = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(s);
        // Switch to child window  driver.switchTo().window(child);
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);
        // get url of child window  System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());
        // get title of child window  System.out.println(driver.getTitle());
        System.out.println(driver.getTitle());
    
        // take screenshot of child window  AShot ashot = new AShot();
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        AShot ashot = new AShot();
        Screenshot screenshot = ashot.takeScreenshot(driver);
        String filename = "Screenshot " + timeStamp + ".png";
        ImageIO.write(screenshot.getImage(), "PNG", new File(filename));
        System.out.println("Full page screenshot capture and saved at: " + filename);

        // close the child window  driver.close();
        driver.close();
        // Switch back to the main window which is the parent window.  driver.switchTo().window(parent);
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        }
    }
    
    
    
    

