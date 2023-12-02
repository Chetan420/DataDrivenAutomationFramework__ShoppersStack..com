package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage extends TestBase {
    @FindBy(linkText ="Home")
    WebElement homeButton;
    @FindBy(xpath = "//button[text()='Invoice'][1]")
    WebElement invoiceButton;
    @FindBy(xpath = "//button[text()='Cancel Order']")
    WebElement cancelOrder;
    @FindBy(xpath = "(//button[text()='Yes'])[1]")
    WebElement yes;
    @FindBy(xpath = "//button[(text()='Cancel')]")
    WebElement no;
    @FindBy(xpath = "//button[text()='See']")
    WebElement seeTermsAndCon;
    @FindBy(xpath = "//button[text(),'Close']")
    WebElement close;
    @FindBy(xpath = "//div[text()='Order has been Cancelled']")
    WebElement cancelMsg;
    @FindBy(xpath = "//button[@aria-label='close']")
    WebElement cancelMsgClose;
    public MyOrdersPage(){
        PageFactory.initElements(driver,this);
    }
    public void invoiceButton(){
        invoiceButton.click();
    }
    public void cancelOrderButton(){
        cancelOrder.click();
    }
    public void yesButton(){
        for(;;){
            try{
                yes.click();
                break;
            }
            catch (WebDriverException e){

            }
        }
    }
    public void cancel(){
        no.click();
    }
    public void seeTermsAndConditionLink(){
        seeTermsAndCon.click();
    }
    public void closeTermsAndCondition(){
        close.click();
    }
    public String cancelToastMsg(){
        return cancelMsg.getText();
    }
    public void cancelToastMsgClose(){
        cancelMsgClose.click();
    }
    public HomePage homeButton(){
        homeButton.click();
        return new HomePage();
    }
}