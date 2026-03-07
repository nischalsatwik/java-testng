package practise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Firsttestcase {

	
	    WebDriver driver;
	    WebDriverWait wait;


	    @BeforeClass
	    public void setUp() {
	        // Set path to chromedriver if required
	    	ChromeOptions options = new ChromeOptions();
	    	 options.addArguments("--disable-notifications");
	    	 options.addArguments("--disable-infobars");
	    	  options.addArguments("--disable-extensions");
	    	  options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @Test(priority = 1)
	    public void openGoogle() {
	        driver.get("https://search.brave.com/");
	        System.out.println("title of the page is: "+driver.getTitle());
	        Assert.assertEquals(driver.getTitle(), "Private Search Engine - Brave Search");
	    }

	    @Test(priority = 2)
	    public void typeYouTubeInSearchBar() {
	        WebElement searchBox = driver.findElement(By.name("q"));
	        searchBox.sendKeys("YouTube");
	        searchBox.submit(); // Press Enter
	        System.out.println("driver.gettitle(): "+driver.getTitle());
	       wait.until(ExpectedConditions.titleContains("YouTube"));
	        
	        Assert.assertTrue(driver.getTitle().contains("YouTube"));
	    }

	    @Test(priority = 3)
	    public void clickFirstYouTubeLink() {

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement firstLink = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("(//div[contains(@class,'search-snippet-title')])[1]")
	                )
	        );

	        firstLink.click();

	        wait.until(ExpectedConditions.urlContains("youtube.com"));

	        Assert.assertTrue(driver.getCurrentUrl().contains("youtube.com"));
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}
