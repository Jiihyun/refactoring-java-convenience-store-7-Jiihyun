package store.view;

import store.domain.product.dto.response.CurrentInventoriesResponse;
import store.domain.product.dto.response.CurrentInventoryResponse;

public class OutputView {

    private static final String PRINT_INVENTORIES_MSG = """
            안녕하세요. W편의점입니다.
            현재 보유하고 있는 상품입니다.
            """;
    private static final String DISPLAY_PRODUCTS_FORMAT = "- %s %,d원 %s %s%n";

    public void printError(String error) {
        System.out.println(error);
    }

    public void printInventories(final CurrentInventoriesResponse response) {
        System.out.println(PRINT_INVENTORIES_MSG);
        response.currentInventories().forEach(this::printProduct);
    }

    private void printProduct(CurrentInventoryResponse inventory) {
        System.out.printf(OutputView.DISPLAY_PRODUCTS_FORMAT,
                inventory.name(),
                inventory.price(),
                getQuantity(inventory.quantity()),
                getPromotionName(inventory.promotionName()));
    }

    private String getPromotionName(String promotionName) {
        if (promotionName.equals("null")) {
            promotionName = "";
        }
        return promotionName;
    }

    private String getQuantity(int quantity) {
        String stockStatus = quantity + "개";
        if (quantity == 0) {
            stockStatus = "재고 없음";
        }
        return stockStatus;
    }
}
