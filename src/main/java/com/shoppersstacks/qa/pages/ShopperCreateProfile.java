package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopperCreateProfile extends TestBase {
    @FindBy(id = "signIn")
    WebElement signIn;
    @FindBy(id = "First Name")
    WebElement firstName;
    @FindBy(id="Last Name")
    WebElement lastName;
    @FindBy(id = "Male")
    WebElement maleRadioButton;
    @FindBy(id="Female")
    WebElement femaleRdioButton;
    @FindBy(id="Other")
    WebElement otherRadioButton;
    @FindBy(id = "Phone Number")
    WebElement phoneNumber;
    @FindBy(id = "Email Address")
    WebElement emailAdress;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id="Confirm Password")
    WebElement confirmPassword;
    @FindBy(id = "Terms and Conditions")
    WebElement termsAndCon;
    @FindBy(className = "input[class='PrivateSwitchBase-input css-1m9pwf3']")
    WebElement IagreeTermsCon;
    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase')])[4]")
    WebElement agreeButton;
    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase')])[3]")
    WebElement cancelButton;
    @FindBy(css = "svg[data-testid='ClearIcon']")
    WebElement cancelIcon;
    @FindBy(id = "scroll-dialog-title")
    WebElement popUpText;
    @FindBy(xpath = "//h1[text()='Create Your Profile']")
    WebElement createYourProfile;
    @FindBy(id = "First Name-helper-text")
    WebElement firstnameError;
    @FindBy(id = "Last Name-helper-text")
    WebElement lastNameError;
    @FindBy(id = "Phone Number-helper-text")
    WebElement phoneNumberError;
    @FindBy(id="Email Address-helper-text")
    WebElement emailError;
    @FindBy(id = "password-error")
    WebElement passError;
    @FindBy(id = "cnfPassword-error")
    WebElement conPassError;
    @FindBy(id="Register")
    WebElement register;
    public ShopperCreateProfile(){
        PageFactory.initElements(driver,this);
    }
    public void firstName(String FirstName)
    {
        firstName.sendKeys(FirstName);
    }
    public void lastName(String LastName)
    {
        lastName.sendKeys(LastName);
    }
    public void maleRadioButton()
    {
        maleRadioButton.click();
    }
    public void femaleRadioButton()
    {
        femaleRdioButton.click();
    }
    public void otherRadioButton()
    {
        otherRadioButton.click();
    }
    public void phoneNumber(String PhoneNumber)
    {
        phoneNumber.sendKeys(PhoneNumber);
    }
    public void emailAddress(String Email)
    {
        emailAdress.sendKeys(Email);
    }
    public void password(String Password)
    {
        password.sendKeys(Password);
    }
    public void confirmPassword(String Password)
    {
        confirmPassword.sendKeys(Password);
    }
    public void termsAndCondition()
    {
        termsAndCon.click();
    }
    public void iAgreeTermsAndCon()
    {
        IagreeTermsCon.click();
    }
    public void agreeButton()
    {
        agreeButton.click();
    }
    public void cancelButton()
    {
        cancelButton.click();
    }
    public void cancelIcon()
    {
        cancelIcon.click();
    }
    public void popupText()
    {
        System.out.println(popUpText.getText());
    }
    public void signIn()
    {
        signIn.click();
    }
    public String createYourProfile()
    {
        String expectedText="Create Your Profile";
        if(createYourProfile.getText().equals(expectedText))
        {
            return createYourProfile.getText();
        }
        else
        {
            return "Expected text is Not Found...";
        }
    }
    public String firstNameError()
    {
       return firstnameError.getText();
    }
    public String lastNameError()
    {
        return lastNameError.getText();
    }
    public String phoneNumberError()
    {
        return phoneNumberError.getText();
    }
    public String emailAddressError()
    {
        return emailError.getText();
    }
    public String passwordError()
    {
        return passError.getText();
    }
    public String confirmPasswordError()
    {
        return conPassError.getText();
    }
    public LoginPage registerButton(){
        register.click();
        return new LoginPage();
    }

}
