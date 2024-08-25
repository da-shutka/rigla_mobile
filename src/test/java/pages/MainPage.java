package pages;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static drivers.DriverData.androidDriver;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainPage {

    @Step("Подтвердить выбор города, выбранного по умолчанию, в появившемся уведомлении")
    public MainPage confirmCity() {
        $(accessibilityId("Да")).click();
        return this;
    }

    @Step("Проверить, что открылся главный раздел и есть поле поиска товаров")
    public void checkSearchInputExistence() {
        $x("//android.view.View[@content-desc='Поиск']").should(exist);
    }

    @Step("Ввести {text} в поисковой строке на главной странице и нажать кнопку поиска на клавиатуре")
    public void
    searchByText(String text) {
        $x("//android.view.View[@content-desc='Поиск']").click();
        $x("//android.widget.EditText").click();
        $x("//android.widget.EditText").sendKeys(text);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }


}
