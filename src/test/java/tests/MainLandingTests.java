package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class MainLandingTests extends TestBase{

    @Description("Открываем главный лендинг, проверяем первый интерактивный кружок на таймлайне на содержание текста")
    @Test
    void timeLineWrapperTest() {
        open("");

        SelenideElement firstCircle = $$(".timeline__years-content--light-blue").get(0);

        firstCircle.hover();

        firstCircle.shouldHave(text("Сервис оплаты задолженностей Федеральной службы судебных приставов в терминальных сетях"));
    }

    @Description("Открываем главный лендинг, проверяем содержимое одного из кейсов 'Решения'")
    @Test
    void solutionButtonTest() {
        open("");

        $$(".main-nav__link").get(0).click();

        $$(".fadeInRight").get(2)
                .shouldHave(text("Наши решения обеспечивают простоту и высокую скорость запуска сервисов партнёров"));
    }

    @Description("Проверяем ссылку в Реализованных проектах")
    @Test
    void onlineButtonInProjectsTest() {
        open("");

        $$(".main-nav__link").get(1).click();

        $$(".projects__item-link").get(0)
                .shouldHave(attribute("href", "https://oplatagosuslug.ru/"))
                .shouldBe(interactable);
    }

    @Description("Проверяем текст первого проекта из примера в Offline проектах")
    @Test
    void offlineButtonInProjectsTest() {
        open("");

        $$(".main-nav__link").get(1).click();

        $(".projects__tabs-button--offline").click();

        $(".projects__item--gibdd .projects__item-title")
                .shouldHave(text("Система оплаты штрафов ГИБДД в «АРМ сотрудника ДПС»"));
    }

    @Description("Заполняем поля в форме 'Отправить письмо', затем очищаем поля, нажимаем отправим и проверяем получения теста с ошибкой")
    @Test
    void contactFormTest() {
        open("");

        $$(".main-nav__link").get(2).click();

        $(".contacts__button").click();

        $(".selectize-input").click();
        $$(".option").get(0).click();

        $("[name='name']").setValue("Максим");
        $("[name='theme-content']").setValue("Здравствуйте");
        $("[name='email-or-phone']").setValue("+79991231212");

        $("[name='name']").clear();
        $("[name='theme-content']").clear();
        $("[name='email-or-phone']").clear();

        $("[data-action='submit']").click();

        $(".modal__error--show").shouldHave(text("Не удалось отправить форму"));
    }
}
