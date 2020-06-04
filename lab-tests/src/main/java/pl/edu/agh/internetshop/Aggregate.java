package pl.edu.agh.internetshop;

public interface Aggregate {
    boolean filter(Order order);
}
