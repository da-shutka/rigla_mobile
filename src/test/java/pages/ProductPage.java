package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class ProductPage {

    @Step("Проверить, что страница товара с заголовком '{name}' открылась")
    public void checkProductName(String name) {
        $(accessibilityId(name)).should(exist);
    }

    @Step("Нажать на сердечко (добавить в избранное) на странице товара")
    public void addToFavourites() {
        $x("//android.widget.ScrollView/android.widget.ImageView[4]").click();
    }

    @Step("Нажать на кнопку 'В корзину' на странице товара")
    public ProductPage addToCart() {
        $x("//android.view.View[contains(@content-desc, 'В корзину')]").should(exist).click();
        return this;
    }

    @Step("Нажать на кнопку 'Перейти в корзину' на странице товара")
    public void goToCart() {
        $(accessibilityId("Перейти\nВ корзину")).should(exist).click();
    }
}
