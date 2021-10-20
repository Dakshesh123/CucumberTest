package com.runner;

import com.setup.TestSetup;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

@CucumberOptions(features = "src/test/resources/features", glue = "com.stepDefinitions")
public class RunnerTest extends AbstractTestNGCucumberTests {

}

