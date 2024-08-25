package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CatalogPage;
import pages.FirstWelcomePage;
import pages.MainPage;
import pages.ProductPage;

import static tests.TestData.productName;
import static tests.TestData.searchText;

@DisplayName("Мобильные тесты на поиск товаров в Ригле")
@Tag("MOBILE")
public class SearchProductTests extends TestBase {

    FirstWelcomePage firstWelcomePage = new FirstWelcomePage();
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    ProductPage productPage = new ProductPage();

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация главного раздела")
    @Story("MOBILE: Поиск товара")
    @DisplayName("Проверка работы поиска товара по названию")
    void checkMainSearchInputTest() {
        firstWelcomePage.closeWelcome();
        mainPage
                .confirmCity()
                .searchByText(searchText);
        catalogPage.checkProductsAreFound(searchText);
    }

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация главного раздела")
    @Story("MOBILE: Поиск товара")
    @DisplayName("Проверка открытия страницы товара из списка")
    void checkProductPageIsOpenedFromSearchListTest() {
        firstWelcomePage.closeWelcome();
        mainPage
                .confirmCity()
                .searchByText(productName);
        catalogPage.clickToProductCard(productName);
        productPage.checkProductName(productName);
    }
}
