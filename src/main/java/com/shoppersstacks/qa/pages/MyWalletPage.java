package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class MyWalletPage extends TestBase {
    @FindBy(xpath = "//button[text()='Add Money']")
    WebElement addMoneyButton;
    @FindBy(xpath = "//button[text()='Use Coupon']")
    WebElement useCouponButton;
    @FindBy(xpath = "//button[text()='View Transactions']")
    WebElement viewTransactionButton;
    @FindBy(id = "Coupon Code")
    WebElement couponCode;
    @FindBy(id = "Verify")
    WebElement verifyButton;
    @FindBy(linkText = "Home")
    WebElement homeButton;
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
