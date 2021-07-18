package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.Credentials;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;
import static helpers.GetProperty.readProperty;

public class MainPageTests {

    static final String MAINPAGE = "https://www.tinkoff.ru/";

    @BeforeAll
    static void setUpConfig() {
        String login = Credentials.credentials.login();
        String password = Credentials.credentials.password();
        String server = readProperty();
        Configuration.remote = String.format("https://%s:%s@%s/wd/hub", login, password, server);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @Test
    @DisplayName("Проверка вкладки 'Бизнес'")
    void businessTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Бизнес")).click();
        $(".ab2Bjtnqb.cb2Bjtnqb p").shouldHave(text("Онлайн-банк для малого бизнеса"));
    }

    @Test
    @DisplayName("Проверка вкладки 'Касса'")
    void kassaTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Касса")).click();
        $(".ablkGIjod p").shouldHave(text("Прием онлайн-платежей для вашего бизнеса"));
    }

    @Test
    @DisplayName("Проверка вкладки 'Инвестиции'")
    void investTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Инвестиции")).click();
        $(".cb2Bjtnqb p").shouldHave(text("Инвестируйте в ценные бумаги"));
    }

    @Test
    @DisplayName("Проверка вкладки 'Страхование'")
    void insuranceTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Страхование")).click();
        $(".abxM36M2S p").shouldHave(text("Электронное ОСАГО"));
    }

    @Test
    @DisplayName("Проверка вкладки 'Сим-карта'")
    void mobileTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Сим-карта")).click();
        $(".cb2Bjtnqb p").shouldHave(text("Попробуйте бесплатно связь от Тинькофф"));
    }

    @Test
    @DisplayName("Проверка вкладки 'Путешествия'")
    void flightsTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Путешествия")).click();
        $(".ab3aYWpp_ p").shouldHave(text("Авиабилеты с кэшбэком до 7%"));
    }

    @Test
    @DisplayName("Проверка вкладки 'Развлечения'")
    void entertainmentTabCheck() {
        open(MAINPAGE);
        $("[data-qa-type='uikit/navigation.menu']").$(byText("Развлечения")).click();
        $(".PageHeader__linkWrapper_d1NUMT").shouldHave(text("Сегодня в кино"));
    }

    @AfterEach
    void attach() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}
