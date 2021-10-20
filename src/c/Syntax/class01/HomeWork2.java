package c.Syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {
    //TC 1: HRMS Application Login:
    //Open chrome browser
    //Go to http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
    //Enter valid username and password
    //Click on login button
    //Then verify Syntax Logo is displayed
    //Close the browser
    WebDriver driver;
    @BeforeClass
    public void browser(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test(priority = 1)
    public void validUserName(){
        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord=driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();

    }
    @Test(priority = 2)
    public void logoDisplay(){
        WebElement loDisplay=driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img"));
        loDisplay.isDisplayed();
        System.out.println("lOGO IS DISPLAYED");
    }
    @AfterClass
    public void finishMethod(){
        driver.quit();
    }
}
