package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static org.openqa.selenium.Keys.ENTER;

public class MainPage {

    public MainPage confirmCity() {
        $(accessibilityId("Да")).click();
        return this;
    }

    public void checkSearchInputExistence() {
        $x("//android.view.View[@content-desc='Поиск']").should(exist);
    }

    public void searchByText(String text) {
        $x("//android.view.View[@content-desc='Поиск']").click();
        $x("//android.widget.EditText").click();
        $x("//android.widget.EditText").sendKeys(text);
        actions().sendKeys(ENTER).perform();
    }


}
