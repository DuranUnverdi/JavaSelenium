package DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethod {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        //get ten navigatenin farkı sayfadan geri gelmemize olanak sağlaması
        driver.navigate().to("https://www.facebook.com");
        driver.navigate().back();//amazona geri dönecektir

        //back ile geldiği sayfaya tekrar dönecektir
        driver.navigate().forward();

        //sayfa yenileme
        driver.navigate().refresh();

        //içinde bulunduğu sayfayı kapatma
        driver.close();

        //birden fazla sayfayı kapatır
        //driver.quit();
    }
}
