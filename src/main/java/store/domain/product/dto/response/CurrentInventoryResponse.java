package store.domain.product.dto.response;

public record CurrentInventoryResponse(
        String name,
        int price,
        int quantity,
        String promotionName
) {
}
