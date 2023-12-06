package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class MyWalletPage extends TestBase {
    @FindBy(xpath = "//button[text()='Add Money']")
    private WebElement addMoneyButton;
    @FindBy(xpath = "//button[text()='Use Coupon']")
    private WebElement useCouponButton;
    @FindBy(xpath = "//button[text()='View Transactions']")
    private WebElement viewTransactionButton;
    @FindBy(id = "Coupon Code")
    private WebElement couponCode;
    @FindBy(id = "Verify")
    private WebElement verifyButton;
    @FindBy(linkText = "Home")
    private WebElement homeButton;

    public WebElement getAddMoneyButton() {
        return addMoneyButton;
    }

    public WebElement getUseCouponButton() {
        return useCouponButton;
    }

    public WebElement getViewTransactionButton() {
        return viewTransactionButton;
    }

    public WebElement getCouponCode() {
        return couponCode;
    }

    public WebElement getVerifyButton() {
        return verifyButton;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public void addMoney(){
        getAddMoneyButton().click();
    }
    public void useCouponCode(){
        getUseCouponButton().click();
    }
    public void viewTransaction(){
        getViewTransactionButton().click();
    }
    public void couponCode(String coupon){
        getCouponCode().sendKeys(coupon);
    }
    public void verifyButton(){
        getVerifyButton().click();
    }
    public HomePage home(){
        getHomeButton().click();
        return new HomePage();
    }
}
