package com.shooperstacks.qa.test;

import com.shoppersstacks.qa.base.TestBase;
import com.shoppersstacks.qa.pages.HomePage;
import com.shoppersstacks.qa.pages.LoginPage;
import jdk.jshell.spi.SPIResolutionException;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.*;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    public LoginPageTest() {
        super();
    }

    @BeforeClass
    public void setUp() throws AWTException {
        initialization();
        loginPage=new LoginPage();
    }
    @Test(priority = 1)
    public void verifyLoginPageTitle() throws InterruptedException {
        String actual=loginPage.loginButton();
        Thread.sleep(2000);
        String expected="ShoppersStack | Login";
        Assert.assertEquals(actual,expected,"Login page title is not matching");
    }
    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.registeredEmail(prop.getProperty("username"));
        Thread.sleep(2000);
        loginPage.password(prop.getProperty("password"));
        homePage=loginPage.login();
    }
    @Test(priority = 3)
    public void verifyHomePageTitle(){
        homePage.homePageTitle();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
