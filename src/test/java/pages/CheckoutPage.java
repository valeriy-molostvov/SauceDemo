package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@type='submit']");
    private static final By CHECKOUT_OVERVIEW = By.xpath("//*[contains(text(),'Checkout: Overview')]");
    private static final By ITEM_QUANTITY = By.cssSelector(".cart_item");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action");
    private static final By CONFIRMATION_HEADER = By.className("complete-header");
    private static final String URL = "https://www.saucedemo.com/checkout-step-one.html";
    private static final By CHECKOUT_INFO = By.className("checkout_info");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutPage openPage() {
        driver.get(URL);
        isPageOpened();
        return this;
    }

    @Override
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_INFO));
        return this;
    }

    public void submitForm(String firstName, String lastName, String zipCode) {
        if (!firstName.equals("")) {
            driver.findElement(FIRST_NAME).sendKeys(firstName);
        }
        if (!lastName.equals("")) {
            driver.findElement(LAST_NAME).sendKeys(lastName);
        }
        if (!zipCode.equals("")) {
            driver.findElement(ZIP_CODE).sendKeys(zipCode);
        }
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void checkoutOverview() {
        Assert.assertTrue(driver.findElement(CHECKOUT_OVERVIEW).isDisplayed());
    }

    public void validationItemQuantity(int number) {
        Assert.assertEquals(driver.findElements(ITEM_QUANTITY).size(), number,
                "Quantity is invalid");
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void validationConfirmationHeader() {
        Assert.assertTrue(driver.findElement(CONFIRMATION_HEADER).isDisplayed());
    }
}
