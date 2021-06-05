package co.com.choucair.certification.test1.stepdefinitions;

import co.com.choucair.certification.test1.questions.Answer;
import co.com.choucair.certification.test1.tasks.Login;
import co.com.choucair.certification.test1.tasks.OpenUp;
import co.com.choucair.certification.test1.tasks.Search;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ChoucairAcademyStepDefinitions {
    @Before
    public void setStage(){ OnStage.setTheStage(new OnlineCast()); }

    @Given("^that Antonio wants to learn automation at the academy Choucair$")
    public void thatAntonioWantsToLearnAutomationAtTheAcademyChoucair() {
        OnStage.theActorCalled("Antonio").wasAbleTo(OpenUp.thePage(), (Login.OnThePage()));
    }

    @When("^he search for the course (.*) on the choucair academy platform$")
    public void heSearchForTheCourseRecursosAutomatizacionBancolombiaOnTheChoucairAcademyPlatform(String course) {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(course));
    }

    @Then("^he finds the course called resources (.*)$")
    public void heFindsTheCourseCalledResourcesRecursosAutomatizacionBancolombia(String question) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(question)));
    }

}
