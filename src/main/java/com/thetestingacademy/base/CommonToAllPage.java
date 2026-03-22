package com.thetestingacademy.base;

import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {
    //here we will write the code which is common to all pages

    public void openVWOUrl(){
        getDriver().get(PropertiesReader.readKey("url"));
    }

    //we also have driver.findElement, sendkeys, click

    //this is wrapper class

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void enterInput(By by, String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement by,String key){
        by.sendKeys(key);
    }

    public String getText(By by){
        return getDriver().findElement(by).getText();
    }

    public String getText(WebElement by){
        return by.getText();
    }
}
