package c.Syntax.class02;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HomeWork {
    //Open chrome browser
    //Go to “http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    //Login into the application
    //Click on Add Employee
    //Verify labels: Full Name, Employee Id, Photograph are displayed
    //Provide Employee First and Last Name
    //Add a picture to the profile
    //Verify Employee has been added successfully
    //Close the browser
    WebDriver driver;
    @BeforeClass
            public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test(priority = 0,enabled = true)
    public void login(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();
    }
    @Test(priority = 1,enabled = true)
    public void addEmployee(){
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
    }
    @Test(priority = 2,enabled = true)
    public void displayTitle(){
        WebElement fullName=driver.findElement(By.xpath("//label[text()='Full Name']"));
        Assert.assertTrue(fullName.isDisplayed());
        WebElement employeeId=driver.findElement(By.xpath("//label[text()='Employee Id']"));
        Assert.assertTrue(employeeId.isDisplayed());
        WebElement photograph=driver.findElement(By.xpath("//label[text()='photograph']"));
        Assert.assertTrue(photograph.isDisplayed());
    }
    @Test(priority = 3,enabled = true)
    public void firstName(){
        WebElement fName=driver.findElement(By.id("firstName"));
        fName.sendKeys("Masoud");
        WebElement lName=driver.findElement(By.id("lastName"));
        lName.sendKeys("Popal");
    }
    @Test(priority = 4,enabled = true)
    public void addPicture(){
       WebElement aPicture=driver.findElement(By.id("photofile"));
       aPicture.click();
       aPicture.sendKeys("C:\\Users\\masou\\Desktop\\View\\.jpeg");
       WebElement saveButton=driver.findElement(By.id("btnSave"));
       saveButton.click();


        }
        @Test(priority = 5,enabled = true)
        public void verifyInfo(){
        WebElement verifyInfo=driver.findElement(By.id("menu_pim_viewEmployeeList"));
        verifyInfo.click();
        WebElement searchBar=driver.findElement(By.id("empsearch_id"));
        searchBar.sendKeys("19326000");
        WebElement searchButton=driver.findElement(By.id("searchBtn"));
        searchButton.click();
            TakesScreenshot ts= (TakesScreenshot) driver;
            File sourceFile =ts.getScreenshotAs(OutputType.FILE);
            driver.quit();


    }
    @AfterClass
    public void tearDown(){driver.quit();
    }


}
