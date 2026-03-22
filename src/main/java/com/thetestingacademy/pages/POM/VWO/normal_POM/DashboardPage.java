package com.thetestingacademy.pages.POM.VWO.normal_POM;

import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameloggedIn = By.xpath("//span[@data-qa='lufexuloga']");

    public String loggedInUserName(){
        WaitHelpers.waitJVM(10000);
        driver.get("https://app.vwo.com/#/dashboard?accountId=1212032");
        WaitHelpers.waitJVM(2000);
        return driver.findElement(userNameloggedIn).getText();
    }
}
