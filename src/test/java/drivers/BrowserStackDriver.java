package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AuthConfig;
import config.DeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    private static final DeviceConfig config = ConfigFactory.create(DeviceConfig.class);
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);

    public static URL getAppiumServerUrl() throws MalformedURLException {
        return new URL("https://" + authConfig.user() + ":" + authConfig.key() + "@" + config.url());
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName("uiautomator2")
                .setPlatformName("Android")
                .setPlatformVersion(config.version())
                .setDeviceName(config.device())
                .setApp(config.app())
                .setAppPackage("ru.rigla.client.android")
                .setAppActivity("ru.rigla.client.android.MainActivity")
                .setLanguage(config.language())
                .setLocale(config.locale())
                .setAutoGrantPermissions(true);

        try {
            DriverData.androidDriver = new AndroidDriver(getAppiumServerUrl(), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return DriverData.androidDriver;
    }
}
