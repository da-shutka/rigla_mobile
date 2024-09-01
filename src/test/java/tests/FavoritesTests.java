package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.*;

import static data.TestData.getTestData;

@DisplayName("Мобильные тесты на избранное в приложении Ригла")
public class FavoritesTests extends TestBaseMobile {

    final WelcomeScreen welcomeScreen = new WelcomeScreen();
    final MainScreen mainScreen = new MainScreen();
    final CatalogScreen catalogScreen = new CatalogScreen();
    final ProductScreen productScreen = new ProductScreen();
    final FavoritesScreen favouritesScreen = new FavoritesScreen();
    final String productName = getTestData("product");

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация списка избранных товаров пользователя")
    @Story("MOBILE: Добавление товара в список избранного")
    @DisplayName("Проверка добавления товара в избранное со страницы продукта")
    void checkProductAddingToFavouritesFromProductPageTest() {
        welcomeScreen.closeWelcome();
        mainScreen
                .confirmCity()
                .searchByText(productName);
        catalogScreen.clickToProductCard(productName);
        productScreen.addToFavourites();
        favouritesScreen
                .open()
                .checkAddedProductExistence(productName);
    }

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация списка избранных товаров пользователя")
    @Story("MOBILE: Добавление товара в список избранного")
    @DisplayName("Проверка добавления товара в избранное из каталога")
    void checkProductAddingToFavouritesFromCatalogTest() {
        welcomeScreen.closeWelcome();
        mainScreen
                .confirmCity()
                .searchByText(productName);
        catalogScreen.addToFavourites(productName);
        favouritesScreen
                .open()
                .checkAddedProductExistence(productName);
    }
}
