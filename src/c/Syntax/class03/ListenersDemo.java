package c.Syntax.class03;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class ListenersDemo implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("starting test with the name " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed and we are capturing the final screenshot");
    }

    public void onTestFailureButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Result");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("skipped test case is " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Fail test case is " + result.getName());
    }
    public void onStart(ITestContext context){

    }
    public void onFinish(ITestContext context){

    }
}


