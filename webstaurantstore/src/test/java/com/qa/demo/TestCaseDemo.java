package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestCaseDemo {
    @Test
    public void testCaseDemo() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        SearchPage searchPage = new SearchPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        driver.get("https://www.webstaurantstore.com/");

        // Search for the product
        searchPage.searchProduct("stainless work table");

        // Verify product titles
        List<WebElement> titles = searchPage.getProductTitles();
        for (WebElement title : titles) {
            if (!title.getText().contains("Table")) {
                System.out.println("Product does not contain 'Table' in its title: " + title.getText());
            }
        }

        // Navigate to the last page
        searchPage.navigateToLastPage();

        // Add the last item to the cart
        searchPage.addLastItemToCart();

        // View and empty the cart
        cartPage.viewCart();
        cartPage.emptyCart();
        cartPage.confirmEmptyCart();

        // Verify that the cart is empty
        String actualMessage = cartPage.getEmptyCartMessage();
        assertEquals("Your cart is empty.", actualMessage);

        driver.quit();
    }
}