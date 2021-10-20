package com.setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestSetup {

    static WebDriver driver;

    public static WebDriver getDriverInstance()
    {
        return driver;
    }

    public WebDriver setDriver() {
        String appURL = readProperty("URL").toString();
        String browserType = readProperty("browser").toString();
        switch (browserType.toLowerCase()) {
            case "chrome":
                driver = initChromeDriver(appURL);
                break;
            case "firefox":
                driver = initFirefoxDriver(appURL);
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver(appURL);
        }

        return driver;
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }




    public Object readProperty(String property) {
        Properties prop = null;
        try (InputStream input = new FileInputStream("config.properties")) {

              prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty(property));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(property);
    }

    public void cleanUp() {
        System.out.println("Into the cleanUp method of AccountStep...");
        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }
}
