package com.shooperstacks.qa.test;

import com.shoppersstacks.qa.base.TestBase;
import com.shoppersstacks.qa.pages.*;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.awt.*;

@Listeners
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
        Thread.sleep(2000);
        String actual=homePage.homePageTitle();
        String expected="ShoppersStack | Home";
        softAssert.assertEquals(actual,expected,"Title not matching");
        try {
            Thread.sleep(2000);
            Reporter.log("Choose the electronics from the menu bar",true);
            homePage.electronics();
            Thread.sleep(2000);
            Reporter.log("Click the mobile option from the list",true);
            homePage.mobile();
            Reporter.log("Click any one mobile from the mobile page",true);
            homePage.item();
            Reporter.log("Clicking add to cart button so item should be added on the Cart.",true);
            homePage.addToCart();
            Thread.sleep(1000);
            homePage.homeButton();
            Thread.sleep(2000);
            Reporter.log("Verifying the item is added or not in cart",true);
            viewCartPage = homePage.viewCart();
        }
        catch (WebDriverException e){
            Reporter.log("Already item is added on the cart.",true);
            String text=homePage.added();
            softAssert.assertEquals(text,"Added","Already item is added");
            homePage.homeButton();
            viewCartPage = homePage.viewCart();

        }
    }


    @Test(dependsOnMethods = "addItemToCart")
    public void buyTheItemFromViewCart() {
        Reporter.log("Click cart Icon for buying the added item",true);
        String actual = viewCartPage.viewCartPageTitle();
        String expected = "ShoppersStack | Cart";

        softAssert.assertEquals(actual, expected, "Title is not found");
        Reporter.log("Click on BuyNow button on added item.",true);
        selectDeliveryAddressPage = viewCartPage.buyNow();
    }


    @Test(dependsOnMethods = "buyTheItemFromViewCart")
    public void addAddressInAddAddressPage() {
        String actual=selectDeliveryAddressPage.pageTitle();
        String expected="ShoppersStack | Home";
        softAssert.assertEquals(actual,expected,"Title is not found");

        Reporter.log("Click on AddNewAddress Button for adding new address.",true);
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

        Reporter.log("Enter valid details on all the mandatory textfield.",true);
        addAddressPage.office();
        addAddressPage.name(name);
        addAddressPage.officeTextField(office);
        addAddressPage.streetTextFiled(street);
        addAddressPage.landmark(landmark);
        addAddressPage.countryDropDown(country);
        addAddressPage.stateDropDown(state);
        addAddressPage.cityDropDown(city);
        addAddressPage.pincode(pincode);
        addAddressPage.phoneNumber(phoneNumber);
        Reporter.log("Click on Add Address button to save the address.",true);
        selectDeliveryAddressPage=addAddressPage.addAddress();
    }


    @Test(dependsOnMethods = "addAddressInAddAddressPage")
    public void selectDeliveryAddress(){
        selectDeliveryAddressPage.saveAddressAndCancelAdressPopUp();
        Reporter.log("Select added address from the select delivery address page.",true);
        selectDeliveryAddressPage.addAddressRadioButton();
        paymentPage=selectDeliveryAddressPage.proceedButton();
    }


    @Test(dependsOnMethods = "selectDeliveryAddress")
    public void selectPaymentOption() throws InterruptedException {
       try{
           paymentPage.saveAddressAndCancelAdressPopUp();
       }
       catch (Throwable e){
           System.out.println("Canceled");
       }
        Reporter.log("Select Cash and Delivery Radio Button for payment",true);
        paymentPage.codRadioButton();
        orderConfirmationPage=paymentPage.proceedButton();
        Reporter.log("Click proceed button for order confirmation.",true);
        orderConfirmationPage.createdPopUpCloseButton();
        Thread.sleep(2000);
        homePage=orderConfirmationPage.homeButton();
    }


    @Test(dependsOnMethods = "selectPaymentOption")
    public void cancelTheOrderProduct(){
        robot.delay(6000);
        Reporter.log("Click account setting Icon",true);
        homePage.accountSettingIcon();
        Reporter.log("Click on MyOrders button from account.my order page will de displayed.",true);
        myOrdersPage=homePage.myOrders();
        Reporter.log("Cancel the ordered Item",true);
        myOrdersPage.cancelOrderButton();
        myOrdersPage.yesButton();
        Reporter.log("Generate the invoice report of ordered ite,",true);
        myOrdersPage.invoiceButton();
        homePage=myOrdersPage.homeButton();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
