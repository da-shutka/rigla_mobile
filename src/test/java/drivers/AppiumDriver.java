package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class AppiumDriver implements WebDriverProvider {

    private static final DeviceConfig config = ConfigFactory.create(DeviceConfig.class);

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.version())
                .setDeviceName(config.device())
                .setApp(getAppPath())
                .setAppPackage("ru.rigla.client.android")
                .setAppActivity("ru.rigla.client.android.MainActivity")
                .setLanguage(config.language())
                .setLocale(config.locale())
                .setAutoGrantPermissions(true);
        DriverData.androidDriver = new AndroidDriver(getAppiumServerUrl(), options);
        return DriverData.androidDriver;
    }

    private String getAppPath() {
        String appVersion = "ru.rigla.client.android_2.30.0.apk";
        String appPath = "src/test/resources/apps/" + appVersion;
        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
