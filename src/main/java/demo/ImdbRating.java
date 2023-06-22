package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImdbRating {
    ChromeDriver driver;
    public ImdbRating()
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
        // Naviagte to url  https://www.imdb.com/chart/top
        driver.get("https://www.imdb.com/chart/top");
        // Locate the highest rated movie Using Locator "XPath" //tbody[@class='lister-list']/tr[1]/td[3]/strong | getText()
        WebElement highestRatedMovie = driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[3]/strong"));
        System.out.println("Highest rated movie :"+highestRatedMovie.getText());
        // Locate the number movies in the table Using Locator "XPath" //tbody[@class='lister-list']/tr | List<WebElements>
        List<WebElement> moviesList = driver.findElements(By.xpath("//tbody[@class='lister-list']/tr"));
        System.out.println("All movies :"+moviesList.size());
        // Locate the dropdown Sort-by Using Locator "XPath" //select[@name='sort']
        WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='sort']"));
        // Select the value "Release Date" Using Locator "XPath" //select[@name='sort']/option[contains(text(),'Release Date')] | Relaese Date
        Select value = new Select(dropdown1);
        value.selectByVisibleText("Release Date");
        // Click on descending order toggle icon Using Locator "XPath" //span[@title='Ascending order']
        WebElement toggleAsc = driver.findElement(By.xpath("//span[@title='Descending order']"));
        toggleAsc.click();
        // Locate the oldest movie from the list Using Locator "XPath" //tbody[@class='lister-list']/tr[1]/td[2]/a | getText()
        WebElement oldestMovie = driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/a"));
        System.out.println("Oldest movie :"+oldestMovie.getText());
        // Click on ascending order toggle icon Using Locator "XPath" //span[@title='Ascending order']
        WebElement toggleDes = driver.findElement(By.xpath("//span[@title='Ascending order']"));
        toggleDes.click();
        // Locate the latest movie from the list Using Locator "XPath" //tbody[@class='lister-list']/tr[1]/td[2]/a | getText()
        WebElement latestMovie = driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/a"));
        System.out.println("Latest movie :"+latestMovie.getText());
        // Locate the dropdown Sort-by Using Locator "XPath" //select[@name='sort']
        // Select the value "Number of ratings" Using Locator "XPath" //select[@name='sort']/option[contains(text(),'Number Of Ratings')] | Number Of Ratings
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='sort']"));
        Select val = new Select(dropdown2);
        val.selectByVisibleText("Number of Ratings");
        // Locate the movie with highest user rating Using Locator "XPath" //tbody[@class='lister-list']/tr[1]/td[2]/a | getText()
        WebElement highestUserRatingMovie = driver.findElement(By.xpath("//tbody[@class='lister-list']/tr[1]/td[2]/a"));
        System.out.println("Highest rated movie :"+highestUserRatingMovie.getText());
    }
}
