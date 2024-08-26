# Проект по автоматизации тестирования мобильного приложения сети аптек [<img width="20%" title="Rigla" src="media/icons/Rigla.svg"/>](https://play.google.com/store/apps/details?id=ru.rigla.client.android&hl=ru)
>«Ригла» - сеть аптек. Большинство лекарств поставляется в аптеки сети «Ригла» крупнейшим в России фармацевтическим дистрибьютором «Протек», который закупает их напрямую у официальных производителей. «Ригла» располагает широким ассортиментом лекарственных средств, также здесь же можно найти и редкие рецептурные препараты и многое другое.

## :receipt: Содержание
- [Используемый стек](#computer-используемый-стек)
- [Описание проекта](#bookmark_tabs-описание-проекта)
- [Реализованные проверки](#heavy_check_mark-реализованные-проверки)
- [Приложение Ригла](#-приложение-ригла)
- [Запуск тестов](#large_blue_circle-запуск-тестов)
  - [Локальный запуск](#desktop_computer-локальный-запуск)
    - [BrowserStack](#-browserstack)
    - [Эмулятор](#-эмулятор)
    - [Реальное устройство](#iphone-реальное-устройство)
  - [Сборка в Jenkins](#-сборка-в-jenkins)
- [Allure-отчет](#-allure-отчет)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
  - [Результаты запуска из Jenkins](#результаты-запуска-из-jenkins)
  - [Запуск из TestOps](#запуск-из-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в BrowserStack](#-видео-примера-запуска-тестов-в-browserstack)


## :computer: Используемый стек
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/icons/Intelij_IDEA.svg"/></a>
<a href="https://developer.android.com/studio"><img width="6%" title="Android Studio" src="media/icons/Android_Studio.svg"/></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg"/></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/icons/Selenide.svg"/></a>
<a href="https://www.browserstack.com/"><img width="6%" title="BrowserStack" src="media/icons/browserstack.svg"/></a>
<a href="https://appium.io/docs/en/latest/"><img width="6%" title="Appium" src="media/icons/Appium.svg"/></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/icons/Allure_Report.svg"/></a>
<a href="https://qameta.io/"><img width="6%" title="Allure TestOps" src="media/icons/Allure_TestOps.svg"/></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg"/></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/icons/JUnit5.svg"/></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/Github.webp"/></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg"/></a>
<a href="https://telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg"/></a>
</p>

## :bookmark_tabs: Описание проекта

- Проект состоит из мобильных тестов
- Автоматические тесты реализованы на языке ```Java```
- В качестве сборщика используется ```Gradle```
- Используются фреймворки ```JUnit 5``` и ```Selenide```
- Используется шаблон проектирования ```PageObject```
- Используется технология ```Owner``` для конфигурации тестов
- Реализованы драйвера для запуска тестов в ```BrowserStack```, в эмуляторе и на реальном устройстве
- Реализована возможность запуска тестов в ```Jenkins```
- Реализована возможность запуска тестов из ```Allure TestOps```
- Настроена отправка уведомлений о результатах прохождения в чат-бот ```Telegram```
- По завершении прохождения автотестов генерируется ```Allure Report```

---

## :heavy_check_mark: Реализованные проверки

:green_circle: Приветственная страница
- Проверка работоспособности приветственной страницы

:green_circle: Поиск товара
- Проверка работы поиска товара по названию
- Проверка открытия страницы товара из списка

:green_circle: Избранное
- Проверка добавления товара в избранное со страницы продукта
- Проверка добавления товара в избранное из каталога

:green_circle: Корзина
- Проверка добавления товара в корзину со страницы продукта
- Проверка добавления товара в корзину из каталога

---

## <img width="3%" title="Rigla" src="media/icons/Rigla_small.png"/> Приложение Ригла
В BrowserStack, на эмуляторе и на реальном устройстве используется одно и то же приложение Ригла. В BrowserStack оно было загружено дополнительно. Для эмулятора и реального устройства - используется уже находящийся в репозитории проекта пакет .apk. В рамках тестов намеренно меняется язык и местонахождение, чтобы на всех устройствах использовался один и тот же язык (и как следствие, один и тот же код).

---

## :large_blue_circle: Запуск тестов

## :desktop_computer: Локальный запуск

Параметры для локального запуска в терминале IDE:
- тег/задача
  - ```test``` - все тесты
- устройство для запуска
  - ```-DdeviceHost```
    - отсутствует => запускается в BrowserStack
    - ```browserstack```
    - ```emulation```
    - ```real```

### <img width="3%" title="BrowserStack" src="media/icons/browserstack.svg"/> BrowserStack
Для запуска тестов в BrowserStack локально необходимо ввести в терминале команду
```bash
gradle clean test
gradle clean test -DdeviceHost=browserstack
```
По умолчанию, без указания окружения, тесты запускаются в BrowserStack.

### <img width="3%" title="Android Studio" src="media/icons/Android_Studio.svg"/> Эмулятор
Перед запуском тестов необходимо запустить:
- эмулятор устройства в Android Studio
- Appium server

Для запуска тестов в эмуляторе необходимо ввести в терминале команду
```bash
gradle clean test -DdeviceHost=emulation
```

### :iphone: Реальное устройство
Перед запуском тестов необходимо:
- подключить к компьютеру реальное устройство (USB, Type-C)
- запустить Appium server

Для запуска тестов на реальном подключенном устройстве необходимо ввести в терминале команду
```bash
gradle clean test -DdeviceHost=real
```

:warning: Внимание! При одновременном запуске эмулятора и подключенного реального устройства, тесты запускаются на реальном устройстве и при указании ```-DdeviceHost=emulation```

## <img width="3%" title="Jenkins" src="media/icons/Jenkins.svg"/> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/C27-petrova_di-rigla-mobile/)
<img width="50%" title="Jenkins" src="media/img/Jenkins_job.png"/>

```bash
clean test -DdeviceHost=browserstack
```

:gear: Запуск в Jenkins:
1. Открыть [сборку](https://jenkins.autotests.cloud/job/C27-petrova_di-rigla-mobile/)
2. Нажать ```Собрать сейчас```/```Build now```
3. Результат - в логах самой сборки, в Allure-отчете или в Allure TestOps

---

## <img width="3%" title="Allure Report" src="media/icons/Allure_Report.svg"/> [Allure-отчет](https://jenkins.autotests.cloud/job/C27-petrova_di-rigla-mobile/allure/)
После выполнения сборки в Jenkins формируется отчет в Allure.  
В блоке ```История сборок/Build History``` напротив конкретной сборки отображается значок [<img width="2%" title="Allure Report" src="media/icons/Allure_Report.svg"/>](https://jenkins.autotests.cloud/job/C27-petrova_di-rigla-mobile/4/allure/), при нажатии на который открывается страница со сформированным html-отчетом и тестовой документацией.

На основной странице представлена информация о пройденных тестах, тестовые наборы, статистика проходов, распределение по функционалу.  
<img width="50%" title="Allure Overview" src="media/img/Allure_overview.png"/>

Переходя на страницу конкретного тестового набора, можно увидеть список всех пройденных и непройденных тестов, а также детали каждого теста.  
<img width="50%" title="Allure Test" src="media/img/Allure_test.png"/>

Помимо обычного логирования каждого шага теста, в конце каждого мобильного теста фиксируется следующая информация:  
<img width="50%" title="Allure Detailed Finish" src="media/img/Allure_detailedFinish.png"/>
- исходный код страницы
- видео прохождения теста (только для BrowserStack)

---

## <img width="3%" title="Allure TestOps" src="media/icons/Allure_TestOps.svg"/> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/4404/dashboards)
### Результаты запуска из Jenkins
Во время выполнения сборки в Jenkins данные о запуске, тестах и результатах появляются в Allure TestOps.  
В блоке ```История сборок/Build History``` напротив конкретной сборки отображается значок <img width="2%" title="Allure TestOps" src="media/icons/Allure_TestOps.svg"/>, при нажатии на который открывается страница связанного запуска (вкладка "Обзор").  
<img width="50%" title="Allure TestOps Launch Overview" src="media/img/Allure_TestOps_launch_overview.png"/>  

На вкладке "Результаты тестов" можно просмотреть результат выполнения каждого теста:  
<img width="50%" title="Allure TestOps Launch Test Results" src="media/img/Allure_TestOps_launch_testResult.png"/>

### Запуск из TestOps
Запустить тесты можно и из Allure TestOps:   
<img width="50%" title="Allure TestOps Job Params" src="media/img/Allure_TestOps_job_params.png"/>  
1. Перейти в [джобы проекта](https://allure.autotests.cloud/project/4404/jobs)
2. Нажать кнопку "Запустить джобу"
3. Задать название
4. Выбрать тесты для запуска
5. Нажать "Отправить"

---

## <img width="3%" title="Telegram" src="media/icons/Telegram.svg"/> Уведомления в Telegram
После завершения сборки специальный бот, созданный в ```Telegram```, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.  
<img width="30%" title="TG Notification" src="media/img/TG.png"/>

## <img width="3%" title="BrowserStack" src="media/icons/browserstack.svg"/> Видео примера запуска тестов в BrowserStack
Как упоминалось ранее, для каждого мобильного теста, запускаемого в BrowserStack, записывается видео его выполнения.  
<img width="50%" title="Test Video" src="media/img/TestVideo.gif"/>
