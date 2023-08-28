package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageLinkedin {

    WebDriver driver;

    public ImageLinkedin() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void imagepost() throws InterruptedException, AWTException {
        // Navigate to URL https://in.linkedin.com/
        driver.get("https://in.linkedin.com/");

        // Enter Email id Using Locator "XPath" //input[@id='session_key'] |
        // sendKeys("paraggodbolepg@gmail.com")
        driver.findElement(By.xpath("//input[@id='session_key'] ")).sendKeys("paraggodbole07@gmail.com");
        // Enter Password Using Locator "XPath" //input[@id='session_password'] |
        // sendKeys("Password")
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("******");
        // Click on SignIn Using Locator "XPath" //button[contains(text(),'Sign
        // in')].click()
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(3000);

        // Click on start a post Using Locator "XPath" //span[text()='Start a
        // post'].click()
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();

    
        // Select photo option Using Locator "XPath" //button[@aria-label='Add media']/span[@class='share-promoted-detour-button__icon-container']
        // WebElement buttonImage = driver.findElement(By.xpath(
        //         "//button[@aria-label='Add media']/span[@class='share-promoted-detour-button__icon-container']")); 
        driver.findElement(By.xpath("//button[@aria-label='Add media']/span[@class='share-promoted-detour-button__icon-container']")).click();
        //sendKeys("C:\\Image\\automation-testing.png");
        Thread.sleep(2000);

        Robot rb = new Robot();
        rb.delay(2000);

        StringSelection ss = new StringSelection("C:\\Image\\automation-testing.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        // Find done button , save in variable doneButton and click Using Locator
        // "XPath" //span[text()='Next'] | nextButton.click()
        driver.findElement(By.xpath("//span[text()='Next']")).click();

        // Select a text field to write and store in variable textField Using Locator
        // "XPath" //div[@aria-placeholder='What do you want to talk about?']
        WebElement textField = driver
                .findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
        // Pass text in the text field textField.sendKeys('Hi Folks')
        textField.click();
        textField.sendKeys("Advantages of Automation Testing-");

        // Find post button,save in variable postButton and click Using Locator "XPath"
        // //span[text()='Post'] | postButton.click()
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);

        // Verify Post successful comes after posting. Using Locator "XPath"
        // //span[(text()='Post successful.')]
        WebElement Message = driver.findElement(By.xpath("//span[(text()='Post successful.')]"));
        System.out.println(Message.isDisplayed());
        // Also check for "View post" appears after posting and click on View post Using
        // Locator "XPath" //a[text()='View post'].click
        driver.findElement(By.xpath("//a[text()='View post']")).click();
        Thread.sleep(3000);
        // verify post is successfully posted Using Locator "XPath"
        // //section[@class='fixed-full']
        WebElement postSuccessfull = driver.findElement(By.xpath("//section[@class='fixed-full']"));
        if (postSuccessfull.isDisplayed()) {
            System.out.println("Post is Successfully Displayed");
        } else {
            System.out.println("Post is not Displayed");
        }
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
}
