package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class CatalogPage {

    @Step("Проверить, что страница называется 'Результаты поиска' и список найденных товаров не пуст")
    public void checkProductsAreFound(String text) {
        $(accessibilityId("Результаты поиска")).should(exist);
        $$x("//android.view.View[contains(@content-desc, '" + text + "')]")
                .shouldHave(sizeGreaterThan(0));
    }

    @Step("Нажать на карточку товара с названием '{text}' в списке товаров")
    public void clickToProductCard(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]").click();
    }

    @Step("Нажать на кнопку 'В корзину' у товара в каталоге товаров и подождать 3 секунды")
    public void addToCart() {
        $(accessibilityId("В корзину")).click();
        Selenide.sleep(3000);
    }

    @Step("Нажать на сердечко (добавить в избранное) у товара в каталоге товаров")
    public void addToFavourites(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]/android.view.View[3]").click();
    }
}
