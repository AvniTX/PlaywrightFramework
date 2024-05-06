package com.qa.opencart.tests;

import com.qa.opencart.Constants.AppsConstant;
import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageNavigationTest(){
        loginPage = homePage.navigateToLoginPage(); //Page chaining, instead of creating object of class, doing with the class reference
        String actualTitle = loginPage.getLoginPageTitle();
        System.out.println("login page title : "+actualTitle);
        Assert.assertEquals(actualTitle, AppsConstant.LOGIN_PAGE_TITLE);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistsTest(){
        Assert.assertTrue(loginPage.isForgotPwdLinkExists());
    }

    @Test(priority = 3)
    public void appLoginTest(){
        loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
    }
}
