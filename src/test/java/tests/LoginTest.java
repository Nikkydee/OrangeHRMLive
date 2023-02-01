package tests;

import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    @Test(priority = 1)
    public void invalidCredentials() {
        System.out.println("Invalid  login test Starts");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.ClearUserNameInUserNameField();
        loginPage.EnterUserNameInUserNameField("Admin999");
        loginPage.ClearPasswordInPasswordField();
        loginPage.EnterPasswordInUserPasswordField("admin123");
        loginPage.WaitforPageToLoad();
        loginPage.ClickOnLoginButton();
        loginPage.WaitforPageToLoad();
        loginPage.assertErrorMessageIsDisplayedInvalidLogin();
        System.out.println("InvalidLogin Test Passed");

    }
    @Test(priority = 2)
    public void validLogin() {
        System.out.println("Valid  login test Starts");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.WaitforPageToLoad();
        loginPage.ClearUserNameInUserNameField();
        loginPage.EnterUserNameInUserNameField("Admin");
        loginPage.ClearPasswordInPasswordField();
        loginPage.EnterPasswordInUserPasswordField("admin123");
        loginPage.ClickOnLoginButton();
        loginPage.verifyDashboardIsDisplayedAfterValidLogin();

        System.out.println("Valid Login Test Passed");

    }
    @Test(priority = 3)
    public void collapseSidebar() {
        System.out.println("Collapse bar test   test Starts");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.clickOnSidebar();

        System.out.println("Collapse bar Test Passed");

    }

    @Test(priority = 4)
    public void Logout() {
        System.out.println("Logout test Starts");
        LoginPage loginPage =new LoginPage(driver);
        loginPage.clickOnProfileDropDownMenu();
        loginPage.WaitforPageToLoad();
        loginPage.clickOnLogoutButton();
        loginPage.WaitforPageToLoad();
        loginPage.assertUserIsLoggedOut();

        System.out.println("Logout Test Passed");

    }


}

