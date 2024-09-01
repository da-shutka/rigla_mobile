package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.*;

import static data.TestData.getTestData;

@DisplayName("Мобильные тесты на корзину в приложении Ригла")
public class CartTests extends TestBaseMobile {

    final WelcomeScreen welcomeScreen = new WelcomeScreen();
    final MainScreen mainScreen = new MainScreen();
    final CatalogScreen catalogScreen = new CatalogScreen();
    final ProductScreen productScreen = new ProductScreen();
    final CartScreen cartScreen = new CartScreen();
    final String productName = getTestData("product");

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация корзины пользователя с товарами")
    @Story("MOBILE: Добавление товара в корзину")
    @DisplayName("Проверка добавления товара в корзину со страницы продукта")
    void checkProductAddingToCartFromProductCardTest() {
        welcomeScreen.closeWelcome();
        mainScreen
                .confirmCity()
                .searchByText(productName);
        catalogScreen.clickToProductCard(productName);
        productScreen
                .addToCart()
                .goToCart();
        cartScreen.checkAddedProductExistence(productName);
    }

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация корзины пользователя с товарами")
    @Story("MOBILE: Добавление товара в корзину")
    @DisplayName("Проверка добавления товара в корзину из каталога")
    void checkProductAddingToCartFromCatalogTest() {
        welcomeScreen.closeWelcome();
        mainScreen
                .confirmCity()
                .searchByText(productName);
        catalogScreen.addToCart();
        cartScreen
                .open()
                .checkAddedProductExistence(productName);
    }
}
