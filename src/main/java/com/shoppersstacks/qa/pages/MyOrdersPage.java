package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrdersPage extends TestBase {
    @FindBy(linkText ="Home")
    private WebElement homeButton;
    @FindBy(xpath = "//button[text()='Invoice'][1]")
    private WebElement invoiceButton;
    @FindBy(xpath = "//button[text()='Cancel Order']")
    private WebElement cancelOrder;
    @FindBy(xpath = "(//button[text()='Yes'])[1]")
    private WebElement yes;
    @FindBy(xpath = "//button[(text()='Cancel')]")
    private WebElement no;
    @FindBy(xpath = "//button[text()='See']")
    private WebElement seeTermsAndCon;
    @FindBy(xpath = "//button[text(),'Close']")
    private WebElement close;
    @FindBy(xpath = "//div[text()='Order has been Cancelled']")
    private WebElement cancelMsg;
    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement cancelMsgClose;


    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getInvoiceButton() {
        return invoiceButton;
    }

    public WebElement getCancelOrder() {
        return cancelOrder;
    }

    public WebElement getYes() {
        return yes;
    }

    public WebElement getNo() {
        return no;
    }

    public WebElement getSeeTermsAndCon() {
        return seeTermsAndCon;
    }

    public WebElement getClose() {
        return close;
    }

    public WebElement getCancelMsg() {
        return cancelMsg;
    }

    public WebElement getCancelMsgClose() {
        return cancelMsgClose;
    }


    public MyOrdersPage(){
        PageFactory.initElements(driver,this);
    }
    public void invoiceButton(){
        getInvoiceButton().click();
    }
    public void cancelOrderButton(){
        getCancelOrder().click();
    }
    public void yesButton(){
        for(;;){
            try{
                js.executeScript("arguments[0].click()",getYes());
                break;
            }
            catch (WebDriverException e){

            }
        }
    }
    public void cancel(){
        getNo().click();
    }
    public void seeTermsAndConditionLink(){
        getSeeTermsAndCon().click();
    }
    public void closeTermsAndCondition(){
        getClose().click();
    }
    public String cancelToastMsg(){
        return getCancelMsg().getText();
    }
    public void cancelToastMsgClose(){
        getCancelMsgClose().click();
    }
    public HomePage homeButton(){
        getHomeButton().click();
        return new HomePage();
    }
}
