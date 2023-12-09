package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantLoginPage extends TestBase {

    @FindBy (id = "Enter Admin Email")
    private WebElement enterAdminEmailTextField;
    @FindBy (xpath = "//button[@type='submit']")
    private WebElement iconButton;
    @FindBy(linkText = "Merchant Signup")
    private WebElement merchantSignUp;
    @FindBy(id = "E-mail")
    private WebElement email;

    public WebElement getEnterAdminEmailTextField() {
        return enterAdminEmailTextField;
    }

    public WebElement getIconButton() {
        return iconButton;
    }

    public WebElement getMerchantSignUp() {
        return merchantSignUp;
    }

    public WebElement getEmail() {
        return email;
    }

    public MerchantLoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void enterAdminEmailTextField(String Email)
    {
        enterAdminEmailTextField.sendKeys(Email);
    }
    public void iconButton()
    {
        iconButton.click();
    }
    public void merchantSignUp()
    {
        merchantSignUp.click();
    }
    public void merchantEmail(String MerchantEmail)
    {
        email.sendKeys(MerchantEmail);
    }
}
