package com.automation.Listeners;

import com.automation.utils.AllureReportManager;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.ITestResult;

public class AllureListener extends AllureTestNg {
    @Override
    public void onTestFailure(ITestResult result) {
        AllureReportManager.takeScreenshot();
        AllureReportManager.addLog("Test got failed");
        super.onTestFailure(result);
    }
}
