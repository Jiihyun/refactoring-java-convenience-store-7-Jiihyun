package store.domain.product.dto.response;

import store.domain.product.Inventory;

public record CurrentInventoryResponse(
        String name,
        int price,
        int quantity,
        String promotionName
) {
    public static CurrentInventoryResponse from(Inventory inventory) {
        return new CurrentInventoryResponse(
                inventory.getProduct().getName(),
                inventory.getProduct().getPrice(),
                inventory.getQuantity(),
                inventory.getProduct().getPromotionName()
        );
    }
}
