package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage extends TestBase {
    @FindBy(xpath = "//a[text()='cart']")
    WebElement cart;
    @FindBy(id="buynow_fl")
    WebElement buyNow;
    @FindBy(xpath = "//span[text()='Continue Shopping']")
    WebElement continueShopping;
    @FindBy(xpath = "//button[text()='Remove from cart']")
    WebElement removeFromCart;
    @FindBy(xpath = "increase")
    WebElement increaseItem;
    @FindBy(id="decrease")
    WebElement decreaseItem;
    @FindBy(xpath = "//div[@class='cart_subtotalContainer__S6AbY']")
    WebElement itemDetails;
    public String viewCartPageTitle() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return driver.getTitle();
    }
    public ViewCartPage(){
        PageFactory.initElements(driver,this);
    }
    public String cartText(){
        return cart.getText();
    }
    public SelectDeliveryAddressPage buyNow(){
        buyNow.click();
        return new SelectDeliveryAddressPage();
    }
    public void continueShopping(){
        continueShopping.click();
    }
    public void removeFromCart(){
        removeFromCart.click();
    }
    public void itemIncreaseButtton(){
        increaseItem.click();
    }
    public void intemDecreaseButton(){
        decreaseItem.click();
    }

}
