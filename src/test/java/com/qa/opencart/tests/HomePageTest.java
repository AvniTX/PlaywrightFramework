package com.qa.opencart.tests;

import com.qa.opencart.Constants.AppsConstant;
import com.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void homePageTitleTest(){
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppsConstant.HOME_PAGE_TITLE);
    }
    @Test
    public void homePageUrlTest(){
        String actualUrl = homePage.getHomePageUrl();
        Assert.assertEquals(actualUrl,prop.getProperty("url"));
    }

    @DataProvider
    public Object[][] getProductData(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getProductData")
    public void searchByDataProvider(String ProductName){  //This TC will run 3 times for each product name
        String actualSearchHeader = homePage.doSearch(ProductName);
        Assert.assertEquals(actualSearchHeader,"Search - "+ProductName);
    }
    @Test
    public void search(){
        String actualSearchHeader = homePage.doSearch("macbook");
        Assert.assertEquals(actualSearchHeader,"Search - macbook");
    }

}
