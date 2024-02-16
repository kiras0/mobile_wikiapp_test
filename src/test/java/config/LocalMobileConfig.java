package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:localMobile.properties"
})
public interface LocalMobileConfig extends Config {
    @Key("device")
    String getDevice();

    @Key("os_version")
    String getVersion();

    @Key("localServerUrl")
    String getServerUrl();
}
