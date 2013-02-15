package uitest.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import uitest.commands.SeleniumCommands;

import static uitest.commands.SeleniumCommands.*;

public class RegistrationPage {

    private final WebDriver driver;
    SeleniumCommands sc;

    @FindBy(id = "login")
    private WebElement loginField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "repeatPassword")
    private WebElement repeatPassField;

    @FindBy(css = "button[type=submit]")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        sc = new SeleniumCommands(driver);
    }

    public void register(String login, String email, String password) throws Exception {
        openRegistrationPage();

        loginField.sendKeys(login);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        repeatPassField.sendKeys(password);
        registerButton.click();
        sc.waitForFinishLoading();
    }

    public void openRegistrationPage() throws Exception {
        driver.get("http://bootstrap.softwaremill.com/#/register");
        sc.waitForFinishLoading();
    }
}
