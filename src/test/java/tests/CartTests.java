package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static tests.TestData.productName;

@DisplayName("Мобильные тесты на корзину в Ригле")
@Tag("MOBILE")
public class CartTests extends TestBase {

    FirstWelcomePage firstWelcomePage = new FirstWelcomePage();
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация корзины пользователя с товарами")
    @Story("MOBILE: Добавление товара в корзину")
    @DisplayName("Проверка добавления товара в корзину из каталога")
    void checkProductAdditionToCartFromCatalog() {
        firstWelcomePage.closeWelcome();
        mainPage
                .confirmCity()
                .searchByText(productName);
        catalogPage.addToCart();
        cartPage
                .openPage()
                .checkAddedProductExistence(productName);
    }

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация корзины пользователя с товарами")
    @Story("MOBILE: Добавление товара в корзину")
    @DisplayName("Проверка добавления товара в корзину со страницы продукта")
    void checkProductAdditionToCartFromProductCard() {
        firstWelcomePage.closeWelcome();
        mainPage
                .confirmCity()
                .searchByText(productName);
        catalogPage.clickToProductCard(productName);
        productPage
                .addToCart()
                .goToCart();
        cartPage.checkAddedProductExistence(productName);
    }
}
