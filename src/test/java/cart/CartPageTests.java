package cart;

import Base.BaseTests;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartPageTests extends BaseTests {


    private CartPage cart;
    @Test
    public void testAddToCart(){

//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testAddToCart");
//        logger.log(Status.PASS , "Ticket is added to cart");
//        reports.flush();

         cart = homePage.chooseMovie();
        cart.addTicketToCart(3);
        String val = cart.verifyCartValue();
        Assert.assertEquals(val , "Price: 60.0" , "Price did not match");
    }

    @Test
    public void testEditCartQuantity(){

//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testEditCartQuantity");
//        logger.log(Status.PASS , "Cart quantity modified successfully");
//        reports.flush();

        cart.editTicketQuantity(2);
        Assert.assertEquals(cart.verifyCartValue() , "Price: 40.0" , "Value did not match");
    }

    @Test
    public void testEditWithInvalidInput(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testEditWithInvalidInput");
//        logger.log(Status.PASS , "Edit quantity field with invalid input");
//        reports.flush();

        Assert.assertEquals(cart.verifyCartValue() , "Total: 0.0" , "Value did not match");
    }

    @Test
    public void testDeleteFromCart(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testDeleteFromCart");
//        logger.log(Status.PASS , "Delete items from cart");
        cart.deleteFromCart();
        Assert.assertEquals(cart.verifyCartValue() , "Total: 0.0" , "Value did not match");
    }

    @Test
    public void testValidCoupon(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testValidCoupon");
//        logger.log(Status.PASS , "Apply valid coupon at checkout");
        Assert.assertEquals(cart.verifyCartValue() , "Total: 0.0" , "Value did not match");
    }

    @Test
    public void testInvalidCoupon(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testInvalidCoupon");
//        logger.log(Status.PASS , "Apply invalid coupon at checkout");
        Assert.assertEquals(cart.verifyCartValue() , "Total: 0.0" , "Value did not match");
    }

    @Test
    public void testDeleteValidCoupon(){
//        reports.attachReporter(reporter);
//        ExtentTest logger = reports.createTest("testDeleteValidCoupon");
//        logger.log(Status.PASS , "Delete coupon at before checkout");
        Assert.assertEquals(cart.verifyCartValue() , "Total: 0.0" , "Value did not match");
    }

}
