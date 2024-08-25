package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class FirstWelcomePage {
    
    public FirstWelcomePage checkNextButtonExistence() {
        $(accessibilityId("Далее")).should(exist);
        return this;
    }

    public void clickNext() {
        $(accessibilityId("Далее")).click();
    }

    public void closeWelcome() {
        $x("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]").click();
    }
}
