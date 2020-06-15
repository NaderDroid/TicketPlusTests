package Base;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;


public class BaseTests {
    protected HomePage homePage;
    String currentUsersHomeDir = System.getProperty("user.home");
    private WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", currentUsersHomeDir + "/selenium_drivers/chromedriver");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", currentUsersHomeDir + "/selenium_drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.Opera.driver", currentUsersHomeDir + "/selenium_drivers/operadriver");
            driver = new OperaDriver();
        }

        driver.get("http://localhost:8080");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }
}
