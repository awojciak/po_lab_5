package pl.edu.agh.internetshop;

import java.math.BigDecimal;

public class PriceAggregate implements Aggregate {
    private BigDecimal price;

    public PriceAggregate(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean filter(Order order) {
        return (order.getPrice()).equals(this.price);
    }
}
