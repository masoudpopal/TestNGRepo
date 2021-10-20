package c.Syntax.class03;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {  // here the ITestListener is an interface
    // here with the help if listeners interfaces we code read the result of our code in an easier way

    public void onTestStart(ITestResult result){
        System.out.println("starting test with the name" +result.getName());
    }

    public void onTestSuccess(ITestResult result){
        System.out.println("test passed");
    }
    public void onTestSkipped(ITestResult result){
        System.out.println("skipped test is:"+ result.getName());
    }
    public void onTestFailure(ITestResult result){
        System.out.println("Fail test case is " +result.getName());
    }
    public void onStart(ITestContext context){

    }
    public void onFinish(ITestContext context){

    }

}
