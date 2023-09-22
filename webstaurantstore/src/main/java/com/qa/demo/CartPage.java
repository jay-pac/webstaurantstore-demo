package com.qa.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    By viewCartButton = By.cssSelector(".btn.btn-small.btn-primary");
    By emptyCartButton = By.cssSelector(".emptyCartButton");
    By confirmEmptyCartButton = By.xpath("//*[@id='td']/div[11]/div/div/div/footer/button[1]");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void viewCart() {
        WebElement viewCartElement = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartElement.click();
    }

    public void emptyCart() {
        WebElement emptyCartElement = wait.until(ExpectedConditions.elementToBeClickable(emptyCartButton));
        emptyCartElement.click();
    }

    public void confirmEmptyCart() {
        WebElement confirmEmptyCartElement = wait.until(ExpectedConditions.elementToBeClickable(confirmEmptyCartButton));
        confirmEmptyCartElement.click();
    }
}
