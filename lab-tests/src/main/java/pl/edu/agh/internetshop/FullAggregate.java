package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;

public class FullAggregate implements Aggregate {
    List<Aggregate> aggregates;

    public FullAggregate(List<Aggregate> aggregates) {
        this.aggregates = aggregates;
    }

    @Override
    public boolean filter(Order order) {
        for(Aggregate aggregate : this.aggregates) {
            if (aggregate.filter(order) == false) {
                return false;
            }
        }

        return true;
    }
}
