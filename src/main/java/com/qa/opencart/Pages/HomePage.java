package com.qa.opencart.Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    // 1. String Locators
    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchPageHeader = "div#content h1";
    private String myAccount = "//a[@title='My Account']";
    private String loginLink = "//a[text()='Login']";

    // 2. Page constructor:
    public HomePage(Page page){
        this.page = page;
    }

    // 3. Page actions/methods
    public String getHomePageTitle(){
        String title = page.title();
        System.out.println("Page title : "+title);
        return title;
    }

    public String getHomePageUrl(){
        String url= page.url();
        System.out.println("Page Url: "+url);
        return url;
    }

    public String doSearch(String ProductName){
        page.fill(search,ProductName);
        page.click(searchIcon);
        String searchHeader = page.textContent(searchPageHeader);
        System.out.println("Search Header : "+searchHeader);
        return searchHeader;
    }

    public LoginPage navigateToLoginPage(){
        page.click(myAccount);
        page.click(loginLink);
        return new LoginPage(page);  //Page Chaining
    }
}
