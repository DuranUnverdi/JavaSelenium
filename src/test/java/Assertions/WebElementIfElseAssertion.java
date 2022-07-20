package Assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElementIfElseAssertion {
    WebDriver driver;
    @Before//her şeyden önce çalışır//BeforeClass yaparsak class başında bir kere çalışır
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //arama çubuğuna nutella yazın
        WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        //Nutella yazdıktan sonra enter a basalım
        search.sendKeys("Nutella");
        search.submit();
        //bulunan sonuç sayısını yazdırın
        WebElement resElement=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualElement=resElement.getText();
        String expectedElement="Nutella";
        if (actualElement.contains(expectedElement)){
            System.out.println("Nutella testi PASSED");
        }
        else{
            System.out.println("Sonuç yazısı Nutella içermiyor"+"\n Nutella testi FAILED");
        }
        //Assert kullanımında if else gerek yok
        //Assert.assertTrue(actualElement.contains(expectedElement)),

    }
}
