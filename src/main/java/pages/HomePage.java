package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public NewsPage gotoNewsPage(){
        clickLink("NEWS");
        return new NewsPage(driver);
    }
    public void clickLink(String identifier) {
        driver.findElement(By.linkText(identifier)).click();
    }

}
