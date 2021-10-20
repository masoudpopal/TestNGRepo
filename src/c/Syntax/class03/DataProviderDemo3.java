package c.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo3 {
    WebDriver driver;

    @DataProvider
    public Object[][] loginData() {
        Object data[][] = new Object[4][2];
        data[0][0] = "Hum@nhrm123";  // here we switched username with password
        data[0][1] = "Admin";
        data[1][0] = "Michael12345"; // here we created a new user
        data[1][1] = "Hum@nhrm123";
        data[2][0] = "Admin123";    // here we made the credentials wrong
        data[2][1] = "Hum@nhrm123";
        data[3][0] = "Admin";
        data[3][1] = "Hum@nhrm123";

        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(dataProvider = "loginData")
    public void validLogin(String username, String password) {
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }
    @Test(dataProvider = "loginData")
    public void validLogin2(String username, String password) {
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }
    @Test(dataProvider = "loginData")
    public void validLogin3(String username, String password) {
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed());
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
