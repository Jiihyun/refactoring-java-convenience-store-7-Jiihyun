package store.domain.product;

public class Inventory {

    private final Product product;
    private final int quantity;

    public Inventory(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public boolean existsByName(final String name) {
        return product.getName().equals(name);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
