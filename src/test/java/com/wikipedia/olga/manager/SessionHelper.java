package com.wikipedia.olga.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void confirmLogin() {
        click(By.id("wpLoginAttempt"));
    }

    public void fillLoginForm(String user, String pwd) throws InterruptedException {
        type(By.id("wpName1"), user);
        type(By.id("wpPassword1"), pwd);
        pause(3000);
    }

    public void logInButton() {
        click(By.id("pt-login"));
    }

    public void selectLang() {
        click(By.id("js-link-box-en"));
    }
}
