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
    private WebElement registrationMsg;
    @FindBy(xpath = "//button[@type='button' and @id='vertical-tab-0']")
    private WebElement shopperLogin;
    @FindBy(xpath = "//button[@type='button' and @id='vertical-tab-1']")
    private WebElement merchantLogin;
    @FindBy(xpath = "//button[@type='button' and @id='vertical-tab-2']")
    private WebElement adminLogin;
    @FindBy (id="loginBtn")
    private WebElement loginButton;
    @FindBy(id="Email")
    private WebElement emailTextField;
    @FindBy(id="Password")
    private WebElement passwordTextField;
    @FindBy(xpath = "//button[@type='button' and @aria-label='toggle password visibility']")
    private WebElement hideButton;
    @FindBy(id = "Login")
    private WebElement loginClickButton;
    @FindBy(id = "Forgot Password?")
    private WebElement forgetPassword;
    @FindBy(id="email")
    private WebElement forgetPassEmail;
    @FindBy(css = "button[type='button']")
    private WebElement proceedButton;
    @FindBy(id = "Create Account")
    private WebElement createAccount;
    @FindBy(id="email-helper-text")
    private WebElement forgetEmailError;
    @FindBy(xpath = "//div[contains(text(),'Given user ID')]")
    private WebElement error;

    public WebElement getRegistrationMsg() {
        return registrationMsg;
    }

    public WebElement getShopperLogin() {
        return shopperLogin;
    }

    public WebElement getMerchantLogin() {
        return merchantLogin;
    }

    public WebElement getAdminLogin() {
        return adminLogin;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public WebElement getHideButton() {
        return hideButton;
    }

    public WebElement getLoginClickButton() {
        return loginClickButton;
    }

    public WebElement getForgetPassword() {
        return forgetPassword;
    }

    public WebElement getForgetPassEmail() {
        return forgetPassEmail;
    }

    public WebElement getProceedButton() {
        return proceedButton;
    }

    public WebElement getCreateAccount() {
        return createAccount;
    }

    public WebElement getForgetEmailError() {
        return forgetEmailError;
    }

    public WebElement getError() {
        return error;
    }

    public String getButtonColor() {
        return ButtonColor;
    }


    private String ButtonColor="background";

    //Initializing the Page Objects
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public String msg(){
        return getRegistrationMsg().getText();
    }

    public String  loginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(getLoginButton())).click();
        Thread.sleep(2000);
        return driver.getTitle();
    }
    public void registeredEmail(String username){
        getEmailTextField().sendKeys(username);
    }
    public void password(String password){
        getPasswordTextField().sendKeys(password);
    }
    public void hideIcon()
    {
        getHideButton().click();
    }
    public void forgetPasswordLink()
    {
        getForgetPassword().click();
    }
    public void forgetEmailTextField(String forgetPassword)
    {
        getForgetPassEmail().sendKeys(forgetPassword);
    }
    public void proceedButton()
    {
        getProceedButton().click();
    }
    public String forgetPasswordEmailError()
    {
        return getForgetEmailError().getText();
    }
    public void createAccountButton()
    {
        getCreateAccount().click();
    }
    public String buttonColor()
    {
        return getLoginClickButton().getCssValue(ButtonColor);
    }
    public String createButton()
    {
        return getCreateAccount().getCssValue(ButtonColor);
    }
    public String errorMessage(){
        robot.delay(2000);
        return getError().getText();
    }
    public HomePage login(){
        getLoginClickButton().click();
        return new HomePage();
    }
}
