package pl.edu.agh.internetshop;

public class ClientNameAggregate implements Aggregate {
    private String name;

    public ClientNameAggregate(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        return (((order.getShipment()).getRecipientAddress()).getName()).equals(this.name);
    }
}
