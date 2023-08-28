package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePost {
    ChromeDriver driver;
    public CreatePost(){

       // System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void CreatingPost() throws InterruptedException{
        //Navigate to URL  https://in.linkedin.com/ 
        driver.get("https://in.linkedin.com/ ");
        
        //Enter Email id  Using Locator "XPath" //input[@id='session_key']  | sendKeys("paraggodbolepg@gmail.com")
        driver.findElement(By.xpath("//input[@id='session_key'] ")).sendKeys("paraggodbole07@gmail.com");
        //Enter Password  Using Locator "XPath" //input[@id='session_password'] | sendKeys("Password")
        driver.findElement(By.xpath("//input[@id='session_password']")).sendKeys("*********");
        //Click on SignIn Using Locator "XPath" //button[contains(text(),'Sign in')].click()
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        Thread.sleep(3000);

        //Click on start a post  Using Locator "XPath" //span[text()='Start a post'].click()
        driver.findElement(By.xpath("//span[text()='Start a post']")).click();
        //click on your name displayed to select  Using Locator "XPath" //button[@class='share-unified-settings-entry-button']
        driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']")).click();
        //Find the element of radio button for Connectiononly and store in connectionOnly Using Locator "ID" "CONNECTIONS_ONLY"
        WebElement connectionOnly = driver.findElement(By.id("CONNECTIONS_ONLY"));
        //Click on variable we created for radio button   connectionOnly.click();
        connectionOnly.click();
        //Click on done Using Locator "XPath" //span[text()='Done'].click();
        driver.findElement(By.xpath("//span[text()='Done']")).click();
        Thread.sleep(3000);
        //Select a text field to write and store in variable textField Using Locator "XPath" //div[@aria-placeholder='What do you want to talk about?']
        WebElement textField = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
        //Pass text in the text field  textField.sendKeys('Hi Folks')
        textField.click();
        textField.sendKeys("If debugging is the process of removing software bugs, then programming must be the process of putting them in" );
        //Find post button,save in variable postButton and click Using Locator "XPath" //span[text()='Post'] | postButton.click()
        driver.findElement(By.xpath("//span[text()='Post']")).click();
        Thread.sleep(3000);

        //Verify Post successful comes after posting. Using Locator "XPath" //span[(text()='Post successful.')]
        WebElement Message = driver.findElement(By.xpath("//span[(text()='Post successful.')]"));
        System.out.println(Message.isDisplayed());
        //Also check for "View post" appears after posting and click on View post Using Locator "XPath" //a[text()='View post'].click
        driver.findElement(By.xpath("//a[text()='View post']")).click();
        Thread.sleep(3000);
        //verify post is successfully posted Using Locator "XPath" //section[@class='fixed-full']
        WebElement postSuccessfull = driver.findElement(By.xpath("//section[@class='fixed-full']"));
        if(postSuccessfull.isDisplayed()){
            System.out.println("Post is Successfully Displayed");
        }else{
            System.out.println("Post is not Displayed");
        }
    }
}
