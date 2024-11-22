package store.domain.product;

import store.domain.product.dto.response.CurrentInventoryResponse;

public class Inventory {

    private final Product product;
    private final int quantity;

    public Inventory(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public CurrentInventoryResponse toCurrentInventoryResponse() {
        return new CurrentInventoryResponse(
                product.getName(),
                product.getPrice(),
                quantity,
                product.getPromotionName()
        );
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
