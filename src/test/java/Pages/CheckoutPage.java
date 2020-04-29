package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By ZIP_CODE = By.id("postal-code");
    private static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    private static final By CONTINUE_BUTTON = By.xpath("//input[@type='submit']");
    private static final By CHECKOUT_OVERVIEW = By.xpath("//*[contains(text(),'Checkout: Overview')]");
    private static final By ITEM_QUANTITY = By.cssSelector(".cart_item");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action");
    private static final By CONFIRMATION_HEADER = By.className("complete-header");
    private String ERROR_BUTTON_MESSAGE_WITHOUT_FN = "Error: First Name is required";
    private String ERROR_BUTTON_MESSAGE_WITHOUT_LN = "Error: Last Name is required";
    private String ERROR_BUTTON_MESSAGE_WITHOUT_ZIP = "Error: Postal Code is required";
    private static final By ERROR_BUTTON = By.tagName("h3");

    private static final String URL = "https://www.saucedemo.com/checkout-step-one.html";

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL);
    }


    public void submitForm(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(postalCode);
    }

    public void continueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void checkoutOverview() {
        Assert.assertTrue(driver.findElement(CHECKOUT_OVERVIEW).isDisplayed());
    }

    public void itemQuantity(int number) {
        Assert.assertEquals(driver.findElements(ITEM_QUANTITY).size(), number,
                "Quantity of items isn't correct");
    }

    public void finishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }
    public void confirmationHeader() {
        Assert.assertTrue(driver.findElement(CONFIRMATION_HEADER).isDisplayed());
    }
}
