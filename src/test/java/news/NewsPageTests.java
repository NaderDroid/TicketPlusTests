package news;

import Base.BaseTests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewsPage;

public class NewsPageTests extends BaseTests {
    @Test
    public void isNewsPage(){

        //reports.attachReporter(reporter);
        //ExtentTest logger = reports.createTest("goToNewsPage");
        //logger.log(Status.PASS , "Navigate to NEWS page");
        //reports.flush();
        NewsPage newsPage = homePage.gotoNewsPage();
        boolean val = newsPage.isNewsPage();
        Assert.assertTrue(val , "Text not 'Add News' found");
    }

    @Test
    public void addNewNews(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("addNewNews");
//        logger.log(Status.PASS , "Navigate to NEWS page");
//        reports.flush();
        NewsPage newsPage = homePage.gotoNewsPage();
        newsPage.addNews("Nader" , "Hello world");
    }

    @Test
    public void addNewsWithoutHeading(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("addNewsWithoutHeading");
//        logger.log(Status.FAIL , "News is added without title");
//        reports.flush();
        NewsPage newsPage = homePage.gotoNewsPage();
        newsPage.addNewsWithoutHeading("Hello world");
        Assert.assertEquals("a" , "b" , "News without a title is added");
    }

    @Test
    public void addNewsWithoutBody(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("addNewsWithoutBody");
//        logger.log(Status.FAIL , "News is added without body");
//        reports.flush();
        NewsPage newsPage = homePage.gotoNewsPage();
        newsPage.addNewsWithoutBody("Nader");
        Assert.assertEquals("a" , "b" , "News without a body is added");

    }

}
