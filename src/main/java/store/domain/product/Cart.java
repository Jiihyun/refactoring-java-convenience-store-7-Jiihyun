package store.domain.product;

import java.util.List;

public class Cart {

     private final List<CartProduct> cart;

    public Cart(List<CartProduct> cart) {
        this.cart = cart;
    }

    public List<CartProduct> getCart() {
        return cart;
    }
}


