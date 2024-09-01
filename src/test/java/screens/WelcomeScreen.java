package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class WelcomeScreen {

    @Step("Проверить, что на приветственной странице есть кнопка 'Далее'")
    public WelcomeScreen checkNextButtonExistence() {
        $(accessibilityId("Далее")).should(exist);
        return this;
    }

    @Step("Нажать кнопку 'Далее' на приветственной странице")
    public WelcomeScreen clickNext() {
        $(accessibilityId("Далее")).click();
        return this;
    }

    @Step("Закрыть приветственную страницу")
    public void closeWelcome() {
        $x("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]").click();
    }
}
