package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Enter;

//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
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

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        // Naviage to URL https://www.google.com/
        
        // Enter text "amazon" Using Locator "XPath" //textarea[@class='gLFyf']|sendKeys("amazon")
        // Click on "Google Search" button Using Locator "XPath" //div[@class='FPdoLc lJ9FBc']/center/input[@value='Google Search']|button.click()
        // Validate amazon.in or amazon.com is present on the page Using Locator "XPath" //span[@class='VuuXrf' and text()='Amazon.in'] | isDisplayed()
        System.out.println("end Test case: testCase02");
    }


}
