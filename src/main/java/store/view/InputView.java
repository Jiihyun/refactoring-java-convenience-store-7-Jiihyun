package store.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static store.exception.ExceptionMessage.INPUT_BLANK;
import static store.exception.ExceptionMessage.INVALID_FORMAT;

public class InputView {

    private static final Pattern INPUT_FORMAT = Pattern.compile("^(\\[[가-힣]+-\\d+\\])(,\\[[가-힣]+-\\d+\\])*$");

    private static final String ORDER_PRODUCT_MESSAGE = "구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])";

    public String readMenuAndQuantity() {
        String input = getValidatedInput(ORDER_PRODUCT_MESSAGE);
        validateInputFormat(input);
        return input;
    }

    private String getValidatedInput(String message) {
        System.out.println(message);
        String input = Console.readLine().strip();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }

    private void validateInputFormat(String input) {
        if (!INPUT_FORMAT.matcher(input).find()) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
