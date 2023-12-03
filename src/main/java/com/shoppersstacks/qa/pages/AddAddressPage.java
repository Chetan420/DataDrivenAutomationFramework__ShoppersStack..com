package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AddAddressPage extends TestBase {
    @FindBy(partialLinkText = "Add New Address")
    WebElement addNewAddressButton;
    @FindBy(id="Home")
    WebElement homeRadioButton;
    @FindBy(id="Office")
    WebElement officeRadioButton;
    @FindBy(id="Other")
    WebElement otherRadioButton;
    @FindBy(name = "Name")
    WebElement name;
    @FindBy(id="House/Office Info")
    WebElement officeInfoTextField;
    @FindBy(id="Street Info")
    WebElement streetInfo;
    @FindBy(id="Landmark")
    WebElement landmark;
    @FindBy(id="Pincode")
    WebElement pincode;
    @FindBy (id="Country")
    WebElement Country;
    @FindBy(id="State")
    WebElement State;
    @FindBy(id="City")
    WebElement City;
    @FindBy(id="Phone Number")
    WebElement phoneNumber;
    @FindBy(id="addAddress")
    WebElement addAddress;
    @FindBy(xpath="//*[name()='svg' and @data-testid='InfoIcon']")
    WebElement pincodeInfo;
    @FindBy(xpath = "//*[name()='svg' and @data-testid='CloseRoundedIcon']")
    WebElement addressCancel;
    @FindBy(id="addAddress")
    WebElement addAddressButton;
    public AddAddressPage(){
        PageFactory.initElements(driver,this);
    }
    public String addAddressPageTitle(){
        return driver.getTitle();
    }
    public void home() {
        homeRadioButton.click();
    }
    public void office() {
        officeRadioButton.click();
    }
    public void other() {
        otherRadioButton.click();
    }
    public void name(String names){
        name.sendKeys(names);
    }
    public void officeTextField(String office){
        officeInfoTextField.sendKeys(office);
    }
    public void streetTextFiled(String street){
        streetInfo.sendKeys(street);
    }
    public void landmark(String lndmark){
        landmark.sendKeys(lndmark);
    }
    public void countryDropDown(String value){
        dropDownHandling(Country,value);
    }
    public void stateDropDown(String value){
        dropDownHandling(State,value);
    }
    public void cityDropDown(String value){
        dropDownHandling(City,value);
    }
    public void dropDownHandling(WebElement element,String value){
        Select dropDown=new Select(element);
        List<WebElement> options=dropDown.getOptions();
        for (WebElement option : options){
            if(option.getText().equals(value)){
                option.click();
            }
        }
    }

    public void pincode(String pin)
    {
        pincode.sendKeys(pin);
    }
    public void pincodeInfo(){
        pincodeInfo.click();
    }
    public void phoneNumber (String pno){
        phoneNumber.sendKeys(pno);
    }
    public SelectDeliveryAddressPage addAddress(){
        addAddressButton.click();
        return new SelectDeliveryAddressPage();
    }
    public void addAddressCancel(){
        addressCancel.click();
    }

}