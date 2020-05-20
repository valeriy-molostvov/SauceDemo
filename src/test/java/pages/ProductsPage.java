package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final String ADD_TO_CART_CSS = ".btn_inventory";
    private static final String CART_CSS = ".shopping_cart_link";
    private static final String URL = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage openPage() {
        driver.get(URL);
        isPageOpened();
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        waitForNumberOfElements(By.cssSelector(ADD_TO_CART_CSS), 6);
        return this;
    }

    public CartPage clickCart() {
        driver.findElement(By.cssSelector(CART_CSS)).click();
        return new CartPage(driver);
    }

    public ProductsPage addToCart(String productName) {
        isPageOpened();
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        return this;
    }
}
