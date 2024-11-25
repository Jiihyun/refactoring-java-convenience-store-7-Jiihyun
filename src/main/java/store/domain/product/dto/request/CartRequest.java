package store.domain.product.dto.request;

import java.util.List;

public record CartRequest(List<CartProductRequest> cartProducts) {
}
