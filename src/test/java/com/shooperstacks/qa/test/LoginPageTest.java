package com.shooperstacks.qa.test;

import com.aventstack.extentreports.model.Report;
import com.shoppersstacks.qa.base.TestBase;
import com.shoppersstacks.qa.pages.HomePage;
import com.shoppersstacks.qa.pages.LoginPage;
import com.shoppersstacks.qa.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

public class LoginPageTest extends TestBase {
    TestUtil util;
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest() {
        super();
    }

    @BeforeClass
    public void setUp() throws AWTException {
        initialization();
        String path="./src/main/java/com/shoppersstacks/qa/configure/LoginCredentials.xlsx";
        util=new TestUtil(path);
        loginPage=new LoginPage();
    }


    @Test(dataProvider = "getData")
    public void loginTest(String email,String password,String expected) throws InterruptedException {
        Reporter.log("Enter valid url",true);
        driver.get(prop.getProperty("url"));
        Reporter.log("Click on login button",true);
        loginPage.loginButton();
        Reporter.log("Enter a email",true);
        loginPage.registeredEmail(email);
        Reporter.log("Enter a password",true);
        loginPage.password(password);
        Reporter.log("Click on login button",true);
        homePage=loginPage.login();

        String exp="ShoppersStack | Home";
        String actual=driver.getTitle();
        if(expected.equals("valid"))
        {
            if(exp.equals(actual)) {
                homePage.accountSettingIcon();
                homePage.logout();
                Reporter.log("Login Success",true);
                Assert.assertTrue(true);
            }
            else {
                Reporter.log(loginPage.errorMessage(),true);
                Assert.assertTrue(false);
            }
        }
        else if(expected.equals("invalid")){
            if(exp.equals(actual)){
                homePage.accountSettingIcon();
                homePage.logout();
                Assert.assertTrue(false);
            }
            else {
                Reporter.log(loginPage.errorMessage(),true);
                Assert.assertTrue(true);
            }
        }
    }


    @DataProvider
    public Object[][] getData() throws IOException, InvalidFormatException {
        Object datas[][]=util.getCellDatas("Sheet1");
        return datas;
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
