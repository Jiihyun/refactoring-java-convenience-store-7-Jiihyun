package store.domain.product;

import java.util.List;

import static store.exception.ExceptionMessage.OUT_OF_STOCK;

public class Inventories {

    private List<Inventory> inventories;

    public Inventories(final List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public List<Inventory> findProductsByName(final String name) {
        return inventories.stream()
                .filter(inventory -> inventory.existsByName(name))
                .toList();
    }

    public void validateTotalQuantity(final String name, final int quantity) {
        int productTotalQuantity = getProductTotalQuantity(name);
        if (productTotalQuantity < quantity) {
            throw new IllegalArgumentException(OUT_OF_STOCK.getMessage());
        }
    }

    public Inventory createNonPromotionInventory(Inventory promotionInventory) {
        Product promotionProduct = promotionInventory.getProduct();
        Product nonPromotionProduct = promotionProduct.createNonPromotionProduct();
        return new Inventory(nonPromotionProduct, 0);
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    private int getProductTotalQuantity(final String name) {
        return inventories.stream()
                .filter(inventory -> inventory.existsByName(name))
                .mapToInt(Inventory::getQuantity)
                .sum();
    }
}
