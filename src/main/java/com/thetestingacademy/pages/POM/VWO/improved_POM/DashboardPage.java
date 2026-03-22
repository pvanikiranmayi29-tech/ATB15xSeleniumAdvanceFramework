package com.thetestingacademy.pages.POM.VWO.improved_POM;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends CommonToAllPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameloggedIn = By.xpath("//span[@data-qa='lufexuloga']");

    public String loggedInUserName(){
        WaitHelpers.visibilityOfElement(userNameloggedIn);
        return getText(userNameloggedIn);
    }
}
