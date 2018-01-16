package com.project.webstore.domain;
import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * CART ITEM TEST 
 * @author hien
 *
 */
public class CartItemTest {

    private CartItem cartItem;
    // set up 
    @Before
    public void setup() {
        cartItem = new CartItem("1");
    }

    @Test
    public void cartItem_total_price_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
        //Arrange
        Product iphone = new Product("P1234","Java Programming", new BigDecimal(500));
        cartItem.setProduct(iphone);

        //Act
        BigDecimal totalPrice = cartItem.getTotalPrice();

        //Assert
        Assert.assertEquals(iphone.getPrice(), totalPrice);
    }
}
