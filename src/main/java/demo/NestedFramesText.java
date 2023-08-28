package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFramesText {
    WebDriver driver;

    public NestedFramesText() {
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

    public void frame() {
        // Navigate to URL https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        // Switch to Top Frame driver.switchTo().frame("frame-top")
        driver.switchTo().frame("frame-top");
        System.out.println("Frame number 1 = Top frame");

        // now move to another frame inside top frame
        // driver.switchTo().frame("frame-left")
        driver.switchTo().frame("frame-left");
        // Search for text present in left frame and store under left_frame Using
        // Locator "Tag Name" driver.switchTo().frame("frame-left")
        WebElement left_frame = driver.findElement(By.tagName("body"));
        // Print Text System.out.println("Text under left frame is" + left_frame)
        System.out.println("Text Inside Frame(1-A) is :"   +left_frame.getText());

        // Go back to Top frame driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();

        // now move to another frame inside top frame
        // driver.switchTo().frame("frame-middle")
        driver.switchTo().frame("frame-middle");
        // Search for text present in middle frame and store under middle_frame Using
        // Locator "Tag Name" //body | .getText()
        WebElement middle_frame = driver.findElement(By.tagName("body"));
        // Print Text System.out.println("Text under middle frame is" + middle_frame)
        System.out.println("Text Inside Frame (1-B) is :"  +middle_frame.getText());

        // Go back to Top frame driver.switchTo().parentFrame()
        driver.switchTo().parentFrame();

        // now move to last frame inside top frame
        // driver.switchTo().frame("frame-right")
        driver.switchTo().frame("frame-right");
        // Search for text present in right frame and store under right_frame Using
        // Locator "Tag Name" //body | getText())
        WebElement right_frame = driver.findElement(By.tagName("body"));
        // Print Text System.out.println("Text under right frame is" + right_frame)
        System.out.println("Text Inside Frame (1-C) is :"  +right_frame.getText());

        // Go back to Main frame driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();

        // now move to bottom frame driver.switchTo().frame("frame-bottom")
        driver.switchTo().frame("frame-bottom");
        System.out.println("Frame Number 2 = Bottom Frame");
        // Search for text present in bottom frame and store under bottom_frame Using
        // Locator "Tag Name" //body | .getText()
        WebElement bottom_frame = driver.findElement(By.tagName("body"));
        // Print Text System.out.println("Text under bottom frame is" + bottom_frame)
        System.out.println("Text Inside Frame 2 is :"  +bottom_frame.getText());

        // Go back to Main frame driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
    }

}
