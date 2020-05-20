package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
        actions = new Actions(driver);
    }

    protected abstract BasePage openPage();
    protected abstract BasePage isPageOpened();

    public void waitForNumberOfElements(By locator, int NumberOfElements) {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, NumberOfElements));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            Assert.fail("Количество элементов на странице не соответствует ожидаемому числу: " + NumberOfElements);
        }
    }
}
