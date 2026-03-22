package com.thetestingacademy.pages.POM.VWO.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    //this is a page class
    //every page will need a webdriver - so we will create a obj and a parameterized const

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //every page class will have
    //page locator

    //how many elements we have in the page
    //if we look at the TestVWOInvalidLogin_Without_POM program - how many we are interating with
    // we have four - username, pwd, submit button, error msg
    //with this below - we are just getting the driver.findElement(......) which is a common part
    //as these are children - we will secure them using private keyword using encapsulation

    //By is a class which is a type
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_msg = By.id("js-notification-box-msg");


    //page actions
    //next in the same line - what are the actions that we are performing with these above elements
    //finding - driver.find
    //writing - .sendkeys
    //with these what all scenarios we can do
    //find and send - valid creds
    //find and send - invalid cred

    public String loginToVWOInvalidCreds(String usr, String pwd){
        //here instead of using By.id("login-username") we will use username
        //so it will be
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        WaitHelpers.checkVisibility(driver,error_msg);

        String error_msg_txt = driver.findElement(error_msg).getText();
        return error_msg_txt;
    }

    public void loginToVWOValidCreds(String usr, String pwd){
        //here instead of using By.id("login-username") we will use username
        //so it will be
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        //WaitHelpers.checkVisibility(driver,error_msg);
    }
}
