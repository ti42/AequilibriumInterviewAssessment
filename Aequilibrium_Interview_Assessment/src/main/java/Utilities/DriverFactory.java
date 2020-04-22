package Utilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static final String DEFAULT_BROWSER = "CHROME";
    private static DriverFactory instance = null;
    private ThreadLocal<WebDriver> driverCollection = new ThreadLocal<WebDriver>();

    private DriverFactory(){
    }

    public static DriverFactory getInstance(){
        String browser = System.getenv("browser");

        return getInstance(browser);
    }


    public static DriverFactory getInstance(String browser) {
        if (instance == null) {
            instance = new DriverFactory();
        }

        if(browser == null || browser == ""){
            browser = DEFAULT_BROWSER;
            System.out.println("Browser was not set from env variable.");
            System.out.println("Using default browser: " + browser);

        }

        if(instance.driverCollection.get() == null) {
            System.out.println("Using browser: " + browser);

            WebDriver driver = null;

            if(browser.toUpperCase().contentEquals("CHROME")) {
                ChromeDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(browser.toUpperCase().contentEquals("CHROME-HEADLESS")) {
                ChromeDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless")
                        .addArguments("--disable-gpu")
                        .addArguments("--window-size=1920,1080")
                        .addArguments("--ignore-certificate-errors");

                //options.setBinary("/Path/to/specific/version/of/Google Chrome");
                driver = new ChromeDriver(options);
            }
            else if(browser.toUpperCase().contentEquals("FIREFOX")) {
                FirefoxDriverManager.firefoxdriver().arch64().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("marionette", true);

                driver = new FirefoxDriver(options);
            }
            else if(browser.toUpperCase().contentEquals("FIREFOX-HEADLESS")) {
                FirefoxDriverManager.firefoxdriver().arch64().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability("marionette", true);
                options.addArguments("--headless");

                driver = new FirefoxDriver(options);
            }

            instance.driverCollection.set(driver);
        }

        return instance;
    }


    public WebDriver getDriver() {
        return driverCollection.get();
    }

    public void quitDriver() {
        // Quits the driver and closes the browser
        try {
            driverCollection.get().close();
            driverCollection.get().quit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            driverCollection.remove();
        }

    }


}
