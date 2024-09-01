package screens;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FavoritesScreen {

    @Step("Нажать на кнопку 'Избранное'")
    public FavoritesScreen open() {
        $(AppiumBy.accessibilityId("Избранное\nВкладка 4 из 5")).click();
        return this;
    }

    @Step("Проверить, что товар с названием '{text}' добавлен в избранное")
    public void checkAddedProductExistence(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]").should(Condition.exist);
    }
}
