package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ProductNameAggregateTest {
    public Order getTestOrder() {
        Product product = mock(Product.class);
        given(product.getName()).willReturn("Pomidor");
        return new Order(Collections.singletonList(product));
    }

    @Test
    public void ProductInOrderTest() throws Exception {
        // given
        Aggregate aggregate = new ProductNameAggregate("Pomidor");

        Order order = getTestOrder();
        // when

        // then
        assertTrue(aggregate.filter(order));
    }

    @Test
    public void ProductNotInOrderTest() throws Exception {
        // given
        Aggregate aggregate = new ProductNameAggregate("Ogórek");

        Order order = getTestOrder();
        // when

        // then
        assertFalse(aggregate.filter(order));
    }
}
