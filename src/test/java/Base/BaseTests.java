package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;


public class BaseTests {
    protected HomePage homePage;
    private WebDriver driver;
    public static ExtentHtmlReporter reporter;
    public ThreadLocal <ExtentReports> reports = new ThreadLocal<>();

    @BeforeSuite
    public synchronized void setUpReport() throws IOException {
        reporter = new ExtentHtmlReporter("/Users/naderalthubaity/Desktop/reports/main.html");
        reporter.config().setDocumentTitle("TicketPlus Application");
        reporter.config().setReportName("TicketPlus Application");
        reports.set(new ExtentReports());
        reports.get().attachReporter(reporter);


    }
    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }
        else {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        WebDriverRunner.setWebDriver(driver);
        open("http://localhost:8080");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
    }
}
