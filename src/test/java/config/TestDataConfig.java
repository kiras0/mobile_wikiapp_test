package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:testData.properties",
})

    public interface TestDataConfig extends Config {
        @Key("searchRequest")
        String getSearchRequest();
        @Key("mainScreenSearch")
        String getMainScreenSearch();
}
