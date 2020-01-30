package com.wikipedia.olga.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {

    EventFiringWebDriver wd;

    SessionHelper sessionHelper;
    ArticleHelper articleHelper;

    public static class MyListener extends AbstractWebDriverEventListener{

        public MyListener() {
            super();
        }

        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Search element " +by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info(by + " found!");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error("\nERROR" +throwable);
        }
    }

    public void init() {
        String browser = System.getProperty("browser", BrowserType.CHROME);

        if (browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new EventFiringWebDriver(new FirefoxDriver());
        } else if (browser.equals(BrowserType.SAFARI)) {
            wd = new EventFiringWebDriver(new SafariDriver());
        }

        wd.register(new MyListener());

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://www.wikipedia.org/");


        sessionHelper = new SessionHelper(wd);
        articleHelper = new ArticleHelper(wd);
    }

    public void setArticleHelper(ArticleHelper articleHelper) {
        this.articleHelper = articleHelper;
    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ArticleHelper getArticleHelper() {
        return articleHelper;
    }

    public void back (){ wd.navigate().back();}
}

