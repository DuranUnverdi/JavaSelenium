package DriverMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverGetMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //yazdığımız url gider
        driver.get("https://www.amazon.com");

        //içinde olduğu sayfanın başlığını döndürür
       System.out.println("sayfa title :"+ driver.getTitle());

       //içinde olduğu sayfa url ini döndürür
        System.out.println(driver.getCurrentUrl());
        System.out.println("----------------------------------");
        //içinde bulunan sayfanın frontend kodlarını döndürür
        System.out.println(driver.getPageSource());
        System.out.println("----------------------------------");


    }
}
