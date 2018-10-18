package com.training.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DraftPage extends AbstractPage {

    public DraftPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//div[contains(text(),'kseniya.samtsova@gmail.com')]")
    WebElement item_panel_draft;

    @FindBy(xpath = "//div[@data-name = 'send']")
    WebElement send_button;

    @FindBy(xpath = "//input[@name='Subject']")
    WebElement subject_field;

    @FindBy (css = "#tinymce")
    WebElement text_area;

    public void OpenMessage(){
        item_panel_draft.click();
    }


    public String GetSubject(){
       return subject_field.getAttribute("value");
    }

    public String GetBody() {
        driver.switchTo().frame(0);
        return text_area.getText();
    }

    public void CloseFrame(){
        driver.switchTo().defaultContent();
    }

    public void SendDraftLetter(){

        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        send_button.click();

        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public boolean isVanished() {
        boolean thrown = false;
        try {
            item_panel_draft.getText();
            System.out.println("The letter is not disappeared from draft page.");
        } catch (NoSuchElementException e) {
            thrown = true;
        }
        return thrown;
    }
    public void KeyboardSaveMail(){
        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.CONTROL).sendKeys("s").perform();
    }
}
