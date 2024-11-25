package store.domain.product;

import store.domain.product.dto.response.CurrentInventoryResponse;

import java.util.Optional;

import static store.exception.ExceptionMessage.PRODUCT_NOT_EXISTS;

public class Inventory {

    private final Product product;
    private final int quantity;

    public Inventory(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Optional<Product> findNoPromotionProduct() {
        if (product.hasNoPromotion()) {
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public Product findByName(final String name) {
        if (product.getName().equals(name)) {
            return product;
        }
        throw new IllegalArgumentException(PRODUCT_NOT_EXISTS.getMessage());
    }

    public boolean existsByName(final String name) {
        return product.getName().equals(name);
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
