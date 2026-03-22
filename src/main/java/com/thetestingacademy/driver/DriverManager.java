package com.thetestingacademy.driver;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    //first as the webdriver is common - we create a static var
    public static WebDriver driver;

    //now we create a getter setter for this - right click and generate
    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    //now this function will be user for starting the browser
    public static void init(){

        String browser = PropertiesReader.readKey("browser");
        browser=browser.toLowerCase();

        switch (browser){
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("Browser not supported");
        }
    }
    //and this function is used for closing the browser
    public static void down(){
        //this if is given to make sure - we have running browser
        //if driver is already null - we dont need to perfom this action
        //this is kind of pre-check on the driver
        //if open - then close
        if(getDriver()!=null){
            driver.quit();
            driver = null;
        }
    }
}
