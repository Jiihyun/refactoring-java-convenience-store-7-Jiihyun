package store.domain.product;

public class Inventory {

    private final Product product;
    private final int quantity;

    public Inventory(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
