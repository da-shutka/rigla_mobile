package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class FourthWelcomePage {

    @Step("Проверить, что на четвертой приветственной странице есть кнопка Далее")
    public FourthWelcomePage checkNextButtonExistence() {
        $(accessibilityId("Далее")).should(exist);
        return this;
    }

    @Step("Нажать кнопку Далее на четвертой приветственной странице")
    public void clickNext() {
        $(accessibilityId("Далее")).click();
    }
}
