package com.qa.opencart.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    // 1. String Locators
    private String emailID = "//input[@name='email']";
    private String password = "//input[@name='password']";
    private String loginBtn = "//input[@type='submit']";
    private String forgotPwdLink = "(//a[text()='Forgott Password'])[1]";
    private String logoutLink = "(//a[text()='Logout'])[2]";


    // 2. Page constructor:
    public LoginPage(Page page){
        this.page=page;
    }


    // 3. Page actions/methods
    public String getLoginPageTitle(){
        return page.title();
    }

    public boolean isForgotPwdLinkExists(){
        return page.isVisible(forgotPwdLink);
    }
    public boolean doLogin(String appUsername, String appPassword){
        System.out.println("App creds "+appUsername+" : "+appPassword);
        page.fill(emailID,appUsername);
        page.fill(password,appPassword);
        page.click(loginBtn);
        if(page.isVisible(logoutLink)){
            System.out.println("User logged in successfully ...");
            return true;
        }
        return false;
    }
}
