package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PriceAggregateTest {
    public Order getTestOrder() {
        Order order = mock(Order.class);
        given(order.getPrice()).willReturn(BigDecimal.valueOf(21.37));
        return order;
    }

    @Test
    public void PriceInOrderTest() throws Exception {
        // given
        Aggregate aggregate = new PriceAggregate(BigDecimal.valueOf(21.37));

        Order order = getTestOrder();
        // when

        // then
        assertTrue(aggregate.filter(order));
    }

    @Test
    public void PriceNotInOrderTest() throws Exception {
        // given
        Aggregate aggregate = new PriceAggregate(BigDecimal.valueOf(9.11));

        Order order = getTestOrder();
        // when

        // then
        assertFalse(aggregate.filter(order));
    }
}
