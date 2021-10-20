package c.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class MasoudWahab {
    WebDriver driver;
    @BeforeMethod
    public void  openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test()
    public void MyFirstMethod(){
        System.out.println("this is my first method.");
    }
    @Test()
    public void SecondMethod(){
        System.out.println("This is my second method.");
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
