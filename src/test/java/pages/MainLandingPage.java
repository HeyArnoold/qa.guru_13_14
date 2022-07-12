package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainLandingPage {

    private final SelenideElement firstCircle = $$(".timeline__years-content--light-blue").get(0);

    private final SelenideElement solutionButton = $$(".main-nav__link").get(0);
    private final SelenideElement lastFadeInRight =  $$(".fadeInRight").get(2);

    private final SelenideElement projectsButton = $$(".main-nav__link").get(1);
    private final SelenideElement projectsFirstItem = $$(".projects__item-link").get(0);
    private final SelenideElement projectsButtonOffline = $(".projects__tabs-button--offline");
    private final SelenideElement textInOfflineGibddItem = $(".projects__item--gibdd .projects__item-title");

    private final SelenideElement mainContactsButton = $$(".main-nav__link").get(2);
    private final SelenideElement contactButton = $(".contacts__button");
    private final SelenideElement themeInput = $(".selectize-input");
    private final SelenideElement firstOptionInThemes = $$(".option").get(0);
    private final SelenideElement nameInputInContactForm = $("[name='name']");
    private final SelenideElement themeContentInputInContactForm = $("[name='theme-content']");
    private final SelenideElement contactsInputInContactForm = $("[name='email-or-phone']");
    private final SelenideElement submitButtonInContactForm = $("[data-action='submit']");
    private final SelenideElement errorMessageInContactForm = $(".modal__error--show");
}
