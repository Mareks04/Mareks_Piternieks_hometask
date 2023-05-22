package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSteps {

    @Given("User inserts <{int}>€ in vending machine")
    public void userInsertsCoinsInVendingMachine(int arg0) {
        System.out.println("User inserts " + arg0 + "€ in vending machine");
    }

    @When("User validates that <{int}>€ has been inserted into vending machine")
    public void userValidatesThatCorrectAmountIsDisplayedInVendingMachine(int arg0) {
        System.out.println("User validates that " + arg0 + "€ has been inserted into vending machine");
    }

    @When("User selects <{string}> option")
    public void userSelectsOption(String arg0) {
        System.out.println("User selects" + arg0 + "option");
    }

    @Then("User validates <{int}>€ have been returned")
    public void userValidatesAllMoneyHaveBeenReturned(int arg0) {
        System.out.println("User validates that " + arg0 + "€ have been returned");
    }

    @When("User selects <{string}> product option")
    public void userSelectsProductWithNumber(String arg0) {
        System.out.println("User selects" + arg0 + " product option");
    }

    @Then("User validates that correct <{string}> is returned")
    public void userValidatesThatCorrectProductNumberIsReturned(String arg0) {
        System.out.println("User validates that correct" + arg0 + " product option is returned");
    }

    @When("User waits <{int}> seconds")
    public void userWaits(int arg0) {
        System.out.println("User waits " + arg0 + " seconds");
    }

    @When("User validates that he receives reminder")
    public void validatesReminderIsTriggered() {
        System.out.println("User validates that he receives reminder");
    }

    @And("User validates total amount of inserted money becomes zero")
    public void validateZeroCreditAvailable() {
        System.out.println("User validates total amount of inserted money becomes zero");
    }

    @Then("User validates the total amount of inserted money is updated accordingly")
    public void validateTotalAmountOfInsertedMoneyIsUpdatedAccordingly() {
        System.out.println("User validates the total amount of inserted money is updated accordingly");
    }

    @Given("User inserts a coins of 5ȼ, 10ȼ, 20ȼ, 50ȼ, 1€, and 2€")
    public void userInsertsCoinsAndValidates() {
        System.out.println("User inserts a coins of 5ȼ, 10ȼ, 20ȼ, 50ȼ, 1€, and 2€");
    }

    @Given("Vending machine has products available")
    public void vendingMachineHasProductsAvailable() {
        System.out.println("Check products available");
    }
}
