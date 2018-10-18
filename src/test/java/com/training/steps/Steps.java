package com.training.steps;

import com.training.DriverSingelton;
import com.training.pages.*;
import org.openqa.selenium.WebDriver;

public class Steps {

    private WebDriver driver;

    public void initBrowser(){
        driver= DriverSingelton.startBrowser();
    }

    public void startPage(String username, String password){
        LoginPage homePage = new LoginPage(driver);
        homePage.loginMailRu(username,password);
    }

    public boolean isLoggedIn(String username){
        LoginPage loginPage=new LoginPage(driver);
        return loginPage.homePageStatus(username);
    }



    public void createNewMail(String addresse,String subject, String text) {
        ComposePage composePage = new ComposePage(driver);
        composePage.ClickWriteLetterButton();
        composePage.SaveLetter(addresse,subject,text);
        composePage.ClickDraftLink();
    }

    public String isPresentInDraft(){
        ComposePage composePage = new ComposePage(driver);
        return composePage.CheckAddresse();
    }
    public void openMessage(){
        DraftPage draftPage = new DraftPage(driver);
        draftPage.OpenMessage();
    }
    public String CheckSubject(){
        DraftPage draftPage = new DraftPage(driver);
        return draftPage.GetSubject();
    }
    public String CheckBody() {
        DraftPage draftPage = new DraftPage(driver);
        return draftPage.GetBody();
    }

    public void ClickSendMessage(){
        DraftPage draftPage = new DraftPage(driver);
        draftPage.CloseFrame();
        draftPage.SendDraftLetter();

    }
    public void ClickOpenDraft(){
        ComposePage composePage = new ComposePage(driver);
        composePage.ClickDraftLink();
    }
    public boolean CheckVanish(){
        DraftPage draftPage = new DraftPage(driver);
        return draftPage.isVanished();
    }
    public void ClickOpenSent(){
        SendmsPage sendmsPage = new SendmsPage(driver);
        sendmsPage.ClickSendMailLink();
    }

    public String CheckSentMail(){
        SendmsPage sendmsPage = new SendmsPage(driver);
        return sendmsPage.GetSentMail();
    }

    public void ClickLeaveAccount(){
        ControlPanel controlPanel = new ControlPanel(driver);
        controlPanel.CklickLeaveAccountLink();
    }
    public void DragDrop(){
        SpamPage spamPage = new SpamPage(driver);
        spamPage.DragAndDropDraftToSpam();
    }
    public void SaveMail(){
        DraftPage draftPage = new DraftPage(driver);
        draftPage.KeyboardSaveMail();
    }

    public void ComposeMailForSave(String addresse,String subject, String text){
        ComposePage composePage = new ComposePage(driver);
        composePage.ClickWriteLetterButton();
        composePage.ComposeMail(addresse,subject,text);
    }
}
