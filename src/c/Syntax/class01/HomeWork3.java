package c.Syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeWork3 {
    //TC 2: HRMS Application Negative Login:
    //Open chrome browser
    //Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    //Enter valid username
    //Leave password field empty
    //Verify error message with text “Password cannot be empty” is displayed.
    WebDriver driver;
    @BeforeClass
    public void negiveLogin(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test(priority = 1)
    public void wrongCre(){
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord=driver.findElement(By.id("txtPassword"));
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }
    @Test(priority = 2)
    public void wrongMessage(){
        WebElement wMessage=driver.findElement(By.id("spanMessage"));
        String expectedText="Password cannot be empty";
        String actualText=wMessage.getText();
        Assert.assertEquals(actualText, expectedText,"It works without password");
        System.out.println(wMessage.getText());
    }
    @AfterClass
    public void emptyPassword(){

    }
}
