package com.training.tests;

import com.training.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailRuTest {

    private WebDriver driver;

    private Steps steps;
    private final String USERNAME = "webdrivertestepam@mail.ru";
    private final String PASSWORD = "selenium123";
    private final String ADDRESSE = "kseniya.samtsova@gmail.com";
    private final String SUBJECT = "Subject";
    private final String BODY = "Text";

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void loginMail() {
        steps.startPage(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(dependsOnMethods = "loginMail")
    public void writeLetter(){
        steps.createNewMail(ADDRESSE,SUBJECT,BODY);
        steps.isPresentInDraft();
        Assert.assertEquals(steps.isPresentInDraft(),ADDRESSE,"Addressee is invalid");
    }

    @Test(dependsOnMethods = "writeLetter")
    public void checkSubject(){
        steps.openMessage();
        String subject = steps.CheckSubject();
        Assert.assertEquals(subject, SUBJECT, "subject is invalid.");
    }

    @Test(dependsOnMethods = "checkSubject")
    public void checkBody(){
        String body = steps.CheckBody();
        Assert.assertEquals(body, BODY, "bodymessage is invalid.");
    }


    @Test(dependsOnMethods = "checkBody")
    public void isMessageVanished(){
        steps.ClickSendMessage();
        steps.ClickOpenDraft();
        Assert.assertTrue(steps.CheckVanish());
    }

    @Test(dependsOnMethods = "isMessageVanished")
    public void isMessagePresented(){
        steps.ClickOpenSent();
        Assert.assertEquals(steps.CheckSentMail(), ADDRESSE, "The mail was not sent.");
    }

    @Test(dependsOnMethods = "isMessagePresented")
    public void isAccountLeave(){
        steps.ClickLeaveAccount();
    }
}
