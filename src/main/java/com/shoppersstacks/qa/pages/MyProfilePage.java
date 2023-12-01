package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MyProfilePage extends TestBase {
    @FindBy(xpath = "//li[text()='My Profile']")
    WebElement myProfile;
    @FindBy(xpath = "//button[contains(text(),'Edit')]")
    WebElement editProfile;
    @FindBy(id="First Name")
    WebElement firstName;
    @FindBy(id = "Last Name")
    WebElement lastName;
    @FindBy(xpath = "//label[text()='Date of Birth']")
    WebElement date;
    @FindBy(id="Phone Number")
    WebElement phoneNumber;
    @FindBy (id="Country")
    WebElement Country;
    @FindBy(id="State")
    WebElement State;
    @FindBy(id="City")
    WebElement City;
    @FindBy(id = "submit")
    WebElement submitButton;
    @FindBy(xpath = "//h2[text()='Edit Profile ']")
    WebElement Title;
    public String popUpTitle(){
        return Title.getText();
    }
    public void myProfile(){
        myProfile.click();
    }
    public void editProfile(){
        editProfile.click();
    }
    public void firstName(String fname){
        firstName.sendKeys(fname);
    }
    public void lastName(String lname){
        lastName.sendKeys(lname);
    }
    public void date(String d){
        date.sendKeys(d);
    }
    public void phoneNumber(String number){
        phoneNumber.sendKeys(number);
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
    public void submit(){
        submitButton.submit();
    }

}
