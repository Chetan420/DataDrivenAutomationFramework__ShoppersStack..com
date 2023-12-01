package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MerchantLoginPage extends TestBase {

    @FindBy (id = "Enter Admin Email")
    WebElement enterAdminEmailTextField;
    @FindBy (xpath = "//button[@type='submit']")
    WebElement iconButton;
    @FindBy(linkText = "Merchant Signup")
    WebElement merchantSignUp;
    @FindBy(id = "E-mail")
    WebElement email;
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
//    public void merchantLogin()
//    {
//        merchantLogin.click();
//    }
    public void merchantEmail(String MerchantEmail)
    {
        email.sendKeys(MerchantEmail);
    }
}
