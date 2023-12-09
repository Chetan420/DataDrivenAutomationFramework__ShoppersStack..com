package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage extends TestBase {
    @FindBy(xpath = "//a[text()='cart']")
    private WebElement cart;
    @FindBy(id="buynow_fl")
    private WebElement buyNow;
    @FindBy(xpath = "//span[text()='Continue Shopping']")
    private WebElement continueShopping;
    @FindBy(xpath = "//button[text()='Remove from cart']")
    private WebElement removeFromCart;
    @FindBy(xpath = "increase")
    private WebElement increaseItem;
    @FindBy(id="decrease")
    private WebElement decreaseItem;
    @FindBy(xpath = "//div[@class='cart_subtotalContainer__S6AbY']")
    private WebElement itemDetails;

    public WebElement getCart() {
        return cart;
    }

    public WebElement getBuyNow() {
        return buyNow;
    }

    public WebElement getContinueShopping() {
        return continueShopping;
    }

    public WebElement getRemoveFromCart() {
        return removeFromCart;
    }

    public WebElement getIncreaseItem() {
        return increaseItem;
    }

    public WebElement getDecreaseItem() {
        return decreaseItem;
    }

    public WebElement getItemDetails() {
        return itemDetails;
    }


    public ViewCartPage(){
        PageFactory.initElements(driver,this);
    }

    public String viewCartPageTitle() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return driver.getTitle();
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
    public void itemIncreaseButton(){
        increaseItem.click();
    }
    public void intemDecreaseButton(){
        decreaseItem.click();
    }

}
