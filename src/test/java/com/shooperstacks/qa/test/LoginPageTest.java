package com.shooperstacks.qa.test;

import com.shoppersstacks.qa.base.TestBase;
import com.shoppersstacks.qa.pages.HomePage;
import com.shoppersstacks.qa.pages.LoginPage;
import com.shoppersstacks.qa.util.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.awt.*;
import java.io.IOException;

@Listeners(com.shoppersstacks.qa.util.ExtentReport.class)
public class LoginPageTest extends TestBase {
    TestUtil util;
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setUp() throws AWTException {
        initialization();
        String path="./src/main/java/com/shoppersstacks/qa/testdata/LoginCredentials.xlsx";
        util=new TestUtil(path);
        driver.get(prop.getProperty("url"));
        loginPage=new LoginPage();
    }


    @Test(priority = 1)
    public void verifyTheLoginPageTitle() throws InterruptedException {
        String actual=loginPage.loginButton();
        String expected="ShoppersStack | Login";
        Assert.assertEquals(actual,expected,"Title not matching");
    }


    @Test(priority = 2,enabled = false)
    public void verifyHideIcon() throws InterruptedException {
        Reporter.log("Verifying whether the HideIcon is working or not.",true);
        loginPage.loginButton();
        loginPage.password(prop.getProperty("password"));
        loginPage.hideIcon();
    }


    @DataProvider
    public Object[][] getData() throws IOException, InvalidFormatException {
        Object[][] datas=util.getCellDatas("Sheet1");
        return datas;
    }


    @Test(priority = 3,dataProvider = "getData")
    public void loginTest(String email,String password,String exp) throws InterruptedException {
        Reporter.log("Click on login button",true);
        loginPage.loginButton();
        Reporter.log("Enter a email",true);
        loginPage.registeredEmail(email);
        Reporter.log("Enter a password",true);
        loginPage.password(password);
        Reporter.log("Click on login button",true);
        homePage=loginPage.login();

        String expected="ShoppersStack | Home";
        if(exp.equals("Valid"))
        {
            Thread.sleep(1000);
            String actual=homePage.homePageTitle();
            if(expected.equals(actual)) {
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
        else if(exp.equals("invalid")){
            String actual=driver.getTitle();
            if(expected.equals(actual)){
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

    @Test(priority = 4)
    public void errorMessageValidation() throws InterruptedException {
        loginPage.loginButton();
        loginPage.registeredEmail(prop.getProperty("username"));
        loginPage.password(prop.getProperty("invalidPassword"));
        homePage=loginPage.login();
        String actual=loginPage.errorMessage();
        String expected="Given user ID or password is wrong";
        Assert.assertEquals(actual,expected);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
