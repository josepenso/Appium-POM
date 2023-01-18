package test;

import com.appium.utitilies.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;

    @BeforeClass
    public void configureAppium() throws MalformedURLException {

        UiAutomator2Options options= new UiAutomator2Options();
       options.setDeviceName(Config.getProperty("device"));
        options.setApp(Config.getProperty("eCommerceApp"));
        options.setChromedriverExecutable(Config.getProperty("chromeBrowser"));
        driver= new AndroidDriver(new URL("http://0.0.0.0:4723"),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void tearsDown(){
        driver.quit();
    }


}


