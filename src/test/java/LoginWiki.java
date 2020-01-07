import org.testng.annotations.Test;

public class LoginWiki extends TestBase {

    @Test
    public void openWikipediaTest() throws InterruptedException {
        selectLang();
        logInButton();
        fillLoginForm("olgatester22@gmail.com", "olgatester12358");
        confirmLogin();
    }

}




