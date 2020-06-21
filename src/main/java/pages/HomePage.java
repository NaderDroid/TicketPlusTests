package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {


    private WebDriver driver;
    private By movie = By.cssSelector("div#content>div:nth-of-type(2)>div>div>a>img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage chooseMovie(){
        driver.findElement(movie).click();
        return new CartPage(driver);
    }

    public NewsPage gotoNewsPage(){
        clickLink("NEWS");
        return new NewsPage(driver);
    }

    public void clickLink(String identifier) {
        driver.findElement(By.linkText(identifier)).click();
    }

}
