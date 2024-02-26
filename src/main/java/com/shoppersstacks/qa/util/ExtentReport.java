package com.shoppersstacks.qa.util;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.shoppersstacks.qa.base.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport extends TestBase implements ITestListener {
    public ExtentTest extentTest;

    public void onTestSuccess(ITestResult tr){
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult tr){
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
    }

    public void onTestSkipped(ITestResult tr){
        extentTest=extentReports.createTest(tr.getName());
        extentTest.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }
}
