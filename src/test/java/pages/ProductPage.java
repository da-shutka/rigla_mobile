package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class ProductPage {

    public void checkProductName(String name) {
        $(accessibilityId(name)).should(exist);
    }

    public ProductPage addToFavourites() {
        $x("//android.widget.ScrollView/android.widget.ImageView[4]").click();
        return this;
    }

    public void returnToMainPage() {
        back();
        back();
        back();
    }
}
