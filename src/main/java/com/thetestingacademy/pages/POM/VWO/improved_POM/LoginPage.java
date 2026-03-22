package com.thetestingacademy.pages.POM.VWO.improved_POM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAllPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_msg = By.id("js-notification-box-msg");

    public String loginToVWOInvalidCreds(String usr, String pwd){
        //instead of using this - driver.findElement(username).sendKeys(usr);
        openVWOUrl();
        enterInput(username,usr);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(),error_msg);
        return getText(error_msg);
    }

    public void loginToVWOValidCreds(String usr, String pwd){
        openVWOUrl();
        enterInput(username,usr);
        enterInput(password,pwd);
        clickElement(signButton);

        WaitHelpers.waitJVM(5000);
    }
}
