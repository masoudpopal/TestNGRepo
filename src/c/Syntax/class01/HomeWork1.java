package c.Syntax.class01;

import org.testng.annotations.*;

public class HomeWork1 {
    //Create class that will have:
    //Before and After Class annotation
    //Before and After Method annotation
    //2 methods with Test annotation
    //Observe the results!
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before the class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After the class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before the method");
    }
    @Test
    public void firstMethod(){
        System.out.println("I am first");
    }
    @Test
    public void secondMethod(){
        System.out.println("I am second");

    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After the method");
    }

}
