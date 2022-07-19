package WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebElements02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //facebook adresine gidin
        driver.get("https://www.facebook.com");
        //cookies çıkarsa kabul et butonuna basın
        //driver.findElement(By.xpath("//button[@title='Allow essential and optional cookies']")).click();
        //eposta kutusuna rastgele bir mail girin
        WebElement emailBox=driver.findElement(By.xpath("//input[@id='email']"));
        emailBox.sendKeys("asdasd");
        //şifre kısmına rastgele bir şifre girin
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='pass']"));
        passwordBox.sendKeys("aaaaaa");
        //giris yap buyonuna basin
        driver.findElement(By.xpath("//button[@name='login']")).click();

        //uyarı olarak "The  email or mobile number you entered.." mesajı çıktığını test edin
      WebElement resElement=  driver.findElement(By.xpath("//div[@class='_9ay7']"));
        String expectedRes="Girdiğin e-posta veya cep telefonu numarası bir hesaba bağlı değil.";
        String actualRes=resElement.getText();
        if(expectedRes.equals(actualRes)){
            System.out.println("girilemedi testi passed");
        }else{
            System.out.println("girilemedi testi failed");
        }
        //sayfayı kapatın
        driver.close();
    }
}
