package store.util;

import store.domain.product.Inventories;
import store.domain.product.InventoriesLoader;
import store.domain.promotion.PromotionLoader;

public class InitialDataLoader {

    private final InventoriesLoader inventoriesLoader;
    private final PromotionLoader promotionLoader;

    public InitialDataLoader() {
        inventoriesLoader = new InventoriesLoader();
        promotionLoader = new PromotionLoader();
    }

    public Inventories load() {
        promotionLoader.load();
        return inventoriesLoader.load();
    }
}
