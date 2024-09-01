package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.CatalogScreen;
import screens.MainScreen;
import screens.ProductScreen;
import screens.WelcomeScreen;

import static data.TestData.getTestData;

@DisplayName("Мобильные тесты на поиск товаров в приложении Ригла")
public class SearchProductTests extends TestBaseMobile {

    final WelcomeScreen welcomeScreen = new WelcomeScreen();
    final MainScreen mainScreen = new MainScreen();
    final CatalogScreen catalogScreen = new CatalogScreen();
    final ProductScreen productScreen = new ProductScreen();
    final String searchText = getTestData("search");
    final String productName = getTestData("product");

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация главного раздела")
    @Story("MOBILE: Поиск товара")
    @DisplayName("Проверка работы поиска товара по названию")
    void checkMainSearchInputTest() {
        welcomeScreen.closeWelcome();
        mainScreen
                .confirmCity()
                .searchByText(searchText);
        catalogScreen.checkProductsAreFound(searchText);
    }

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация главного раздела")
    @Story("MOBILE: Поиск товара")
    @DisplayName("Проверка открытия страницы товара из списка")
    void checkProductPageIsOpenedFromSearchListTest() {
        welcomeScreen.closeWelcome();
        mainScreen
                .confirmCity()
                .searchByText(productName);
        catalogScreen.clickToProductCard(productName);
        productScreen.checkProductName(productName);
    }
}
