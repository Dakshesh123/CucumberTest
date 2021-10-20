package com.stepDefinitions;

import com.commons.CommonUtils;
import com.commons.Locators;
import com.setup.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs extends TestSetup {


    @Before
    public void setup() {
        setDriver();
    }


    @After
    public void quit() {

        if (getDriverInstance() != null) {
            getDriverInstance().close();
            getDriverInstance().quit();
        }
    }

    @When("Enter fullname is {string}")
    public void enterFullnameIs(String name) {

        CommonUtils.enterValueInText(Locators.TXT_FULL_NAME_, name);
    }

    @Then("Enter Email is {string}")
    public void enterEmailIs(String email) {
        CommonUtils.enterValueInText(Locators.TXT_EMAIL_, email);
    }

    @Then("Enter Current address is {string}")
    public void enterCurrentAddressIs(String currentAddress) {
        CommonUtils.enterValueInText(Locators.TXT_CURRENT_ADDRESS_, currentAddress);
    }

    @Then("Enter Permanent address is {string}")
    public void enterPermanentAddressIs(String permanentAddress) {
        CommonUtils.enterValueInText(Locators.TXT_PERMANENT_ADDRESS_, permanentAddress);
    }

    @And("Click on Submit button")
    public void clickOnSubmitButton() {
        CommonUtils.click(Locators.BTN_SUBMIT_);
    }
}
