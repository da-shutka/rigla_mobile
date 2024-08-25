package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class ProductPage {

    public void checkProductName(String name) {
        $(accessibilityId(name)).should(exist);
    }

    public void addToFavourites() {
        $x("//android.widget.ScrollView/android.widget.ImageView[4]").click();
    }

    public void returnToMainPage() {
        back();
        back();
        back();
    }

    public ProductPage addToCart() {
        $x("//android.view.View[contains(@content-desc, 'В корзину')]").should(exist).click();
        return this;
    }

    public void goToCart() {
        $(accessibilityId("Перейти\nВ корзину")).should(exist).click();
    }
}
