package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class BaseClass {
   public  static WebDriver driver ;
    @BeforeTest
    public void setupTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("chrome://settings/clearBrowserData");
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println(" Browser is successfully initiated");
        driver.manage().deleteAllCookies();
    }
    @Test
        public void verifyURLisAccessible() {
            String url = driver.getCurrentUrl();
            String expectedUrl = "https://opensource-demo.orangehrmlive.com";
            assertEquals(url,expectedUrl);
            System.out.println("URL is correct:"+ url);

        }



   @AfterTest
     public void tearDown() {

       driver.quit();

    }



}