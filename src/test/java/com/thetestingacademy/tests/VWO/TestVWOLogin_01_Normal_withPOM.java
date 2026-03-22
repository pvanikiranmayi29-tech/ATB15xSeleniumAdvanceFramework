package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.pages.POM.VWO.normal_POM.DashboardPage;
import com.thetestingacademy.pages.POM.VWO.normal_POM.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_Normal_withPOM {

    //This is a testcase we are creating - where we will utilize all the elements and methods that
    //are created in the LoginPage class under java- com - POM - VWO - LoginPage
    //every test case will follow the three step rule  DLV - Driver, Locator, Verification

    @Owner("Vani")
    @Description("Verify that with invalid email,pwd, error message is shown on screen")
    @Test
    public void test_negative_vwo_login(){
        //Step1 - Driver Manager Code
        //as of now we are not yet managing any driver - so we will use same old code
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        //Step2 - how to manage locators
        //we have created a object for the LoginPage class
        LoginPage loginPage = new LoginPage(driver);
        //now we can use the methods in the given class
        //loginPage.loginToVWOInvalidCreds("admin@gmail.com","1234");
        //this method - if we look it is returning a error message which is a String
        //so instead of like this above - we need to write
        String error_msg = loginPage.loginToVWOInvalidCreds("admin@gmail.com","1234");

        //Step3 - Verification
        //now we got the message - so we can verify it
        //this is assertj
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        //this is testng assert
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");
    }

    @Owner("Vani")
    @Description("Verify that with valid email,pwd,login and open Dashboard page.")
    @Test
    public void test_positive_vwo_login(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.loginToVWOValidCreds("vanishravan@itdbe.com","Admin@1234");

        DashboardPage dashboardPage = new DashboardPage(driver);
        String userNameLoggedIn = dashboardPage.loggedInUserName();

        Assert.assertEquals(userNameLoggedIn,"Vaaanii Shraawaan");
        driver.quit();
    }
}
