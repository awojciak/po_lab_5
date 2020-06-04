package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;

public class OrdersHistory {
    private List<Order> history = new ArrayList<>();

    public List<Order> getHistory() {
        return this.history;
    }

    public void addOrder(Order order) {
        this.history.add(order);
    }

    public List<Order> useAggregate(Aggregate aggregate) {
        List<Order> filtered = new ArrayList<>();

        for(Order order : this.history) {
            if(aggregate.filter(order)) {
                filtered.add(order);
            }
        }

        return filtered;
    }
}
