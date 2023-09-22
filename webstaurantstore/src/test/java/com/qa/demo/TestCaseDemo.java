package com.qa.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class TestCaseDemo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 10 seconds wait

        driver.get("https://www.webstaurantstore.com/");
        
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("searchval")));
        searchBox.sendKeys("stainless work table");
        searchBox.submit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='itemDescription']")));
        
        List<WebElement> productTitles = driver.findElements(By.cssSelector("[data-testid='itemDescription']"));
        for (WebElement title : productTitles) {
            if (!title.getText().contains("Table")) {
                System.out.println("Product does not contain 'Table' in its title: " + title.getText());
            }
        }

        List<WebElement> pageLinks = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".pagerLink")));
        
        // Click the last page link
        pageLinks.get(pageLinks.size() - 2).click();
        
        // Replaced XPath with CSS selector
        List<WebElement> addToCartButtons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[value='Add to Cart']")));

        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(addToCartButtons.size() - 1).click();
        } else {
            System.out.println("No 'Add to Cart' buttons found.");
        }

        WebElement viewCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-small.btn-primary")));
        viewCartButton.click();


        WebElement emptyCartButton =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".emptyCartButton")));
        emptyCartButton.click();

        WebElement confirmEmptyCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='td']/div[11]/div/div/div/footer/button[1]")));
        confirmEmptyCartButton.click();
        
        driver.quit();
    }
}