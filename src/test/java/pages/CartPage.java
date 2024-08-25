package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    public CartPage openPage() {
        $x("//android.widget.ImageView[contains(@content-desc,'Корзина\nВкладка 3 из 5')]").click();
        return this;
    }

    public void checkAddedProductExistence(String text) {
        $x("//android.view.View[contains(@content-desc, '" + text + "')]").should(exist);
        $x("//android.view.View[contains(@content-desc, 'Перейти к оформлению')]").should(exist);
    }
}
