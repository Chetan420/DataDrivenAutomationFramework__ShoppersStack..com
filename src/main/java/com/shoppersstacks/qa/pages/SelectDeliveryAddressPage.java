package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SelectDeliveryAddressPage extends TestBase {
    @FindBy(xpath = "//h3[text()='Select a delivery address']")
    private WebElement addressText;
    @FindBy(partialLinkText = "Add New Address")
    private WebElement addNewAddress;
    @FindBy(xpath = "(//input[@name='address'])[1]")
    private WebElement addAdressRadioButton;
    @FindBy(xpath = "//button[text()='Proceed']")
    private WebElement proceedButton;

    public WebElement getAddressText() {
        return addressText;
    }

    public WebElement getAddNewAddress() {
        return addNewAddress;
    }

    public WebElement getAddAdressRadioButton() {
        return addAdressRadioButton;
    }

    public WebElement getProceedButton() {
        return proceedButton;
    }


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
        getAddAdressRadioButton().click();
    }
    public AddAddressPage addNewAddress() {
        getAddNewAddress().click();
        return new AddAddressPage();
    }
    public void saveAddressAndCancelAdressPopUp() {
        robot.delay(1000);
        robot.mouseMove(1350,400);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public PaymentPage proceedButton(){
        getProceedButton().click();
        return new PaymentPage();
    }
}
