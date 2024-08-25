package pages;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static drivers.DriverData.androidDriver;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainPage {

    public MainPage confirmCity() {
        $(accessibilityId("Да")).click();
        return this;
    }

    public void checkSearchInputExistence() {
        $x("//android.view.View[@content-desc='Поиск']").should(exist);
    }

    public void
    searchByText(String text) {
        $x("//android.view.View[@content-desc='Поиск']").click();
        $x("//android.widget.EditText").click();
        $x("//android.widget.EditText").sendKeys(text);
        androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }


}
