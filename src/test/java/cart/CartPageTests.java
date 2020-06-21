package cart;

import Base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;

public class CartPageTests extends BaseTests {

    private CartPage cart;
    @Test
    public void testAddToCart(){
         cart = homePage.chooseMovie();
        cart.addTicketToCart(3);
        String val = cart.verifyCartValue();
        Assert.assertEquals(val , "Price: 60.0" , "Price did not match");
    }

    @Test
    public void testEditCartQuantity(){
        cart.editTicketQuantity(2);
        Assert.assertEquals(cart.verifyCartValue() , "Price: 40.0" , "Value did not match");
    }
}
