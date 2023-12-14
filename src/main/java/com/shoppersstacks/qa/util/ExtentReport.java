package com.shoppersstacks.qa.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport extends TestListenerAdapter {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    public void onStart(ITestContext testContext) {
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
        String repName="TestReport-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter("./TestOutput/"+repName);
        try {
            sparkReporter.loadXMLConfig("C:\\Users\\cheta\\IdeaProjects\\ShoppersStack\\src\\extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Host Name","LocalHost");
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("user","Chethan");

        sparkReporter.config().setDocumentTitle("ShoppersStack Test Project");
        sparkReporter.config().setReportName("End To End Report");
        sparkReporter.config().setTheme(Theme.DARK);
    }

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

    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }
}
