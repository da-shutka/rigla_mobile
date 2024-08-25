package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

import static tests.TestData.productName;

@DisplayName("Мобильные тесты на избранное в приложении Ригла")
public class FavouritesTests extends TestBase {

    FirstWelcomePage firstWelcomePage = new FirstWelcomePage();
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();
    FavouritesPage favouritesPage = new FavouritesPage();

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация списка избранных товаров пользователя")
    @Story("MOBILE: Добавление товара в список избранного")
    @DisplayName("Проверка добавления товара в избранное со страницы продукта")
    void checkProductAdditionToFavouritesFromProductPage() {
        firstWelcomePage.closeWelcome();
        mainPage
                .confirmCity()
                .searchByText(productName);
        catalogPage.clickToProductCard(productName);
        productPage.addToFavourites();
        favouritesPage
                .openPage()
                .checkAddedProductExistence(productName);
    }

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация списка избранных товаров пользователя")
    @Story("MOBILE: Добавление товара в список избранного")
    @DisplayName("Проверка добавления товара в избранное из каталога")
    void checkProductAdditionToFavouritesFromCatalog() {
        firstWelcomePage.closeWelcome();
        mainPage
                .confirmCity()
                .searchByText(productName);
        catalogPage.addToFavourites(productName);
        favouritesPage
                .openPage()
                .checkAddedProductExistence(productName);
    }
}
