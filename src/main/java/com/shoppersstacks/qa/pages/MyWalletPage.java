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
        addMoneyButton.click();
    }
    public void useCouponCode(){
        useCouponButton.click();
    }
    public void viewTransaction(){
        viewTransactionButton.click();
    }
    public void couponCode(String coupon){
        couponCode.sendKeys(coupon);
    }
    public void verifyButton(){
        verifyButton.click();
    }
    public HomePage home(){
        homeButton.click();
        return new HomePage();
    }
}
