package com.shoppersstacks.qa.pages;

import com.shoppersstacks.qa.base.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage extends TestBase {
    @FindBy(xpath = "//div[text()='Created']")
    private WebElement createdPopUp;
    @FindBy(xpath = "//button[@aria-label='close']")
    private WebElement createdPopUpClose;
    @FindBy(linkText ="Home")
    private WebElement homeButton;

    public WebElement getCreatedPopUp() {
        return createdPopUp;
    }

    public WebElement getCreatedPopUpClose() {
        return createdPopUpClose;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public OrderConfirmationPage(){
        PageFactory.initElements(driver,this);
    }
    public String createdPopUpText(){
        return getCreatedPopUp().getText();
    }
    public void createdPopUpCloseButton() {
        getCreatedPopUpClose().click();
    }
    public void orderConfirmScreenShot() throws IOException, AWTException {
        int num= random.nextInt(1,100);
        String filename="ShopperStacks OrderConfirmation"+num+".jpeg";

        File temp = ts.getScreenshotAs(OutputType.FILE);
        File src=new File("./errorShots"+filename);
        FileHandler.copy(temp,src);

        Robot robot=new Robot();
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rect=new Rectangle(dim);
        BufferedImage bufferedImage=robot.createScreenCapture(rect);
        String destinationPath=System.getProperty("user.dir")+"//errorShots"+filename;
        ImageIO.write(bufferedImage,"jpeg",new File(destinationPath));
    }
    public void saveAddressAndCancelAdressPopUp() {
        robot.mouseMove(1350,400);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
    public HomePage homeButton(){
        getHomeButton().click();
        return new HomePage();
    }
}
