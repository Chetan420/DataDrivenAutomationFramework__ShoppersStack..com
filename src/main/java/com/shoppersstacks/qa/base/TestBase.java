package com.shoppersstacks.qa.base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.shoppersstacks.qa.pages.LoginPage;
import com.shoppersstacks.qa.util.TestUtil;
import com.shoppersstacks.qa.util.WebEventListner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Properties prop;
    public static SoftAssert softAssert;
    public static EventFiringWebDriver efirire;
    public static WebEventListner eventListner;
    public static Actions action;
    public static Robot robot;
    public static TakesScreenshot ts;
    public static JavascriptExecutor js;
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public TestBase(){
        try{
            prop=new Properties();
            FileInputStream input=new FileInputStream("C:\\Users\\cheta\\IdeaProjects\\ShoppersStack\\src\\main\\java\\com\\shoppersstacks\\qa\\configure\\config.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeSuite
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

    public static void initialization() throws AWTException {
        String browserName=prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            Reporter.log("Browser is not matching...");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
        driver.get(prop.getProperty("url"));
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Actions action=new Actions(driver);
        robot=new Robot();
        ts=(TakesScreenshot)driver;

        js=(JavascriptExecutor)driver;

        softAssert=new SoftAssert();

        efirire = new EventFiringWebDriver(driver);
        eventListner = new WebEventListner();
        efirire.register(eventListner);
        driver=efirire;
    }

    @AfterSuite
    public void onFinish(ITestContext testContext) {
        extentReports.flush();
    }

}
