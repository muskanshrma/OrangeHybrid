package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class CandidateStepDefinition extends BaseClass {

    @Given("User is logged in")
    public void website() throws IOException {
        setup();
        pageFactory.getLoginPage().login();
        pageFactory.getLoginPage().loginButton();
        pageFactory.getLoginPage().verification();
    }

    @When("User navigates to Recruitment page and clicks on add button")
    public void recMenu(){
        pageFactory.getCandidatesPage().recruitmentMenu();
    }

    @And("User enters candidate details and click save button")
    public void addButton() throws IOException {
        pageFactory.getCandidatesPage().addCandidate();
    }

    @Then("New candidate is added")
    public void userAdded() throws IOException {
        pageFactory.getCandidatesPage().verify();
        close();
    }
}