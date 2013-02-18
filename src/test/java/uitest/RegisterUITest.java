package uitest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import uitest.pages.LoginPage;
import uitest.pages.MessagesPage;
import uitest.pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;

public class RegisterUITest{

    private static final String LOGIN = "regtest";
    private static final String EMAIL = "regtest@example.org";
    private static final String PASSWORD = "test";

    @Test(enabled = true)
    public void testRegister() throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.register(LOGIN, EMAIL, PASSWORD);

        MessagesPage messagesPage = PageFactory.initElements(driver, MessagesPage.class);
        assertThat(messagesPage.getInfoText()).contains("User registered successfully");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openLoginPage();
        loginPage.login(LOGIN, PASSWORD);
        assertThat(messagesPage.isUserLogged()).isTrue();
    }
}
