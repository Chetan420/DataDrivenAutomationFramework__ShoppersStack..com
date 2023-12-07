package com.shoppersstacks.qa.base;

import com.beust.jcommander.Parameter;
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
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
    public static Random random;
    public TestBase(){
        try{
            prop=new Properties();
            FileInputStream input=new FileInputStream("C:\\Users\\cheta\\IdeaProjects\\ShoppersStack\\" +
                    "src\\main\\java\\com\\shoppersstacks\\qa\\configure\\config.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initialization() throws AWTException {
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            driver=new ChromeDriver();
        }
        else if (browserName.equals("FireFox")) {
            driver=new FirefoxDriver();
        }
        else if(browserName.equals("edge")){
            driver=new EdgeDriver();
        }
        else if (browserName.equals("safari")) {
            driver=new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
        driver.get(prop.getProperty("url"));
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        Actions action=new Actions(driver);
        robot=new Robot();
        ts=(TakesScreenshot)driver;
        random=new Random();

        js=(JavascriptExecutor)driver;

        softAssert=new SoftAssert();

        efirire = new EventFiringWebDriver(driver);
        eventListner = new WebEventListner();
        efirire.register(eventListner);
        driver=efirire;
    }
}
