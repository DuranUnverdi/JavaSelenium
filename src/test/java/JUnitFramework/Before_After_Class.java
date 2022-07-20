package JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Before_After_Class {
    WebDriver driver;
    @Before//her şeyden önce çalışır//BeforeClass yaparsak class başında bir kere çalışır
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After//en son çalışacak kısım//AfterClass yaparsak class sonunda bir kere çalışır
    public void tearDown(){
        driver.close();
    }
    @Test //@Ignore bu testi atlar
    public void test01(){
        driver.get("https:www.amazon.com");
    }
    @Test
    public void test02(){
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void test03(){
        driver.get("https:www.facebook.com");
    }
}
