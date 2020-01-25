package com.wikipedia.olga.tests;

import com.wikipedia.olga.model.Article;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchArticleTests extends TestBase {


    @Test(dataProvider = "validArticlesCSV", dataProviderClass = DataProviders.class)
    public void searchArticleTestCSV(Article articleName) {

        app.getArticleHelper().searchArticleFromMainPageWithCSV(articleName);
        app.back();

    }

    @Test
    public void searchArticleTest() {

        app.getArticleHelper().searchArticleFromMainPage(new Article()
                .withArticleName("Java"));
        String articleTitle = app.getArticleHelper().getArticleName();

        Assert.assertEquals(articleTitle, "Java");


    }
}
