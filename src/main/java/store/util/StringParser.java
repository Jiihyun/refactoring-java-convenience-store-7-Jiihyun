package store.util;

import store.domain.product.dto.request.CartProductRequest;
import store.domain.product.dto.request.CartRequest;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String PRODUCTS_DELIMITER = ",";
    private static final String PRODUCT_QUANTITY_DELIMITER = "-";
    private static final String SQUARE_BRACKET = "[\\[\\]]";
    private static final String BLANK = "";

    private StringParser() {
    }

    public static CartRequest parseCartProducts(String input) {
        List<CartProductRequest> cartRequest = Arrays.stream(input.split(PRODUCTS_DELIMITER))
                .map(StringParser::createCartProductRequest)
                .toList();
        return new CartRequest(cartRequest);
    }

    private static CartProductRequest createCartProductRequest(String product) {
        String[] data = product.replaceAll(SQUARE_BRACKET, BLANK).split(PRODUCT_QUANTITY_DELIMITER);
        String name = data[0];
        int quantity = Integer.parseInt(data[1]);
        return new CartProductRequest(name, quantity);
    }
}
