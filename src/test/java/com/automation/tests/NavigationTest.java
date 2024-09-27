package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest{

    @Test
    public void navigationTest()
    {
        homePage.openWebsite();
        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.clickOnItem();
        Assert.assertTrue(homePage.isTitleCorrect());

    }
}
