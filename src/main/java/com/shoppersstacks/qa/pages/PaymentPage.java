package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class PaymentPage extends TestBase {
    @FindBy(css = "input[value='Net Banking']")
    WebElement netBanking;
    @FindBy(css = "input[value='COD']")
    WebElement cod;
    @FindBy(xpath = "//button[text()='Clear Selection']")
    WebElement clearSelction;
    @FindBy(xpath = "//button[text()='Add Card']")
    WebElement addCard;
    @FindBy(xpath = "(//fieldset[contains(@class,'MuiOutlinedInput')])[1]")
    WebElement holderName;
    @FindBy(xpath = "(//fieldset[contains(@class,'MuiOutlinedInput')])[2]")
    WebElement cardNumber;
    @FindBy(xpath = "(//fieldset[contains(@class,'MuiOutlinedInput')])[3]")
    WebElement pin;
    @FindBy(xpath = "(//fieldset[contains(@class,'MuiOutlinedInput')])[4]")
    WebElement expiryMonth;
    @FindBy(xpath = "(//fieldset[contains(@class,'MuiOutlinedInput')])[5]")
    WebElement expiryYear;
    @FindBy(xpath = "(//fieldset[contains(@class,'MuiOutlinedInput')])[6]")
    WebElement cvv;
    @FindBy(xpath = "//input[@value='DEBIT']")
    WebElement debit;
    @FindBy(xpath = "//input[@value='CREDIT']")
    WebElement credit;
    @FindBy(xpath = "//button[text()='Add']")
    WebElement add;
    @FindBy(xpath = "//*[name()='svg' and @data-testid='CloseIcon']")
    WebElement closeIcon;
    @FindBy(xpath = "//button[text()='Proceed']")
    WebElement proceedButton;
    public PaymentPage(){
        PageFactory.initElements(driver,this);
    }
    public  void netBankingRadioButton(){
        netBanking.click();
    }
    public void codRadioButton(){
        for (;;){
            try{
                cod.click();
                break;
            }
            catch (WebDriverException e){
                e.printStackTrace();
            }
        }
    }
    public void clearSelectionButton(){
        clearSelction.click();
    }
    public void addCardButton(){
        addCard.click();
    }
    public void holderName(String name) {
        holderName.sendKeys(name);
    }
    public void cardNumber(String Number){
        cardNumber.sendKeys(Number);
    }
    public void pinNumber(String num){
        pin.sendKeys(num);
    }
    public void expiryMonth(String month){
        expiryMonth.sendKeys(month);
    }
    public void expiryYear(String year){
        expiryYear.sendKeys(year);
    }
    public void cvvAdd(String cvvNum){
        cvv.sendKeys(cvvNum);
    }
    public void debitRadioButton(){
        debit.click();
    }
    public void creditRadioButton(){
        credit.click();
    }
    public void add(){
        add.click();
    }
    public void closeIconButton(){
        closeIcon.click();
    }
    public void saveAddressAndCancelAdressPopUp() {
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
//        robot.mouseMove(1350,400);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public OrderConfirmationPage proceedButton(){
        proceedButton.click();
        return new OrderConfirmationPage();
    }
}
