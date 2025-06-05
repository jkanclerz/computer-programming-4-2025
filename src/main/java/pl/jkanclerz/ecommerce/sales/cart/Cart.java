package pl.jkanclerz.ecommerce.sales.cart;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    public static Cart empty() {
        return new Cart();
    }
    private final HashMap<String, Integer> productsQuantities;

    public Cart() {
        productsQuantities = new HashMap<>();
    }

    public void add(String product) {
        if (!isInCart(product)) {
            putIntoCart(product);
        } else {
            increaseProductQuantity(product);
        }
    }

    public boolean isEmpty() {
        return productsQuantities.values().isEmpty();
    }

    public int getItemsCount() {
        return productsQuantities.values().size();
    }

    public List<CartItem> getCartItems() {
        return productsQuantities
                .entrySet()
                .stream()
                .map(es -> new CartItem(es.getKey(), es.getValue()))
                .collect(Collectors.toList());
    }

    private void putIntoCart(String product) {
        productsQuantities.put(product, 1);
    }

    private void increaseProductQuantity(String product) {
        productsQuantities.put(product, productsQuantities.get(product) + 1);
    }

    private boolean isInCart(String product) {
        return productsQuantities.containsKey(product);
    }
}
