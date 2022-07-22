package Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertionOrnek {
    @Test
    public void test01(){
        //Launch Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Navigate to url 'http://outomationexcise.com'
        driver.get("http://automationexercise.com");
        //Verify that home page is visible successfully
        WebElement logoElement=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());
        //Click on 'Signup/Login' button
        WebElement signUpLink=driver.findElement(By.xpath("//a[@href='/login']"));
        signUpLink.click();
        //Verify 'Login to your account' is visible
        WebElement loginWrite=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginWrite.isDisplayed());//görünürlüğü kontrol etme
        //Enter correct email adress and password
        WebElement emailBox=driver.findElement(By.xpath("//input[@type='email'][1]"));
        emailBox.sendKeys("duranunverdi1905@gmail.com");
        WebElement passwordBox=driver.findElement(By.xpath("//input[@type='password'][1]"));
        passwordBox.sendKeys("12345");
        //Click 'Login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //verify that 'Logged in as username' is visible
        WebElement loggedInWrite=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        System.out.println(loggedInWrite.getText());
        //Click logout button
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();
        //Verfiy that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //Close Driver
        driver.close();
    }
}
