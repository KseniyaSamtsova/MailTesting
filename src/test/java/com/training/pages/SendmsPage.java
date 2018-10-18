package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendmsPage extends AbstractPage {

    public SendmsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Отправленные')]")
    WebElement send_mail_link;

    @FindBy(xpath = "//div[contains(text(),'kseniya.samtsova@gmail.com')]")
    WebElement sent_mail;

    public void ClickSendMailLink(){
        send_mail_link.click();
    }

    public String GetSentMail(){
       return sent_mail.getText();
    }


}
