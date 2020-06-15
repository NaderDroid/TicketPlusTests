package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTests {
    protected HomePage homePage;
    String currentUsersHomeDir = System.getProperty("user.home");
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", currentUsersHomeDir + "/selenium_drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
