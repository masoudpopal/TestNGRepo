package c.Syntax.class01;

import org.testng.annotations.Test;

public class SampleTestNG {
    @Test(priority = 2, enabled = true)
    public void firstMethod(){
        System.out.println("This is my first method");


        }
        @Test(enabled = false)
        public void aSecondMethod(){
            System.out.println("This is my second method");
    }
    @Test(priority = 1, enabled = true)
    public void thirdMehtod(){
        System.out.println("This is my third method");
    }
}
