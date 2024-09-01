package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screens.MainScreen;
import screens.WelcomeScreen;

@DisplayName("Мобильные тесты на приветственную страницу в приложении Ригла")
public class WelcomeScreenTests extends TestBaseMobile {

    final WelcomeScreen welcomeScreen = new WelcomeScreen();
    final MainScreen mainScreen = new MainScreen();

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация welcome страницы")
    @Story("MOBILE: Приветственная страница")
    @DisplayName("Проверка работы приветственной страницы")
    void checkWelcomePagesTest() {
        welcomeScreen
                .checkNextButtonExistence()
                .clickNext()
                .checkNextButtonExistence()
                .clickNext()
                .checkNextButtonExistence()
                .clickNext()
                .checkNextButtonExistence()
                .clickNext();
        mainScreen
                .confirmCity()
                .checkSearchInputExistence();
    }
}
