package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class HomePage extends TestBase{

    @FindBy(linkText = "Home")
    private WebElement homeButton;
    @FindBy(id="search")
    private WebElement serchBar;
    @FindBy(id="searchBtn")
    private WebElement searchButton;
    @FindBy(css = "select[id='category' ]")
    private WebElement categoryDropDown;
    @FindBy(id="cartIcon")
    private WebElement viewCart;
    @FindBy (xpath = "//div[text()='C']")
    private WebElement accountSettingIcon;
    @FindBy(xpath = "//span[text()='APPLE iPhone 14 Pro']")
    private WebElement item;
    @FindBy(id = "Add To Cart")
    private WebElement add;
    @FindBy(xpath = "//button[text()='added']")
    private WebElement addedButton;
    @FindBy (xpath = "//li[text()='My Profile']")
    private WebElement prfile;
    @FindBy(xpath = "//li[text()='Wish List']")
    private WebElement wishList;
    @FindBy(xpath = "//*[name()='svg' and @data-testid='ShoppingBagIcon']")
    private WebElement myOrder;
    @FindBy(xpath = "//li[text()='My Wallet']")
    private WebElement myWallet;
    @FindBy(xpath = "//li[text()='My Likes']")
    private WebElement myLikes;
    @FindBy(xpath = "//li[text()='Logout']")
    private WebElement logout;

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getSerchBar() {
        return serchBar;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getCategoryDropDown() {
        return categoryDropDown;
    }

    public WebElement getViewCart() {
        return viewCart;
    }

    public WebElement getAccountSettingIcon() {
        return accountSettingIcon;
    }

    public WebElement getItem() {
        return item;
    }

    public WebElement getAdd() {
        return add;
    }

    public WebElement getAddedButton() {
        return addedButton;
    }

    public WebElement getPrfile() {
        return prfile;
    }

    public WebElement getWishList() {
        return wishList;
    }

    public WebElement getMyOrder() {
        return myOrder;
    }

    public WebElement getMyWallet() {
        return myWallet;
    }

    public WebElement getMyLikes() {
        return myLikes;
    }

    public WebElement getLogout() {
        return logout;
    }

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public String homePageTitle(){
        robot.delay(1500);
       return driver.getTitle();
    }
    public void homeButton(){
        getHomeButton().click();
    }

    public void searchBar(String item)
    {
        getSerchBar().sendKeys(item);
        getSearchButton().click();
    }
    public void categoryDropDown(String choice)
    {
        Select select= new Select(getCategoryDropDown());
        switch (choice)
        {
            case "beauty":
            {
                select.selectByVisibleText("beauty");
            }
            break;
            case "men":
            {
                select.selectByVisibleText("men");
            }
            break;
            case "women":
            {
                select.selectByVisibleText("women");
            }
            case "kids":
            {
                select.selectByVisibleText("kids");
            }
            default:
            {
                select.selectByVisibleText("all");
            }
        }
    }

    public void electronics()
    {
        robot.mouseMove(850,220);
    }
    public void mobile(){
        robot.mouseMove(716,447);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        robot.mouseMove(500,708);
    }

    public void mensStore(){
        robot.mouseMove(520,99);
    }
    public void tShirt(){
        robot.mouseMove(400,207);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);
        robot.mouseMove(300,437);
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

    }

    public void item(){
       for(;;){
           try {
               js.executeScript("arguments[0].click()",getItem());
               break;
           }
           catch (WebDriverException e){

           }
       }
    }
    public void addToCart() throws InterruptedException {
        for(;;){
            try{
                js.executeScript("arguments[0].click()",getAdd());
            }
            catch (WebDriverException e){

            }
        }
    }
    public String added(){
        return getAddedButton().getText();
    }
    public ViewCartPage viewCart()
    {
        getViewCart().click();
        return new ViewCartPage();
    }

    public void accountSettingIcon() {
        for (;;){
            try{
                action.moveByOffset(1446,43).click().perform();
                break;
            }
            catch (Exception e){
                js.executeScript("arguments[0].click()",getAccountSettingIcon());
                break;
            }
        }
    }
    public void profile() {
        getPrfile().click();
    }
    public void wishList(){
        getWishList().click();
    }
    public void myWallet(){
        getMyWallet().click();
    }
    public void myLikes(){
        getMyLikes().click();
    }
    public LoginPage logout()
    {
        getLogout().click();
        return new LoginPage();
    }
    public MyOrdersPage myOrders(){
        getMyOrder().click();
        return new MyOrdersPage();
    }
}
