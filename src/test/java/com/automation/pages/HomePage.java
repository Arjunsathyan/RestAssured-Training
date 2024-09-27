package com.automation.pages;

import com.automation.tests.BaseTest;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//figure")
    WebElement logo;

    @FindBy(xpath = "//a[text()='Men']")
    WebElement headerItem;

    @FindBy(tagName ="h1")
    WebElement headingName;
    
    public void openWebsite()
    {

        driver.get("https://www.beyoung.in/");
    }

    public boolean isHomePageDisplayed()
    {
        return logo.isDisplayed();
    }

    public void clickOnItem()
    {


        headerItem.click();
    }

    public boolean isTitleCorrect()
    {
        return headingName.getText().equalsIgnoreCase(ConfigReader.getConfigValue("page.title"));

    }





}
