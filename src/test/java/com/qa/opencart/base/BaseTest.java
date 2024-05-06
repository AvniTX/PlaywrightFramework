package com.qa.opencart.base;

import com.microsoft.playwright.Page;
import com.qa.opencart.Pages.HomePage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected Properties prop;

    @BeforeTest
    public void setup(){
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
