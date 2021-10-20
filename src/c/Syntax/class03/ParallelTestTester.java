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

public class ParallelTestTester {
    // we don't use parallel a lot because with parallel we test so many classes or so many methods, so it put to much
    // pressure on computer and some tests might be skipped. but still in some cases we can use it.
    // it is only good for few test cases but we want to use a lot of tests we should use Selenium Grid not testNG
    WebDriver driver;
    @DataProvider
    //loginData is now a DataProvider it is good to use dataprovider for few data volume like now we have 3
    public Object[][] loginData(){
        Object[][] data=new Object[3][2];
        data[0][0]="Admin";
        data[0][1]="Hum@nhrm123";
        data[1][0]="Michael12345";
        data[1][1]="Hum@nhrm123";
        data[2][0]="Admin";
        data[2][1]="Hum@nhrm123";
        ;
        return data;
    }


    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }
    @Test(dataProvider = "loginData")
    public void validLogin(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed()); // this is the if condition in case if we make wrong credentials
    }
    @Test(dataProvider = "loginData")
    public void validLogin2(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed()); // this is the if condition in case if we make wrong credentials
    }
    @Test(dataProvider = "loginData")
    public void validLogin3(String username, String password){
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
        Assert.assertTrue(welcomeAttribute.isDisplayed()); // this is the if condition in case if we make wrong credentials
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
