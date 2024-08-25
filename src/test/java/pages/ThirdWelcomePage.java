package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class ThirdWelcomePage {

    @Step("Проверить, что на третьей приветственной странице есть кнопка 'Далее'")
    public ThirdWelcomePage checkNextButtonExistence() {
        $(accessibilityId("Далее")).should(exist);
        return this;
    }

    @Step("Нажать кнопку 'Далее' на третьей приветственной странице")
    public void clickNext() {
        $(accessibilityId("Далее")).click();
    }
}
