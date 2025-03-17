package steps;

import com.config.TestDataManager;
import driver.Driver;
import io.cucumber.java.Scenario;
import org.aeonbits.owner.ConfigFactory;

public class Hooks {
       public static TestDataManager testDataManager;

    @io.cucumber.java.Before
    public static void setUp(Scenario scenario){
        testDataManager = ConfigFactory.create(TestDataManager.class);
        System.out.println("Browser: " + testDataManager.browser());
        System.out.println("URL: " + testDataManager.url());
        Driver.initDriver(testDataManager.browser());
    }


}
