package store.controller;

import store.domain.product.Cart;
import store.domain.product.Inventories;
import store.domain.product.dto.request.CartRequest;
import store.domain.product.dto.response.CurrentInventoriesResponse;
import store.service.StoreService;
import store.util.InitialDataLoader;
import store.view.InputView;
import store.view.OutputView;

import java.util.function.Supplier;

public class StoreController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InitialDataLoader initialDataLoader;
    private final StoreService storeService;

    public StoreController(final InputView inputView, final OutputView outputView, final InitialDataLoader initialDataLoader, final StoreService storeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.initialDataLoader = initialDataLoader;
        this.storeService = storeService;
    }

    public void run() {
        Inventories inventories = initialDataLoader.load();
        CurrentInventoriesResponse currentInventoriesResponse = inventories.toCurrentInventoriesResponse();
        outputView.printInventories(currentInventoriesResponse);
        Cart cart = retryOnInvalidInput(() -> createCart(inventories));
    }

    private Cart createCart(final Inventories inventories) {
        CartRequest cartRequest = inputView.readMenuAndQuantity();
        return storeService.createCart(inventories, cartRequest);
    }

    private <T> T retryOnInvalidInput(Supplier<T> input) {
        while (true) {
            try {
                return input.get();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
