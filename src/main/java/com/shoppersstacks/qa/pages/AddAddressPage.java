package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AddAddressPage extends TestBase {
    @FindBy(partialLinkText = "Add New Address")
    private WebElement addNewAddressButton;
    @FindBy(id="Home")
    private WebElement homeRadioButton;
    @FindBy(id="Office")
    private WebElement officeRadioButton;
    @FindBy(id="Other")
    private WebElement otherRadioButton;
    @FindBy(name = "Name")
    private WebElement name;
    @FindBy(id="House/Office Info")
    private WebElement officeInfoTextField;
    @FindBy(id="Street Info")
    private WebElement streetInfo;
    @FindBy(id="Landmark")
    private WebElement landmark;
    @FindBy(id="Pincode")
    private WebElement pincode;
    @FindBy (id="Country")
    private WebElement Country;
    @FindBy(id="State")
    private WebElement State;
    @FindBy(id="City")
    private WebElement City;
    @FindBy(id="Phone Number")
    private WebElement phoneNumber;
    @FindBy(id="addAddress")
    private WebElement addAddress;
    @FindBy(xpath="//*[name()='svg' and @data-testid='InfoIcon']")
    private WebElement pincodeInfo;
    @FindBy(xpath = "//*[name()='svg' and @data-testid='CloseRoundedIcon']")
    private WebElement addressCancel;

    public WebElement getAddNewAddressButton() {
        return addNewAddressButton;
    }

    public WebElement getHomeRadioButton() {
        return homeRadioButton;
    }

    public WebElement getOfficeRadioButton() {
        return officeRadioButton;
    }

    public WebElement getOtherRadioButton() {
        return otherRadioButton;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getOfficeInfoTextField() {
        return officeInfoTextField;
    }

    public WebElement getStreetInfo() {
        return streetInfo;
    }

    public WebElement getLandmark() {
        return landmark;
    }

    public WebElement getPincode() {
        return pincode;
    }

    public WebElement getCountry() {
        return Country;
    }

    public WebElement getState() {
        return State;
    }

    public WebElement getCity() {
        return City;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getAddAddress() {
        return addAddress;
    }

    public WebElement getPincodeInfo() {
        return pincodeInfo;
    }

    public WebElement getAddressCancel() {
        return addressCancel;
    }

    public WebElement getAddAddressButton() {
        return addAddressButton;
    }

    @FindBy(id="addAddress")
    private WebElement addAddressButton;

    public AddAddressPage(){
        PageFactory.initElements(driver,this);
    }
    public String addAddressPageTitle(){
        return driver.getTitle();
    }
    public void home() {
        getHomeRadioButton().click();
    }
    public void office() {
        getOfficeRadioButton().click();
    }
    public void other() {
        getOtherRadioButton().click();
    }
    public void name(String names){
        getName().sendKeys(names);
    }
    public void officeTextField(String office){
        getOfficeInfoTextField().sendKeys(office);
    }
    public void streetTextFiled(String street){
        getStreetInfo().sendKeys(street);
    }
    public void landmark(String lndmark){
        getLandmark().sendKeys(lndmark);
    }
    public void countryDropDown(String value){
        dropDownHandling(getCountry(),value);
    }
    public void stateDropDown(String value){
        dropDownHandling(getState(),value);
    }
    public void cityDropDown(String value){
        dropDownHandling(getCity(),value);
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
        getPincode().sendKeys(pin);
    }
    public void pincodeInfo(){
        getPincodeInfo().click();
    }
    public void phoneNumber (String pno){
        getPhoneNumber().sendKeys(pno);
    }
    public SelectDeliveryAddressPage addAddress(){
        getAddAddressButton().click();
        return new SelectDeliveryAddressPage();
    }
    public void addAddressCancel(){
        getAddressCancel().click();
    }

}