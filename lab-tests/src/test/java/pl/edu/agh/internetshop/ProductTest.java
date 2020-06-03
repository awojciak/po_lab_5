package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testSettingDiscount() throws Exception {
        //given

        // when
        Product product = new Product(NAME, PRICE);
        BigDecimal discount = BigDecimal.valueOf(0.911);
        product.setDiscount(discount);

        // then
        assertBigDecimalCompareValue(product.getDiscount(), discount);
    }

    @Test
    public void testProductPriceWhenDiscount() throws Exception {
        //given

        // when
        Product product = new Product(NAME, PRICE);
        BigDecimal discount = BigDecimal.valueOf(0.911);
        product.setDiscount(discount);
        BigDecimal expectedPrice = PRICE.subtract(PRICE.multiply(discount));

        // then
        assertBigDecimalCompareValue(product.getPrice(), expectedPrice);
    }
}