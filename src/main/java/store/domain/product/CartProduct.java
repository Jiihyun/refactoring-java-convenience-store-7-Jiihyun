package store.domain.product;

public class CartProduct {

    private final Product product;
    private final int quantity;

    public CartProduct(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
