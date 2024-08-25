package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:properties/${deviceHost}.properties"
})
public interface DeviceConfig extends Config {

    String app();

    String device();

    String version();

    String project();

    String build();

    String name();

    String url();

    String language();

    String locale();
}