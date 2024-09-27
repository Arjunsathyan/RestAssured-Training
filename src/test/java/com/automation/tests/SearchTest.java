package com.automation.tests;

import com.automation.pages.SearchPage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test
    public void searchFunction()
    {

        homePage.openWebsite();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        searchPage.enterDetails();
        searchPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.verifyItemIsDisplayed());
    }

}
