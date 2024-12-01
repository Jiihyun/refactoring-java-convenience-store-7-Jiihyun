package store.domain.product.dto.response;

import store.domain.product.Inventories;

import java.util.List;

public record CurrentInventoriesResponse(
        List<CurrentInventoryResponse> currentInventories
) {
    public static CurrentInventoriesResponse from(Inventories inventories) {
        List<CurrentInventoryResponse> currentInventories = inventories.getInventories()
                .stream()
                .map(CurrentInventoryResponse::from)
                .toList();
        return new CurrentInventoriesResponse(currentInventories);
    }
}
