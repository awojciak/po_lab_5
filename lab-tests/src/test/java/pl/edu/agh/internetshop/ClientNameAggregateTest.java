package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ClientNameAggregateTest {
    public Order getTestOrder() {
        Address address = mock(Address.class);
        given(address.getName()).willReturn("Jan Kowalski");

        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(address);

        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);

        return order;
    }

    @Test
    public void ClientNameInOrderTest() throws Exception {
        // given
        Aggregate aggregate = new ClientNameAggregate("Jan Kowalski");

        Order order = getTestOrder();
        // when

        // then
        assertTrue(aggregate.filter(order));
    }

    @Test
    public void ClientNameNotInOrderTest() throws Exception {
        // given
        Aggregate aggregate = new ClientNameAggregate("Janusz Nowak");

        Order order = getTestOrder();
        // when

        // then
        assertFalse(aggregate.filter(order));
    }
}
