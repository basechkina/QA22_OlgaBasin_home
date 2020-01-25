package com.wikipedia.olga.manager;

import com.wikipedia.olga.model.Article;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ArticleHelper extends HelperBase {

    public ArticleHelper(WebDriver wd) {
        super(wd);
    }

    public void searchArticleFromMainPage(Article article) {
        type(By.cssSelector("#searchInput"), article.getArticleName());
        click(By.cssSelector(".pure-button.pure-button-primary-progressive"));
    }

    public void searchArticleFromMainPageWithCSV(Article article) {
        type(By.cssSelector("#searchInput"), article.getArticleName());
        click(By.cssSelector(".pure-button.pure-button-primary-progressive"));;
        String articleTitle = getArticleName();
        Assert.assertEquals(articleTitle, article.getArticleName());
    }

    public String getArticleName() {
        return wd.findElement(By.cssSelector("h1")).getText();
    }
}
