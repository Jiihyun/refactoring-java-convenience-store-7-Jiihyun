package store.domain.product;

public class Product {

    private static final String NON_PROMOTION = "null";

    private final String name;
    private final int price;
    private final String promotionName;

    public Product(final String name, final int price, final String promotionName) {
        this.name = name;
        this.price = price;
        this.promotionName = promotionName;
    }

    public boolean hasNoPromotion() {
        return NON_PROMOTION.equals(promotionName);
    }

    public Product createNonPromotionProduct() {
        return new Product(
                name,
                price,
                NON_PROMOTION
        );
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getPromotionName() {
        return promotionName;
    }
}
