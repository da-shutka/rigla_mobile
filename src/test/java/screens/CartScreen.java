package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class CartScreen {

    @Step("Открыть раздел 'Корзина'")
    public CartScreen open() {
        $x("//android.widget.ImageView[contains(@content-desc,'Корзина\nВкладка 3 из 5')]").click();
        return this;
    }

    @Step("Проверить, что товар с названием '{text}' добавлен в корзину и имеется кнопка для дальнейшего оформления заказа")
    public void checkAddedProductExistence(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]").should(exist);
        $x("//android.view.View[contains(@content-desc, 'оформлению')]").should(exist);
    }
}
