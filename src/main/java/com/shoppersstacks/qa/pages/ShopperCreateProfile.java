package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ShopperCreateProfile extends TestBase {
    @FindBy(id = "signIn")
    private WebElement signIn;
    @FindBy(id = "First Name")
    private WebElement firstName;
    @FindBy(id="Last Name")
    private WebElement lastName;
    @FindBy(id = "Male")
    private WebElement maleRadioButton;
    @FindBy(id="Female")
    private WebElement femaleRdioButton;
    @FindBy(id="Other")
    private WebElement otherRadioButton;
    @FindBy(id = "Phone Number")
    private WebElement phoneNumber;
    @FindBy(id = "Email Address")
    private WebElement emailAdress;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(id="Confirm Password")
    private WebElement confirmPassword;
    @FindBy(id = "Terms and Conditions")
    private WebElement termsAndCon;
    @FindBy(className = "input[class='PrivateSwitchBase-input css-1m9pwf3']")
    private WebElement IagreeTermsCon;
    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase')])[4]")
    private WebElement agreeButton;
    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase')])[3]")
    private WebElement cancelButton;
    @FindBy(css = "svg[data-testid='ClearIcon']")
    private WebElement cancelIcon;
    @FindBy(id = "scroll-dialog-title")
    private WebElement popUpText;
    @FindBy(xpath = "//h1[text()='Create Your Profile']")
    private WebElement createYourProfile;
    @FindBy(id = "First Name-helper-text")
    private WebElement firstnameError;
    @FindBy(id = "Last Name-helper-text")
    private WebElement lastNameError;
    @FindBy(id = "Phone Number-helper-text")
    private WebElement phoneNumberError;
    @FindBy(id="Email Address-helper-text")
    private WebElement emailError;
    @FindBy(id = "password-error")
    private WebElement passError;
    @FindBy(id = "cnfPassword-error")
    private WebElement conPassError;
    @FindBy(id="Register")
    private WebElement register;

    public WebElement getSignIn() {
        return signIn;
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getFemaleRdioButton() {
        return femaleRdioButton;
    }

    public WebElement getOtherRadioButton() {
        return otherRadioButton;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getEmailAdress() {
        return emailAdress;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getTermsAndCon() {
        return termsAndCon;
    }

    public WebElement getIagreeTermsCon() {
        return IagreeTermsCon;
    }

    public WebElement getAgreeButton() {
        return agreeButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getCancelIcon() {
        return cancelIcon;
    }

    public WebElement getPopUpText() {
        return popUpText;
    }

    public WebElement getCreateYourProfile() {
        return createYourProfile;
    }

    public WebElement getFirstnameError() {
        return firstnameError;
    }

    public WebElement getLastNameError() {
        return lastNameError;
    }

    public WebElement getPhoneNumberError() {
        return phoneNumberError;
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getPassError() {
        return passError;
    }

    public WebElement getConPassError() {
        return conPassError;
    }

    public WebElement getRegister() {
        return register;
    }



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
        Reporter.log(popUpText.getText());
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
            return getCreateYourProfile().getText();
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
