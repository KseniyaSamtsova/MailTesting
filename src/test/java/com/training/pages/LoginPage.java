package com.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @FindBy(xpath = "//input[@id='mailbox:login']")
    WebElement username;

    @FindBy(xpath = "//input[@id='mailbox:password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Войти']")
    WebElement submit_button;

    @FindBy(xpath = "//i[@id='PH_user-email']")
    WebElement user_link;



    public void loginMailRu(String login, String pass) {
        highlightElement(username);
        username.sendKeys(login);
        highlightElement(password);
        password.sendKeys(pass);
        submit_button.click();
    }

    public boolean homePageStatus(String user) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        user_link = wait.until(ExpectedConditions.visibilityOf(user_link));
        return user.equals(user_link.getText());
    }
}
