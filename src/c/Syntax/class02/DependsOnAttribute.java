package c.Syntax.class02;

import org.testng.annotations.Test;

public class DependsOnAttribute {
    @Test
    public void login() {
        System.out.println("This is my login method");
    }

    @Test(dependsOnMethods = "login")
    //when we say depends on login that means even if we run the dashboardpage the first
    // print will be the login method
    public void verifyDashboardPage() {
        System.out.println("This is my dashboard page");

    }

    @Test
    public void verifyLogout() {
        System.out.println("This is my logout page");
    }
}
