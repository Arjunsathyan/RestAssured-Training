package com.automation.tests;

import com.automation.pages.HomePage;
import com.automation.pages.SearchPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    SearchPage searchPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp()
    {

        ConfigReader.initConfig();
        DriverManager.createWebDriver();
        homePage=new HomePage();
        searchPage=new SearchPage();

    }

    @AfterMethod
    public void cleanUp()
    {
        //DriverManager.getDriver().quit();
    }
}
