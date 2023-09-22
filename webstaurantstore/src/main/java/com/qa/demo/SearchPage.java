package com.qa.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.id("searchval");
    By productTitles = By.cssSelector("[data-testid='itemDescription']");
    By pageLinks = By.cssSelector(".pagerLink");
    By addToCartButtons = By.cssSelector("input[value='Add to Cart']");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void searchProduct(String productName) {
        WebElement searchBoxElement = wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBoxElement.sendKeys(productName);
        searchBoxElement.submit();
    }

    public List<WebElement> getProductTitles() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitles));
        return driver.findElements(productTitles);
    }

    public void navigateToLastPage() {
        List<WebElement> pageLinksList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(pageLinks));
        pageLinksList.get(pageLinksList.size() - 2).click();
    }

    public void addLastItemToCart() {
        List<WebElement> addToCartButtonsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        if (!addToCartButtonsList.isEmpty()) {
            addToCartButtonsList.get(addToCartButtonsList.size() - 1).click();
        } else {
            System.out.println("No 'Add to Cart' buttons found.");
        }
    }
}
