package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends TestBase {

    //Page Factory or Object Repository
    @FindBy(xpath = "//div[text()='Successfully Registered']")
    WebElement registrationMsg;
    @FindBy(xpath = "//button[@type='button' and @id='vertical-tab-0']")
    WebElement shopperLogin;
    @FindBy(xpath = "//button[@type='button' and @id='vertical-tab-1']")
    WebElement merchantLogin;
    @FindBy(xpath = "//button[@type='button' and @id='vertical-tab-2']")
    WebElement adminLogin;
    @FindBy (id="loginBtn")
    WebElement loginButton;
    @FindBy(id="Email")
    WebElement emailTextField;
    @FindBy(id="Password")
    WebElement passwordTextField;
    @FindBy(xpath = "//button[@type='button' and @aria-label='toggle password visibility']")
    WebElement hideButton;
    @FindBy(id = "Login")
    WebElement loginClickButton;
    @FindBy(id = "Forgot Password?")
    WebElement forgetPassword;
    @FindBy(id="email")
    WebElement forgetPassEmail;
    @FindBy(css = "button[type='button']")
    WebElement proceedButton;
    @FindBy(id = "Create Account")
    WebElement createAccount;
    @FindBy(id="email-helper-text")
    WebElement forgetEmailError;
    @FindBy(xpath = "//div[contains(text(),'Given user ID')]")
    WebElement error;

    String ButtonColor="background";

    //Initializing the Page Objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public String msg(){
        return registrationMsg.getText();
    }

    public String  loginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
        Thread.sleep(2000);
        return driver.getTitle();
    }
    public void registeredEmail(String username){
        emailTextField.sendKeys(username);
    }
    public void password(String password){
        passwordTextField.sendKeys(password);
    }
    public void hideIcon()
    {
        hideButton.click();
    }
    public void forgetPasswordLink()
    {
        forgetPassword.click();
    }
    public void forgetEmailTextField(String forgetPassword)
    {
        forgetPassEmail.sendKeys(forgetPassword);
    }
    public void proceedButton()
    {
        proceedButton.click();
    }
    public String forgetPasswordEmailError()
    {
        return forgetEmailError.getText();
    }
    public void createAccountButton()
    {
        createAccount.click();
    }
    public String buttonColor()
    {
        return loginClickButton.getCssValue(ButtonColor);
    }
    public String createButton()
    {
        return createAccount.getCssValue(ButtonColor);
    }
    public String errorMessage(){
        return error.getText();
    }
    public HomePage login(){
        loginClickButton.click();
        return new HomePage();
    }
}
