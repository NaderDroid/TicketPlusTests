package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage {

    private WebDriver driver;
    private By text = By.xpath("//h1[text()='Add News']");
    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewsPage(){
        WebElement element = driver.findElement(text);
        return element.isDisplayed();
    }
}
