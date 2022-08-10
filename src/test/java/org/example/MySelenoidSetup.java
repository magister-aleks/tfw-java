package org.example;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;

public class MySelenoidSetup implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("browserVersion", "101.0");
        options.setBrowserName("firefox");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            /* How to set timezone */
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});

            /* How to enable video recording */
//            TRUE is failing on MAC
            put("enableVideo", false);
        }});

        Configuration.browserCapabilities = options;
        Configuration.remote = "http://localhost:4444/wd/hub";
//        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
    }
}
