package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPage {

    private WebDriver driver;
    private By text = By.xpath("//h1[text()='Add News']");
    private By titleField = By.xpath("//input[@value='Heading']");
    private By bodyField = By.tagName("textarea");
    public NewsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNewsPage(){
        WebElement element = driver.findElement(text);
        return element.isDisplayed();
    }

    public void addNews(String title, String body){
        WebElement titleElement = driver.findElement(titleField);
        WebElement bodyElement = driver.findElement(bodyField);
        titleElement.clear();
        bodyElement.clear();
        titleElement.sendKeys(title);
        bodyElement.sendKeys(body);
    }

}
