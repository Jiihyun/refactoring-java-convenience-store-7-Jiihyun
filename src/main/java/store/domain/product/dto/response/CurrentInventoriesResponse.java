package store.domain.product.dto.response;

import java.util.List;

public record CurrentInventoriesResponse(
        List<CurrentInventoryResponse> currentInventories
) {
}
