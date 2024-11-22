package store.controller;

import store.domain.product.Inventories;
import store.domain.product.dto.response.CurrentInventoriesResponse;
import store.util.InitialDataLoader;
import store.view.InputView;
import store.view.OutputView;

public class StoreController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InitialDataLoader initialDataLoader;

    public StoreController(final InputView inputView, final OutputView outputView, final InitialDataLoader initialDataLoader) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initialDataLoader = initialDataLoader;
    }

    public void run() {
        Inventories inventories = initialDataLoader.load();
        CurrentInventoriesResponse currentInventoriesResponse = inventories.toCurrentInventoriesResponse();
        outputView.printInventories(currentInventoriesResponse);
    }
}
