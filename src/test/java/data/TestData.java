package data;

import config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;

public class TestData {
    private static final TestDataConfig config = ConfigFactory.create(TestDataConfig.class, System.getProperties());
    public String
            setSearchRequest = config.getSearchRequest(),
            setMainRequest =  config.getMainScreenSearch();
}
