package com.training.steps;

import com.training.DriverSingelton;
import com.training.bo.User;
import com.training.pages.*;
import org.openqa.selenium.WebDriver;

public class Steps {

    private WebDriver driver;

    public void initBrowser(){
        driver= DriverSingelton.startBrowser();
    }

    public void startPage(User user){
        LoginPage homePage = new LoginPage(driver);
        homePage.loginMailRu(user);
    }

    public boolean isLoggedIn(String username){
        LoginPage loginPage=new LoginPage(driver);
        return loginPage.homePageStatus(username);
    }

    public void createNewMail(String addresse,String subject, String text) {
        ComposePage composePage = new ComposePage(driver);
        composePage.clickWriteLetterButton();
        composePage.saveLetter(addresse,subject,text);
        composePage.clickDraftLink();
    }

    public String isPresentInDraft(){
        ComposePage composePage = new ComposePage(driver);
        return composePage.checkAddresse();
    }
    public void openMessage(){
        DraftPage draftPage = new DraftPage(driver);
        draftPage.openMessage();
    }
    public String checkSubject(){
        DraftPage draftPage = new DraftPage(driver);
        return draftPage.getSubject();
    }
    public String checkBody() {
        DraftPage draftPage = new DraftPage(driver);
        return draftPage.getBody();
    }

    public void clickSendMessage(){
        DraftPage draftPage = new DraftPage(driver);
        draftPage.closeFrame();
        draftPage.sendDraftLetter();

    }
    public void clickOpenDraft(){
        ComposePage composePage = new ComposePage(driver);
        composePage.clickDraftLink();
    }
    public boolean checkVanish(){
        DraftPage draftPage = new DraftPage(driver);
        return draftPage.isVanished();
    }
    public void clickOpenSent(){
        SendmsPage sendmsPage = new SendmsPage(driver);
        sendmsPage.clickSendMailLink();
    }

    public String checkSentMail(){
        SendmsPage sendmsPage = new SendmsPage(driver);
        return sendmsPage.getSentMail();
    }

    public void clickLeaveAccount(){
        ControlPanel controlPanel = new ControlPanel(driver);
        controlPanel.clickLeaveAccountLink();
    }
    public void dragDrop(){
        SpamPage spamPage = new SpamPage(driver);
        spamPage.dragAndDropDraftToSpam();
    }
    public void saveMail(){
        DraftPage draftPage = new DraftPage(driver);
        draftPage.keyboardSaveMail();
    }

    public void composeMailForSave(String addresse, String subject, String text){
        ComposePage composePage = new ComposePage(driver);
        composePage.clickWriteLetterButton();
        composePage.composeMail(addresse,subject,text);
    }
}
