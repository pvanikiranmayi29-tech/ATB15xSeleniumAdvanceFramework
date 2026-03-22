package com.thetestingacademy.baseTest;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    //here we will add all the things which are common to all testcase
    //starting a driver
    //closing a driver

    //when you want to run this method before every methond - we can use testng annotation
    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
