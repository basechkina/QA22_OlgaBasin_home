package com.wikipedia.olga.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {

    WebDriver wd;

    SessionHelper sessionHelper;

    public void init() {
        String browser = System.getProperty("browser", BrowserType.CHROME);

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new SafariDriver();
        }

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.wikipedia.org/");

        sessionHelper = new SessionHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
