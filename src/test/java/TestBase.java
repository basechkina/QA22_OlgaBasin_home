import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver wd;

    @BeforeSuite
    public void setUp() {
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
    }


    @AfterSuite
    public void tearDown() {
        wd.quit();
    }

    public void confirmLogin() {
        click(By.id("wpLoginAttempt"));
    }

    public void fillLoginForm(String user, String pwd) throws InterruptedException {
        type(By.id("wpName1"), user);
        type(By.id("wpPassword1"), pwd);
        Thread.sleep(3000);
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void logInButton() {
        click(By.id("pt-login"));
    }

    public void selectLang() {
        click(By.id("js-link-box-en"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
}
