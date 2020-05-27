package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    private static final By CART = By.xpath("//button[contains(text(),'Open Menu')]");
    private static final By MENU = By.id("shopping_cart_container");

    public BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }
    public void waitForNumberOfElements(By locator, int NumberOfElements) {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, NumberOfElements));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            Assert.fail("Количество элементов на странице не соответствует ожидаемому числу: " + NumberOfElements);
        }
    }
}
//1189668969