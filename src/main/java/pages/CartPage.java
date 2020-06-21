package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private By quantityField = By.name("quantity");
    private By addButton = By.cssSelector(".button");
    private By editButton = By.cssSelector("input.button:nth-child(4)");
    private By price = By.className("price");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTicketToCart(int quantity){

        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(Integer.toString(quantity));
        driver.findElement(addButton).click();
    }

    public void editTicketQuantity(int quantity){
        driver.findElement(By.linkText("CART")).click();
        driver.findElement(quantityField).clear();
        driver.findElement(quantityField).sendKeys(Integer.toString(quantity));
        driver.findElement(editButton).click();
    }

    public String verifyCartValue(){
        return driver.findElement(price).getText();
    }
}
