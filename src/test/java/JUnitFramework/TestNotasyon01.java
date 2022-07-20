package JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestNotasyon01 {
    @Test //Test notasyonu koyulduğu andan itibaren bu kısım test edilebilir hale gelicen main method zorunluluğu ortadan kalmış oldı
    public void Test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazon sayfasına gidin
        driver.get("https://www.amazon.com");
        //arama çubuğuna nutella yazın
        WebElement search= driver.findElement(By.id("twotabsearchtextbox"));
        //Nutella yazdıktan sonra enter a basalım
        search.sendKeys("Nutella");
        search.submit();
        //bulunan sonuç sayısını yazdırın
        WebElement resElement=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resElement.getText());
    }
}
