package com.shoppersstacks.qa.util;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 10;
    public static long IMPLICITLY_WAIT = 10;

    public void switchToFrameIndex(int index){
        driver.switchTo().frame(index);
    }
    public void switchToFrameString(String value){
        driver.switchTo().frame(value);
    }
    public void switchToFrameWebElement(String element){
        driver.switchTo().frame(element);
    }

    public static void takeScreenShot() throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File temp = ts.getScreenshotAs(OutputType.FILE);
        File src=new File("./com.shoppersstaks.qa.errorshots");
        FileHandler.copy(temp,src);
    }
}
