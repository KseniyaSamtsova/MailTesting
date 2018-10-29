package com.training.tests;

import com.training.bo.User;
import com.training.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MailRuTest {

    private WebDriver driver;

    private Steps steps;
    private final String ADDRESSE = "kseniya.samtsova@gmail.com";
    private final String SUBJECT = "Subject";
    private final String BODY = "Text";

    User user = new User("webdrivertestepam@mail.ru", "selenium123");

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void loginMail() {
        steps.startPage(user);
        Assert.assertTrue(steps.isLoggedIn(user.getLogin()));
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
        String subject = steps.checkSubject();
        Assert.assertEquals(subject, SUBJECT, "subject is invalid.");
    }

    @Test(dependsOnMethods = "checkSubject")
    public void checkBody(){
        String body = steps.checkBody();
        Assert.assertEquals(body, BODY, "bodymessage is invalid.");
    }


    @Test(dependsOnMethods = "checkBody")
    public void isMessageVanished(){
        steps.clickSendMessage();
        steps.clickOpenDraft();
        Assert.assertTrue(steps.checkVanish());
    }

    @Test(dependsOnMethods = "isMessageVanished")
    public void isMessagePresented(){
        steps.clickOpenSent();
        Assert.assertEquals(steps.checkSentMail(), ADDRESSE, "The mail was not sent.");
    }

    @Test(dependsOnMethods = "isMessagePresented")
    public void isAccountLeave(){
        steps.clickLeaveAccount();
    }
}
