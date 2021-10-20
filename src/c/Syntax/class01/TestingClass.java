package c.Syntax.class01;

import org.testng.annotations.*;

public class TestingClass {
    @BeforeTest
    public void beforeTest(){
        System.out.println("I am before test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am after test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before the class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after the class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after Method");
    }
    @Test
    public void testMethod(){System.out.println("This is my first method");}
    @Test
    public void anotherMethod(){System.out.println("This is another method in testing class");}
    @Test
    public void lastMethod(){System.out.println("I am the last in testing class");}



}
