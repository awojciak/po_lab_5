package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrdersHistoryTest {
    public Order getTestOrder(String productName) {
        Product product = mock(Product.class);
        given(product.getName()).willReturn(productName);

        return new Order(Collections.singletonList(product));
    }

    @Test
    public void AddingOrdersTest() throws Exception {
        // given
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);

        OrdersHistory history = new OrdersHistory();
        history.addOrder(order1);
        history.addOrder(order2);
        // when

        // then
        assertEquals((history.getHistory()).size(), 2);
    }

    @Test
    public void GettingSomeSearchResults() throws Exception {
        // given
        Order order1 = getTestOrder("Pomidor");
        Order order2 = getTestOrder("Ogórek");

        OrdersHistory history = new OrdersHistory();
        history.addOrder(order1);
        history.addOrder(order2);

        Aggregate aggregate = new ProductNameAggregate("Ogórek");

        // when
        List<Order> results = history.useAggregate(aggregate);

        // then
        assertFalse(results.isEmpty());
    }

    @Test
    public void GettingNoSearchResults() throws Exception {
        // given
        Order order1 = getTestOrder("Pomidor");
        Order order2 = getTestOrder("Ogórek");

        OrdersHistory history = new OrdersHistory();
        history.addOrder(order1);
        history.addOrder(order2);

        Aggregate aggregate = new ProductNameAggregate("Dynia");

        // when
        List<Order> results = history.useAggregate(aggregate);

        // then
        assertTrue(results.isEmpty());
    }
}
