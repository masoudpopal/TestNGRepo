package class04;

import org.testng.annotations.*;

public class HowToGetSomeComputerInfo {
    @BeforeClass
    public void beforeClass() {
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am after class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am before method and will execute before every test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am after method and will execute after every test");
    }




    @Test
    public void firstMethod() {
        System.out.println("This is my first method");


        System.out.println(System.getProperty("os.name"));  // this will print windows 10
        System.out.println(System.getProperty("user.name"));  // this will give the username which is (masou)
        System.out.println(System.getProperty("user.dir"));  // this will give the patch of current project
    }


}
