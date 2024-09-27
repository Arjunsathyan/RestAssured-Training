package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    @FindBy(xpath ="//span[@class='search-mobile']")
    WebElement searchButton;

    @FindBy(xpath ="//button")
    WebElement searchClick;

    @FindBy(xpath ="//h1[text()='Mens Shirts']")
    WebElement productsHead;
    public void enterDetails()
    {
        searchButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement input=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-toggle display']//input")));
        input.sendKeys(ConfigReader.getConfigValue("product.name"));
    }

    public void clickOnSearchButton()
    {
        searchClick.click();
    }

    public boolean verifyItemIsDisplayed()
    {
        System.out.println(productsHead.getText());
        return productsHead.getText().contains(ConfigReader.getConfigValue("product.name"));
    }

}
