package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyProfilePage extends TestBase {
    @FindBy(xpath = "//li[text()='My Profile']")
    private WebElement myProfile;
    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    private WebElement editProfile;
    @FindBy(id="First Name")
    private WebElement firstName;
    @FindBy(id = "Last Name")
    private WebElement lastName;
    @FindBy(xpath = "//label[text()='Date of Birth']")
    private WebElement date;
    @FindBy(id="Phone Number")
    private WebElement phoneNumber;
    @FindBy (id="Country")
    private WebElement Country;
    @FindBy(id="State")
    private WebElement State;
    @FindBy(id="City")
    private WebElement City;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//h2[text()='Edit Profile ']")
    private WebElement Title;

    public WebElement getMyProfile() {
        return myProfile;
    }

    public WebElement getEditProfile() {
        return editProfile;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getDate() {
        return date;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
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

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getTitle() {
        return Title;
    }

    public String popUpTitle(){
        return getTitle().getText();
    }
    public void myProfile(){
        getMyProfile().click();
    }
    public void editProfile(){
        getEditProfile().click();
    }
    public void firstName(String fname){
        getFirstName().sendKeys(fname);
    }
    public void lastName(String lname){
        getLastName().sendKeys(lname);
    }
    public void date(String d){
        getDate().sendKeys(d);
    }
    public void phoneNumber(String number){
        getPhoneNumber().sendKeys(number);
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
    public void submit(){
        getSubmitButton().submit();
    }

}
