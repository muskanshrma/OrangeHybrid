package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class LoginStepDefinition extends BaseClass {

    @Given("User is on Login Page")
    public void website() throws IOException {
        setup();
    }

    @When("User enter username and password")
    public void loginUser() throws IOException {

        pageFactory.getLoginPage().login();
    }

    @And("User click on login button")
    public void button() throws IOException {
        pageFactory.getLoginPage().loginButton();
    }

    @Then("User is on Inventory page")
    public void user_is_on_inventory_page() throws IOException {
        pageFactory.getLoginPage().verification();
        close();
    }
}