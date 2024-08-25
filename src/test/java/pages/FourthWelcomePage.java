package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class FourthWelcomePage {

    public FourthWelcomePage checkNextButtonExistence() {
        $(accessibilityId("Далее")).should(exist);
        return this;
    }

    public void clickNext() {
        $(accessibilityId("Далее")).click();
    }
}
