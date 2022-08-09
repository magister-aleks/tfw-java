package org.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest {

    @BeforeEach
    public void init() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.browser = "firefox";
        Configuration.headless = true;
        open("https://device-model-ui.dev.dt.conmob.cloud/");
    }

    @Test
    @Description("Login positive test")
    public void userCanLogin() {
        loginAs("aleksandr.morzeev@t-systems.com", "DigitalTwin731!)");
        sleep(5000);


    }

    @Step("Login as {username}")
    public void loginAs(String username, String password) {
        $(By.id("username")).shouldBe(visible).setValue(username);
        $(By.id("password")).shouldBe(visible).setValue(password);
        $(By.id("kc-login")).shouldBe(visible).click();
        System.out.println("Login as " + username);
    }
}
