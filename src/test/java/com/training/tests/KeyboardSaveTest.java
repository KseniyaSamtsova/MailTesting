package com.training.tests;

import com.training.bo.User;
import com.training.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyboardSaveTest {

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
        steps.composeMailForSave(ADDRESSE,SUBJECT,BODY);
        steps.saveMail();
    }
}
