package com.training.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComposePage extends AbstractPage {

    public ComposePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy (xpath = "//div[contains(@class,'compose-head__row-wrapper compose-head__row-wrapper_to js-row')]//textarea[@class='js-input compose__labels__input']")
    WebElement whum;

    @FindBy(xpath = "//input[contains(@name,'Subject')]")
    WebElement topic;

    //@FindBy (css = "#tinymce")
    @FindBy(xpath = "//body[@id='tinymce']")
    WebElement text_area;

    @FindBy (xpath = "//div[@id='b-toolbar__right']//div//div[contains(@class,'b-toolbar')]//div[contains(@class,'b-toolbar__group')]//div[contains(@class,'b-toolbar__item')]//div//div[contains(@title,'Сохранить (Ctrl+S)')]//span[contains(@class,'b-toolbar__btn__text')][contains(text(),'Сохранить')]")
    WebElement button_save_letter;

    @FindBy(xpath = "//span[contains(text(),'Черновики')]")
    WebElement draft_link;

    @FindBy (xpath = "//div[@id='b-toolbar__left']//div//span[@class='b-toolbar__btn__text b-toolbar__btn__text_pad'][contains(text(),'Написать письмо')]")
    WebElement button_write_letter;

    @FindBy(xpath = "//div[contains(text(),'kseniya.samtsova@gmail.com')]")
    WebElement item_panel_draft;

    public void ClickWriteLetterButton(){
        button_write_letter.click();
    }

    public void SaveLetter(String forWhum, String whatTopic, String textArea){
        whum.sendKeys(forWhum);
        topic.sendKeys(whatTopic);
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent= arguments[1];",text_area,textArea);
        driver.switchTo().defaultContent();
        button_save_letter.click();
    }

    public void ComposeMail(String forWhum, String whatTopic, String textArea){
        whum.sendKeys(forWhum);
        topic.sendKeys(whatTopic);
        driver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].textContent= arguments[1];",text_area,textArea);
        driver.switchTo().defaultContent();
    }

    public void ClickDraftLink(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        draft_link.click();
    }

    public String CheckAddresse() {
        return item_panel_draft.getText();
    }
}
