package store.domain.product;

import store.domain.product.dto.response.CurrentInventoriesResponse;
import store.domain.product.dto.response.CurrentInventoryResponse;

import java.util.ArrayList;
import java.util.List;

public class Inventories {

    private List<Inventory> inventories;

    public Inventories(final List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public void addNonPromotionInventory() {
        List<Inventory> promotionInventories = getPromotionInventories();
        this.inventories = addNoPromotionInventoryIfAbsent(promotionInventories);
    }

    public CurrentInventoriesResponse toCurrentInventoriesResponse() {
        List<CurrentInventoryResponse> currentInventories = inventories.stream()
                .map(Inventory::toCurrentInventoryResponse)
                .toList();
        return new CurrentInventoriesResponse(currentInventories);
    }

    private List<Inventory> getPromotionInventories() {
        return inventories.stream()
                .filter(inventory -> inventory.findNoPromotionProduct().isEmpty())
                .toList();
    }

    private List<Inventory> addNoPromotionInventoryIfAbsent(final List<Inventory> promotionInventories) {
        List<Inventory> newInventories = new ArrayList<>(inventories);

        promotionInventories.stream()
                .filter(this::hasNotNonPromotionProduct)
                .map(this::createNonPromotionInventory)
                .forEach(newInventories::add);
        return newInventories;
    }

    private boolean hasNotNonPromotionProduct(final Inventory inventory) {
        return inventory.findNoPromotionProduct().isEmpty();
    }

    private Inventory createNonPromotionInventory(Inventory promotionInventory) {
        Product promotionProduct = promotionInventory.getProduct();
        Product nonPromotionProduct = promotionProduct.createNonPromotionProduct();
        return new Inventory(nonPromotionProduct, 0);
    }
}
