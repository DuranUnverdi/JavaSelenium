package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsClassApp {
    @Test
    public void test01(){
        //Launch Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Navigate to url 'http://outomationexcise.com'
        driver.get("http://automationexercise.com");
        //Click on 'Signup/Login' button
        WebElement signUpLink=driver.findElement(By.xpath("//a[@href='/login']"));
        Actions actions=new Actions(driver);
        actions.click(signUpLink).perform();
        //Enter name and email adress
        WebElement nameBox=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        //Click 'Signup' button
        //actions ile sürekli locate etmekten kurtuluyoruz tab gibi tuşlarla işlem gerçekleştiriyoruz
        actions.click(nameBox)
                .sendKeys("Duran")
                .sendKeys(Keys.TAB)
                .sendKeys("drn@aabc.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        //fill details:Title,Name,Email,Password ,Date of birth
        //Select checkbox 'Sign up for our newsletter'
        //Select checkbox 'Receive special offers from our partners'
        //Fill details:First name ,Last name ,Compnay, Adress ...
        WebElement titleRadiButton= driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        actions.click(titleRadiButton       )
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("3")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1990     ")
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys("Ahmet")
                .sendKeys(Keys.TAB)
                .sendKeys("bulut")
                .sendKeys(Keys.TAB)
                .sendKeys("kendim")
                .sendKeys(Keys.TAB)
                .sendKeys("ulu cadde no 95")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Teksas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("05100")
                .sendKeys(Keys.TAB)
                .sendKeys("5551254568")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //Click 'Create Account button'
        //Verify that 'ACCOUNT CREATED' is visible
        String expectedYazi="ACCOUNT CREATED!";
        String actualYazi=driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
