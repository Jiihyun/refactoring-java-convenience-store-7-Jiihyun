package store.service;

import store.domain.product.Cart;
import store.domain.product.CartProduct;
import store.domain.product.Inventories;
import store.domain.product.Inventory;
import store.domain.product.Product;
import store.domain.product.dto.request.CartProductRequest;
import store.domain.product.dto.request.CartRequest;

import java.util.ArrayList;
import java.util.List;

import static store.exception.ExceptionMessage.PRODUCT_NOT_EXISTS;

public class StoreService {

    public Cart createCart(final Inventories inventories, final CartRequest cartRequest) {
        List<CartProduct> cart = new ArrayList<>();

        for (CartProductRequest request : cartRequest.cartProducts()) {
            CartProduct cartProduct = createCartProduct(inventories, request);
            cart.add(cartProduct);
        }
        return new Cart(cart);
    }

    private CartProduct createCartProduct(final Inventories inventories, final CartProductRequest cartProduct) {
        List<Inventory> products = inventories.findProductsByName(cartProduct.name());
        inventories.validateTotalQuantity(cartProduct.name(), cartProduct.quantity());
        Product product = getProduct(products);
        return new CartProduct(product, cartProduct.quantity());
    }

    private Product getProduct(final List<Inventory> inventories) {
        if (inventories.size() == 1) {
            return inventories.getFirst().getProduct();
        }
        return inventories.stream()
                .map(Inventory::getProduct)
                .filter(Product::hasPromotion)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(PRODUCT_NOT_EXISTS.getMessage()));
    }
}
