package com.thetestingacademy.tests.VWO;

import com.thetestingacademy.baseTest.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.POM.VWO.improved_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_Prop_Improved_POM extends CommonToAllTest {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Prop_Improved_POM.class);
    @Owner("Vani")
    @Description("Verify that with invalid email,pwd, error message is shown on screen")
    @Test
    public void test_negative_vwo_login(){

        //as we have the commontoalltest - we will not use driver like this
        //WebDriver driver = new ChromeDriver();
        //so for everymethod - a new browser will be opened and after method it will be closed

        //previously we had all these hardcoded - url, invalid username, pwd, error message
        //now we are reading them from properties file

        //when we want to add logs here - we need to import the logManager and logger
        logger.info("browser is started....");
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        logger.info("Verifying Invalid Credentials");
        String err_msg = loginPage.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        logger.info("Final Assert Verifications....");
        logger.info(err_msg);

        //we can also add error message in logger
        logger.error("Failed to Verify");
        assertThat(err_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(err_msg,PropertiesReader.readKey("error_message"));
    }
}
