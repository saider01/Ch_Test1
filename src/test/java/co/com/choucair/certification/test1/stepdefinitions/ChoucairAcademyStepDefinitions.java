package co.com.choucair.certification.test1.stepdefinitions;

import co.com.choucair.certification.test1.model.AcademyChoucairData;
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
import java.util.List;

public class ChoucairAcademyStepDefinitions {
    @Before
    public void setStage(){ OnStage.setTheStage(new OnlineCast()); }

    @Given("^that Antonio wants to learn automation at the academy Choucair$")
    public void thatAntonioWantsToLearnAutomationAtTheAcademyChoucair(List<AcademyChoucairData> academyChoucairData)
            throws Exception {
        OnStage.theActorCalled("Antonio").wasAbleTo(OpenUp.thePage(), (Login.
                OnThePage(academyChoucairData.get(0).getStrUser(), academyChoucairData.get(0).getStrPassword())));
    }

    @When("^he search for the course on the choucair academy platform$")
    public void heSearchForTheCourseRecursosAutomatizacionBancolombiaOnTheChoucairAcademyPlatform(List<AcademyChoucairData> academyChoucairData)
            throws Exception {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(academyChoucairData.get(0).getStrCourse()));
    }

    @Then("^he finds the course called$")
    public void heFindsTheCourseCalledResourcesRecursosAutomatizacionBancolombia(List<AcademyChoucairData> academyChoucairData)
            throws Exception {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(academyChoucairData.get(0).getStrCourse())));
    }

}
