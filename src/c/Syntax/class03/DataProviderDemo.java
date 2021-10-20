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

public class DataProviderDemo {
    WebDriver driver;
    @DataProvider     //loginData is now a DataProvider it is good to use dataprovider for few data volume like now we have 3
    public Object[][] loginData(){  //Here object is the parent class
        Object[][] data=new Object[3][2];  //here 3 is the number of rows and 2 is number of columns
        data[0][0]="Admin";
        data[0][1]="Hum@nhrm123";
        data[1][0]="Michael12345"; // here we created a new user
        data[1][1]="Hum@nhrm123";
        data[2][0]="Admin123";    // here we made the credentials wrong
        data[2][1]="Hum@nhrm123";
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
    @Test(dataProvider = "loginData") // here we have to write the name of our data provider
    public void validLogin(String username, String password){  // because we are getting 2 strings we have to mention them
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //WebElement welcomeAttribute = driver.findElement(By.xpath("//*[@id='welcome']"));
       // Assert.assertTrue(welcomeAttribute.isDisplayed()); // in here user is first and password is second but if we switch them
        // and print them it won't work but if you want to see the result

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
