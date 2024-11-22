package store.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static store.exception.ExceptionMessage.FILE_NOT_EXISTS;

public class StoreFileReader {

    public static final String PRODUCTS_PATH = "src/main/resources/products.md";
    public static final String PROMOTIONS_PATH = "src/main/resources/promotions.md";

    private static final String DELIMITER = ",";
    private static final int CONTENT_START_LINE = 1;


    public static List<String[]> readProducts() {
        return readAllLines(PRODUCTS_PATH);
    }

    public static List<String[]> readPromotions() {
        return readAllLines(PROMOTIONS_PATH);
    }

    private static List<String[]> readAllLines(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            return br.lines()
                    .skip(CONTENT_START_LINE)
                    .map(line -> line.split(DELIMITER))
                    .toList();
        } catch (IOException e) {
            throw new IllegalStateException(FILE_NOT_EXISTS.getMessage());
        }
    }
}
