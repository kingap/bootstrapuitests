package uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uitest.commands.SeleniumCommands;
import uitest.commands.SeleniumCommands.*;

public class MessagesPage {
    private final WebDriver driver;

    @FindBy(css = "a[text()='Logout']")
    private WebElement logoutLink;

    public MessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() throws Exception {
        logoutLink.click();
        SeleniumCommands sc = new SeleniumCommands(driver);
        sc.waitForFinishLoading();
    }

    public boolean isUserLogged() throws Exception {
        try {
            driver.findElement(By.cssSelector("a[text()='Logout']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}