package com.shooperstacks.qa.test;

import com.github.dockerjava.api.model.ContainerPort;
import com.shoppersstacks.qa.base.TestBase;
import com.shoppersstacks.qa.pages.*;
import jdk.jshell.spi.SPIResolutionException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class MyOrderPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ViewCartPage viewCartPage;
    SelectDeliveryAddressPage selectDeliveryAddressPage;
    AddAddressPage addAddressPage;
    PaymentPage paymentPage;
    OrderConfirmationPage orderConfirmationPage;
    MyOrdersPage myOrdersPage;


    public MyOrderPageTest() {
        super();
    }


    @BeforeClass
    public void setUp() throws AWTException{
        initialization();
        loginPage=new LoginPage();
    }


    @Test
    public void loginAsShopper() throws InterruptedException {
        String actual=loginPage.loginButton();
        Thread.sleep(2000);
        String expected="ShoppersStack | Login";
        softAssert.assertEquals(actual,expected,"Title not matching");

        Reporter.log("Verify login as user with valid credentials");
        loginPage.registeredEmail(prop.getProperty("username"));
        Thread.sleep(2000);
        loginPage.password(prop.getProperty("password"));
        homePage=loginPage.login();
    }


    @Test(dependsOnMethods = "loginAsShopper")
    public void addItemToCart() throws InterruptedException {
        Reporter.log("Choose the item from the electronics page add then click on add to cart button.");
        Thread.sleep(2000);
        String actual=homePage.homePageTitle();
        String expected="ShoppersStack | Home";
        softAssert.assertEquals(actual,expected,"Title not matching");
        try {
            Thread.sleep(2000);
            homePage.electronics();
            Thread.sleep(2000);
            homePage.mobile();
            homePage.item();
            homePage.addToCart();
            Thread.sleep(1000);
            homePage.homeButton();
            Thread.sleep(2000);
            viewCartPage = homePage.viewCart();
        }
        catch (WebDriverException e){
            String text=homePage.added();
            softAssert.assertEquals(text,"Added","Already item is added");
            homePage.homeButton();
            viewCartPage = homePage.viewCart();

        }
    }


    @Test(dependsOnMethods = "addItemToCart")
    public void buyTheItemFromViewCart() {
        Reporter.log("Click on cart option and then  click on BuyNow button. ");
        String actual = viewCartPage.viewCartPageTitle();
        String expected = "ShoppersStack | Cart";

        softAssert.assertEquals(actual, expected, "Title is not found");
        Reporter.log("Click on buy on button it will return the select delivery address page.");
        selectDeliveryAddressPage = viewCartPage.buyNow();
    }


    @Test(dependsOnMethods = "buyTheItemFromViewCart")
    public void addAddressInAddAddressPage() {
        String actual=selectDeliveryAddressPage.pageTitle();
        String expected="ShoppersStack | Home";
        softAssert.assertEquals(actual,expected,"Title is not found");

        addAddressPage=selectDeliveryAddressPage.addNewAddress();
        String name=prop.getProperty("name");
        String office=prop.getProperty("office");
        String street=prop.getProperty("street");
        String landmark=prop.getProperty("landmark");
        String  country= prop.getProperty("country");
        String state= prop.getProperty("state");
        String city= prop.getProperty("city");
        String pincode= prop.getProperty("pincode");
        String phoneNumber= prop.getProperty("phoneNumber");

        Reporter.log("Click AddAddress button,Address Page should be displayed Fill all the mandatory textfield.");
        addAddressPage.home();
        addAddressPage.name(name);
        addAddressPage.officeTextField(office);
        addAddressPage.streetTextFiled(street);
        addAddressPage.landmark(landmark);
        addAddressPage.countryDropDown(country);
        addAddressPage.stateDropDown(state);
        addAddressPage.cityDropDown(city);
        addAddressPage.pincode(pincode);
        addAddressPage.phoneNumber(phoneNumber);
        Reporter.log("then click on Add Adress button.Again select delivery address page should be displayed");
        selectDeliveryAddressPage=addAddressPage.addAddress();
    }


    @Test(dependsOnMethods = "addAddressInAddAddressPage")
    public void selectDeliveryAddress(){
        Reporter.log("Select added address from the select delivery address page.");
        selectDeliveryAddressPage.saveAddressAndCancelAdressPopUp();
        selectDeliveryAddressPage.addAddressRadioButton();
        paymentPage=selectDeliveryAddressPage.proceedButton();
    }


    @Test(dependsOnMethods = "selectDeliveryAddress")
    public void selectPaymentOption() throws InterruptedException {
        Reporter.log("Select the COD option from the payment page then click on proceed button.");
       try{
           paymentPage.saveAddressAndCancelAdressPopUp();
       }
       catch (Throwable e){
           System.out.println("Canceled");
       }
        Reporter.log("Click on COD Radio Button. and Click on the Proceed button");
        paymentPage.codRadioButton();
        orderConfirmationPage=paymentPage.proceedButton();
        orderConfirmationPage.createdPopUpCloseButton();
        Thread.sleep(2000);
        homePage=orderConfirmationPage.homeButton();
    }


    @Test(dependsOnMethods = "selectPaymentOption")
    public void cancelTheOrderProduct(){
        Reporter.log("Click on MyOrders button cancel the order.");
        Reporter.log("Click on invoice button invoice should be generated.");
        robot.delay(6000);
        Reporter.log("Click on account setting Icon");
        homePage.accountSettingIcon();
        Reporter.log("Click on MyOrders button.my order page will de displayed.");
        myOrdersPage=homePage.myOrders();
        Reporter.log("Generate the invoice report of login page");
        myOrdersPage.invoiceButton();
        Reporter.log("Click on cancel button and cancel the ordered item");
        myOrdersPage.cancelOrderButton();
        myOrdersPage.yesButton();
        myOrdersPage.homeButton();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
