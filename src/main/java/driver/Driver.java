package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Objects;

public final class Driver {
    public static WebDriver getdriver;

    public static void initDriver(String browser){
        if(Objects.isNull(getdriver)){
            String path = System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe";
            System.out.println("path: "+path);
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe"); // Replace with your actual path

            if("chrome".equals(browser)){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                getdriver = new ChromeDriver(options);
            }else{
                System.out.println("browser not exist");
            }
        }
        getdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        getdriver.manage().window().maximize();
    }

    public static void quitDriver(){
        if(Objects.nonNull(getdriver)){
            getdriver.quit();
            getdriver = null;
        }
    }
}
