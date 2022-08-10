package org.example;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;

@ExtendWith({MyAllureSetup.class, /*MySelenoidSetup.class*/})
public class LoginTest {
    @BeforeEach
    @Step("Setup Webdriver")
    public void init() {
        Configuration.browser = "firefox";
        Configuration.headless = true;
        Configuration.timeout = 10000;
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
