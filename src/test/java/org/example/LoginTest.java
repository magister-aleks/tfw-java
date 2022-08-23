package org.example;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.slf4j.Logger;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.open;

//@Slf4j
@ExtendWith({MyAllureSetup.class, /*MySelenoidSetup.class*/})
public class LoginTest {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LoginTest.class);
    private final String USERNAME = "aleksandr.morzeev@t-systems.com";

    @BeforeEach
    @Step("Setup Webdriver")
    public void init() {
        Configuration.browser = "firefox";
        Configuration.headless = true;
        Configuration.timeout = 10000;
        log.info("Message debug");
//        open("https://device-model-ui.dev.dt.conmob.cloud/");
        open("https://httpbin.org/");
    }

    @Test
    @Description("Login positive test")
    public void userCanLogin() {
        loginAs(USERNAME, "DigitalTwin731!)");
        sleep(3000);
    }

    @Step("Login as {username}")
    public void loginAs(String username, String password) {
        $(By.id("username")).shouldBe(visible).setValue(username);
        $(By.id("password")).shouldBe(visible).setValue(password);
        $(By.id("kc-login")).shouldBe(visible).click();
        $$(".icon-user").shouldHave(size(1));
        $(".icon-user").shouldBe(visible);
        $(".navigation-bar-item--right").shouldHave(text(USERNAME));
        log.info("Login as {}", username);
    }
}
