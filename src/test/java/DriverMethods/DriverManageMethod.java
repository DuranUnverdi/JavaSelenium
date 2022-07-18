package DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethod  {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //içinde olunan sayfanın pixel ölçülerini verir
       System.out.println(driver.manage().window().getSize());

       //sayfanın konumunu verir
        System.out.println(driver.manage().window().getPosition());

        //sayfanın solt alt köşesini bizim istediğimiz noktaya taşır
        driver.manage().window().setPosition(new Point(15,15));

        //sayfanın solt alt köşesini bizim istediğimiz boyuta getirir
       driver.manage().window().setSize(new Dimension(900,600));

       System.out.println("yeni pencere ölçüleri: "+driver.manage().window().getSize());
       System.out.println("yeni pencere konumu: "+driver.manage().window().getPosition());

       //İçindeki sayfayı max yapar
        driver.manage().window().maximize();

        //içindeki sayfayı fullscreen yapar
        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



    }
}
