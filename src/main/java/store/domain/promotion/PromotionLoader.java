package store.domain.promotion;

import store.util.StoreFileReader;

import java.time.LocalDate;
import java.util.List;

public class PromotionLoader {

    public void load() {
        List<String[]> promotionsData = StoreFileReader.readPromotions();
        promotionsData.forEach(this::convertToPromotion);
    }

    private void convertToPromotion(String[] promotionData) {
        String name = promotionData[0];
        int buy = Integer.parseInt(promotionData[1]);
        int get = Integer.parseInt(promotionData[2]);
        LocalDate startDate = LocalDate.parse(promotionData[3]);
        LocalDate endDate = LocalDate.parse(promotionData[3]);
        new Promotion(name, buy, get, startDate, endDate);
    }
}
