package store.domain.product.dto.request;

public record CartProductRequest(
        String name,
        int quantity
) {
}
