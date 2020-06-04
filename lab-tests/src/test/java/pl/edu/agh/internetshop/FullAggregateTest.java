package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class FullAggregateTest {
    public Order getTestOrder() {
        Product product = mock(Product.class);
        given(product.getName()).willReturn("Pomidor");

        Address address = mock(Address.class);
        given(address.getName()).willReturn("Jan Kowalski");

        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(address);

        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        given(order.getProducts()).willReturn(Collections.singletonList(product));
        return order;
    }

    @Test
    public void OrderPassesAllAggregatesTest() throws Exception {
        // given
        List<Aggregate> partialAggregates = Arrays.asList(new ProductNameAggregate("Pomidor"), new ClientNameAggregate("Jan Kowalski"));
        Aggregate aggregate = new FullAggregate(partialAggregates);

        Order order = getTestOrder();
        // when

        // then
        assertTrue(aggregate.filter(order));
    }

    @Test
    public void OrderDoNotPassAllAggregatesTest() throws Exception {
        // given
        List<Aggregate> partialAggregates = Arrays.asList(new ProductNameAggregate("Pomidor"), new ClientNameAggregate("Janusz Nowak"));
        Aggregate aggregate = new FullAggregate(partialAggregates);

        Order order = getTestOrder();
        // when

        // then
        assertFalse(aggregate.filter(order));
    }
}
