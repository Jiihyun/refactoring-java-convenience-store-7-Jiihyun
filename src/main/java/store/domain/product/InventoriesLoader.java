package store.domain.product;

import store.util.StoreFileReader;

import java.util.List;

public class InventoriesLoader {

    public Inventories load() {
        List<String[]> inventoriesData = StoreFileReader.readProducts();
        List<Inventory> inventories = inventoriesData.stream()
                .map(this::convertToInventory)
                .toList();
        return new Inventories(inventories);
    }

    private Inventory convertToInventory(String[] inventoryData) {
        String name = inventoryData[0];
        int price = Integer.parseInt(inventoryData[1]);
        int quantity = Integer.parseInt(inventoryData[2]);
        String promotionName = inventoryData[3];
        Product product = new Product(name, price, promotionName);

        return new Inventory(product, quantity);
    }
}
