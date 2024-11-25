package store.domain.product;

import store.domain.product.dto.response.CurrentInventoriesResponse;
import store.domain.product.dto.response.CurrentInventoryResponse;

import java.util.ArrayList;
import java.util.List;

import static store.exception.ExceptionMessage.OUT_OF_STOCK;

public class Inventories {

    private List<Inventory> inventories;

    public Inventories(final List<Inventory> inventories) {
        this.inventories = inventories;
    }

//    public void addNonPromotionInventory() {
//        List<Inventory> promotionInventories = getPromotionInventories();
//        this.inventories = addNoPromotionInventoryIfAbsent(promotionInventories);
//    }

    public CurrentInventoriesResponse toCurrentInventoriesResponse() {
        List<CurrentInventoryResponse> currentInventories = inventories.stream()
                .map(Inventory::toCurrentInventoryResponse)
                .toList();
        return new CurrentInventoriesResponse(currentInventories);
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

   private int getProductTotalQuantity(final String name) {
    return inventories.stream()
            .filter(inventory -> inventory.existsByName(name))
            .mapToInt(Inventory::getQuantity)
            .sum();
}

    private List<Inventory> getPromotionInventories() {
        return inventories.stream()
                .filter(inventory -> inventory.findNoPromotionProduct().isEmpty())
                .toList();
    }

//    private List<Inventory> addNoPromotionInventoryIfAbsent(final List<Inventory> promotionInventories) {
//        List<Inventory> newInventories = new ArrayList<>(inventories);
//        for (Inventory inventory : newInventories) {
//            String productName = inventory.getProduct().getName();
//            if()
//        }
//
////        promotionInventories.stream()
////                .filter(this::hasNotNonPromotionProduct)
////                .map(this::createNonPromotionInventory)
////                .forEach(newInventories::add);
//        return newInventories;
//    }

    public Inventory createNonPromotionInventory(Inventory promotionInventory) {
        Product promotionProduct = promotionInventory.getProduct();
        Product nonPromotionProduct = promotionProduct.createNonPromotionProduct();
        return new Inventory(nonPromotionProduct, 0);
    }
}
