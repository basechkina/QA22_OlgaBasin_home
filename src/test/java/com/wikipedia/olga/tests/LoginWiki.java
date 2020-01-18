package com.wikipedia.olga.tests;

import org.testng.annotations.Test;

public class LoginWiki extends TestBase {

    @Test
    public void openWikipediaTest() throws InterruptedException {
        app.getSessionHelper().selectLang();
        app.getSessionHelper().logInButton();
        app.getSessionHelper().pause(3000);
        app.getSessionHelper().fillLoginForm("olgatester22@gmail.com", "olgatester12358");
        app.getSessionHelper().confirmLogin();
    }

}




