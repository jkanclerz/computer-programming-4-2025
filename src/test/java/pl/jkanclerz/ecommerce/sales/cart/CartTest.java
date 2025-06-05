package pl.jkanclerz.ecommerce.sales.cart;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {
    public static final String PRODUCT_1 = "lego-8297";
    public static final String PRODUCT_2 = "lego-8298";

    @Test
    public void newlyCreateCartIsEmpty() {
        Cart cart = Cart.empty();

        assertThat(cart.isEmpty())
                .isTrue();
    }

    @Test
    public void cartWithProductsIsNotEmpty() {
        //Arrange
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);
        //Act
        cart.add(productId);

        //Assert
        assertThat(cart.isEmpty())
                .isFalse();
    }

    @Test
    public void itExposeProductsCount() {
        //Arrange
        Cart cart = Cart.empty();
        String product1 = thereIsProduct(PRODUCT_1);
        String product2 = thereIsProduct(PRODUCT_2);
        //Act
        cart.add(product1);
        cart.add(product2);

        //Assert
        assertThat(cart.getItemsCount())
                .isEqualTo(2);
    }

    @Test
    public void itShowsSingleLineWhenSameProductsAddedTwice() {
        //Arrange
        Cart cart = Cart.empty();
        String product1 = thereIsProduct(PRODUCT_1);
        //Act
        cart.add(product1);
        cart.add(product1);

        //Assert
        assertThat(cart.getItemsCount())
                .isEqualTo(1);

        assertCartContainsProductWithQuantity(cart, product1, 2);
    }

    @Test
    public void itStoreQuantityOfMultipleProducts() {
        //Arrange
        Cart cart = Cart.empty();
        String product1 = thereIsProduct(PRODUCT_1);
        String product2 = thereIsProduct(PRODUCT_2);
        //Act
        cart.add(product1);
        cart.add(product1);
        cart.add(product2);

        //Assert
        assertThat(cart.getItemsCount()).isEqualTo(2);

        assertCartContainsProductWithQuantity(cart, product1, 2);
        assertCartContainsProductWithQuantity(cart, product2, 1);
    }

    private void assertCartContainsProductWithQuantity(Cart cart, String product1, int expectedQuantity) {
        assertThat(cart.getCartItems())
                .filteredOn(cartItem -> cartItem.getProductId().equals(product1))
                .extracting(CartItem::getQuantity)
                .first()
                .isEqualTo(expectedQuantity)
        ;
    }

    private String thereIsProduct(String productName) {
        return productName;
    }
}
