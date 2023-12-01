package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SelectDeliveryAddressPage extends TestBase {
    @FindBy(xpath = "//h3[text()='Select a delivery address']")
    WebElement addressText;
    @FindBy(partialLinkText = "Add New Address")
    WebElement addNewAddress;
    @FindBy(xpath = "(//input[@name='address'])[1]")
    WebElement addAdressRadioButton;
    @FindBy(xpath = "//button[text()='Proceed']")
    WebElement proceedButton;
    public SelectDeliveryAddressPage(){
        PageFactory.initElements(driver,this);
    }
    public String pageTitle(){
        try{
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
        }
        return driver.getTitle();
    }
    public void addAddressRadioButton() {
        addAdressRadioButton.click();
    }
    public AddAddressPage addNewAddress() {
        addNewAddress.click();
        return new AddAddressPage();
    }
    public void saveAddressAndCancelAdressPopUp() {
        robot.delay(1000);
        robot.mouseMove(1350,400);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public PaymentPage proceedButton(){
        proceedButton.click();
        return new PaymentPage();
    }
}
