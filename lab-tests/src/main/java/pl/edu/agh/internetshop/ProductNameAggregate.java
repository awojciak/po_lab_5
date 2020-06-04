package pl.edu.agh.internetshop;

public class ProductNameAggregate implements Aggregate {
    private String name;

    public ProductNameAggregate(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Order order) {
        for(Product product : order.getProducts()) {
            if((product.getName()).equals(this.name)) {
                return true;
            }
        }

        return false;
    }
}
