package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class FirstWelcomePage {

    @Step("Проверить, что на первой приветственной странице есть кнопка Далее")
    public FirstWelcomePage checkNextButtonExistence() {
        $(accessibilityId("Далее")).should(exist);
        return this;
    }

    @Step("Нажать кнопку Далее на первой приветственной странице")
    public void clickNext() {
        $(accessibilityId("Далее")).click();
    }

    @Step("Закрыть приветственную страницу")
    public void closeWelcome() {
        $x("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]").click();
    }
}
