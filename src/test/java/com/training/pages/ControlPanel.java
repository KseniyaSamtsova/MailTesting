package com.training.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ControlPanel extends AbstractPage {

    public ControlPanel(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//a[@id='PH_logoutLink']")
    WebElement leave_account_link;

//    @FindBy(xpath = "//div[@class='toolbar__aside']")
//    WebElement toolbar;


    public void CklickLeaveAccountLink(){
        leave_account_link.click();
    }
}
