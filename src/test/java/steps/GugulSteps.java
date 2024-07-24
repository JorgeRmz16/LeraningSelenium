package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Gugul;

public class GugulSteps {
    Gugul gugul = new Gugul();

    @Given("I navigate to www.google.com")
    public void iNavigateToFRT() {
        gugul.navigateToGoogle();
    }
    @When("I go to search something and click")
    public void navigationBarUse() {
        gugul.searchSomething();
        gugul.clickSearch();
    }
}
