package com.commons;

import com.setup.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CommonUtils extends TestSetup {

    public static void enterValueInText(By locator, String value)
    {
        getDriverInstance().findElement(locator).sendKeys(value);
    }

    public static  void click(By locator)
    {
        getDriverInstance().findElement(locator).click();
    }
}
