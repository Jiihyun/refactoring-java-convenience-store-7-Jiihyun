package store.domain.product;

import store.util.StoreFileReader;

import java.util.ArrayList;
import java.util.List;

public class InventoriesLoader {

    public Inventories load() {
        List<String[]> inventoriesData = StoreFileReader.readProducts();
        List<Inventory> inventoriesWithoutNonPromotion = inventoriesData.stream()
                .map(this::convertToInventory)
                .toList();
        Inventories inventories = new Inventories(inventoriesWithoutNonPromotion);
        List<Inventory> finalInventories = getFinalInventories(inventories);
        return new Inventories(finalInventories);
    }

    private Inventory convertToInventory(String[] inventoryData) {
        String name = inventoryData[0];
        int price = Integer.parseInt(inventoryData[1]);
        int quantity = Integer.parseInt(inventoryData[2]);
        String promotionName = inventoryData[3];
        Product product = new Product(name, price, promotionName);

        return new Inventory(product, quantity);
    }

    private static List<Inventory> getFinalInventories(final Inventories inventories) {
        List<Inventory> finalInventories = new ArrayList<>();
        for (Inventory inventory : inventories.getInventories()) {
            String productName = inventory.getProductName();
            finalInventories.add(inventory);
            List<Inventory> products = inventories.findProductsByName(productName);
            if (products.size() == 1 && products.getFirst().getProduct().hasPromotion()) {
                finalInventories.add(inventories.createNonPromotionInventory(inventory));
            }
        }
        return finalInventories;
    }
}
