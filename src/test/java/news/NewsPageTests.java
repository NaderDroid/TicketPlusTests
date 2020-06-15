package news;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewsPage;

public class NewsPageTests extends BaseTests {

    @Test
    public void isNewsPage(){
        NewsPage newsPage = homePage.gotoNewsPage();
        boolean val = newsPage.isNewsPage();
        Assert.assertTrue(val , "Text not 'Add News' found");
    }

}
