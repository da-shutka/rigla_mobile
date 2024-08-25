package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FavouritesPage {

    public FavouritesPage openPage() {
        $(AppiumBy.accessibilityId("Избранное\nВкладка 4 из 5")).click();
        return this;
    }

    public void checkAddedProductExistence(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]").should(Condition.exist);
    }
}
