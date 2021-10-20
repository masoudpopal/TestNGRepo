package class04;

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

public class HomeWork {
    //Open chrome browser
    //Go to HRMS
    //Login into the application
    //Add 5 different Employees and create login credentials by providing:
    //First Name
    //Last Name
    //Username
    //Password
    //Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
    //Close the browser
    //Specify group for this test case, add it into specific suite and execute from xml file.
    WebDriver driver;

    @DataProvider
    public Object[][] addEmployeeData() {
        Object[][] data = new Object[5][5]; // array size
        data[0][0] = "firstname1";
        data[0][1] = "lastname1";
        data[0][2] = "username10172021";
        data[0][3] = "Hum@nhrm123";
        data[0][4] = "Hum@nhrm123";
        data[1][0] = "firstname2";
        data[1][1] = "lastname2";
        data[1][2] = "username10172022";
        data[1][3] = "Hum@nhrm123";
        data[1][4] = "Hum@nhrm123";
        data[2][0] = "firstname3";
        data[2][1] = "lastname3";
        data[2][2] = "username10172023";
        data[2][3] = "Hum@nhrm123";
        data[2][4] = "Hum@nhrm123";
        data[3][0] = "firstname4";
        data[3][1] = "lastname4";
        data[3][2] = "username10172024";
        data[3][3] = "Hum@nhrm123";
        data[3][4] = "Hum@nhrm123";
        data[4][0] = "firstname5";
        data[4][1] = "lastname5";
        data[4][2] = "username10172025";
        data[4][3] = "Hum@nhrm123";
        data[4][4] = "Hum@nhrm123";

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
    @Test(dataProvider = "addEmployeeData",groups = "smoke") // in here we should use our dataProvider with it's name which is
    //addEmployeeData and add a test.
    public void addEmployeeMethod(String firstName,String lastName, String username, String password, String confirmPassword){
        WebElement userName  = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement(By.id("btnLogin"));
        loginBtn.click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("re_password")).sendKeys(password);
        driver.findElement(By.id("btnSave")).click();
        WebElement createdName= driver.findElement(By.xpath("//div[@id='profile-pic']/h1"));
        String createdNameText = createdName.getText();
        Assert.assertEquals(createdNameText,firstName+" "+lastName,"Employee was not");

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }
}
