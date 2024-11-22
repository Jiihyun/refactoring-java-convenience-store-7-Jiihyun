package store.exception;

import static java.lang.String.format;

public enum ExceptionMessage {

    FILE_NOT_EXISTS("파일이 존재하지 않습니다."),
    INVALID_NUMBER("숫자 외의 문자가 들어있습니다."),
    INPUT_BLANK("잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_FORMAT("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요."),
    PRODUCT_NOT_EXISTS("존재하지 않는 상품입니다. 다시 입력해 주세요."),
    OUT_OF_STOCK("재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요."),
    PROMOTION_NOT_FOUND("해당되는 프로모션이 존재하지 않습니다."),
    INVALID_YES_NO_MSG("Y 또는 N을 입력해주세요.");

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final String message;

    ExceptionMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return format(message);
    }
}
