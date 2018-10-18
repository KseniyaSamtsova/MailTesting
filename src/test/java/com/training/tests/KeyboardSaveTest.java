package com.training.tests;

import com.training.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class KeyboardSaveTest {
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
        steps.ComposeMailForSave(ADDRESSE,SUBJECT,BODY);
        steps.SaveMail();
    }
}
