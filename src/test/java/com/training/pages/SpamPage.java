package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpamPage extends AbstractPage {

    public SpamPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }
    @FindBy(xpath = "//span[@class='b-nav__item__text'][contains(text(),'Спам')]")
    WebElement spam_link;
    @FindBy(xpath = "//span[contains(text(),'Черновики')]")
    WebElement draft_link;

    public void SpamLink(){
        spam_link.click();
    }

    public void dragAndDropDraftToSpam(){
        try {
            Thread.sleep( 10000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Actions builder = new Actions(driver);
        builder.dragAndDrop(draft_link,spam_link).build().perform();
    }
}
