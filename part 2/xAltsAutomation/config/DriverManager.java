package xAltsAutomation.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver driver;

    private static DriverManager instance;

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * This method is to initialise the driver by giving two arguments i.e. "Browser" and "Mode (head/headless)".
     */
    public void initialiseDriver(String browser, String mode) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (mode.equals("headless")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browser.equals("firefox")) {
            WebDriverManager.edgedriver().setup();
            if (mode.equals("headless")) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            } else {
                driver = new FirefoxDriver();
            }
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            if (mode.equals("headless")) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                driver = new EdgeDriver(options);
            } else {
                driver = new EdgeDriver();
            }
        }
    }

    /**
     * This method is responsible to quit the driver after whole execution of the script.
     */
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
