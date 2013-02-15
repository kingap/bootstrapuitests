package uitest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import uitest.pages.LoginPage;
import uitest.pages.MessagesPage;

import java.util.concurrent.TimeUnit;

import static org.fest.assertions.Assertions.assertThat;

public class LoginUITest {
    private static final String LOGIN = "kinga";
    private static final String PASSWORD = "12qwQW!@";

    @Test(enabled = true)
    public void testLogin() throws Exception {
        FirefoxProfile profile = new ProfilesIni().getProfile("ff17");
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, profile);

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.openLoginPage();
        loginPage.login(LOGIN, PASSWORD);
        MessagesPage messagesPage = PageFactory.initElements(driver, MessagesPage.class);
        assertThat(messagesPage.isUserLogged()).isTrue();
        messagesPage.logout();

        driver.quit();
    }
}
