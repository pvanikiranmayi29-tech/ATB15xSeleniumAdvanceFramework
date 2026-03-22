package com.thetestingacademy.tests.VWO.DDT;

import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.POM.VWO.improved_POM.LoginPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DataDrivenTesting {

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email,String pwd){
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOInvalidCreds(email,pwd);

        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}
