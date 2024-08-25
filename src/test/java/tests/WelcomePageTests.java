package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

@DisplayName("Мобильные тесты на приветственную страницу")
@Tag("MOBILE")
public class WelcomePageTests extends TestBase {

    FirstWelcomePage firstWelcomePage = new FirstWelcomePage();
    SecondWelcomePage secondWelcomePage = new SecondWelcomePage();
    ThirdWelcomePage thirdWelcomePage = new ThirdWelcomePage();
    FourthWelcomePage fourthWelcomePage = new FourthWelcomePage();
    MainPage mainPage = new MainPage();

    @Test
    @Owner("Дарья Петрова")
    @Feature("Реализация welcome страницы")
    @Story("MOBILE: Приветственная страница")
    @DisplayName("Проверка работы приветственной страницы")
    void checkWelcomePagesTest() {
        firstWelcomePage
                .checkNextButtonExistence()
                .clickNext();
        secondWelcomePage
                .checkNextButtonExistence()
                .clickNext();
        thirdWelcomePage
                .checkNextButtonExistence()
                .clickNext();
        fourthWelcomePage
                .checkNextButtonExistence()
                .clickNext();
        mainPage
                .confirmCity()
                .checkSearchInputExistence();
    }
}
