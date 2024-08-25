package pages;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class CatalogPage {

    public void checkProductsAreFound(String text) {
        $(accessibilityId("Результаты поиска")).should(exist);
        $$x("//android.view.View[contains(@content-desc, '" + text + "')]")
                .shouldHave(sizeGreaterThan(0));
    }

    public void clickToProductCard(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]").click();

    }

    public void addToCart() {
        $(accessibilityId("В корзину")).click();
    }
}
