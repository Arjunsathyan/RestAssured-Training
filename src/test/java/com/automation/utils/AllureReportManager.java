package com.automation.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureReportManager {

    @Attachment(type = "image/png",value="screenshot")
    public static byte[] takeScreenshot(){
        TakesScreenshot tc = (TakesScreenshot) DriverManager.getDriver();
        byte[] ss =  tc.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("screenshot", new ByteArrayInputStream(ss));
        return ss;
    }

    public static void addLog(String msg){
        Allure.addAttachment("Log", msg);
    }
}