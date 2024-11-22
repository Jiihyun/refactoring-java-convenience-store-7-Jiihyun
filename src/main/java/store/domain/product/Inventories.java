package store.domain.product;

import store.domain.product.dto.response.CurrentInventoriesResponse;
import store.domain.product.dto.response.CurrentInventoryResponse;

import java.util.List;

public class Inventories {

    private List<Inventory> inventories;

    public Inventories(final List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public CurrentInventoriesResponse toCurrentInventoriesResponse() {
        List<CurrentInventoryResponse> currentInventories = inventories.stream()
                .map(Inventory::toCurrentInventoryResponse)
                .toList();
        return new CurrentInventoriesResponse(currentInventories);
    }
}
