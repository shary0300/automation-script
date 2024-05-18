package mercans.stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mercans.pageobjects.LeavesPage;
import mercans.utils.DriverManager;
import org.testng.Assert;


public class LeavesSteps extends DriverManager {
    private LeavesPage leavesPage;

    public LeavesSteps(){
        leavesPage = new LeavesPage(getDriver());
    }

    @Then("User clicks on plus button for requesting the leave")
    public void clickOnPlusButton() throws InterruptedException {
        leavesPage.clickOnPlusButton();
    }

    @Then("Request new leave modal should be displayed")
    public void validateRequestLeaveModal() throws InterruptedException {
        Assert.assertEquals(leavesPage.getModalTitle().getText(), "Request new leave");
    }

    @When("Select a date for the request a leave")
    public void selectDateForLeave() throws InterruptedException {
        leavesPage.selectADateForLeave();
    }

    @Then("Validate before and after leaves should be matched")
    public void validateBeforeAndAfterRequest() throws InterruptedException {
        Assert.assertNotEquals(leavesPage.getBeforeRequest().getText(), leavesPage.getAfterRequest().getText());
    }

    @Then("User clicks on the save draft button")
    public void clickOnSaveDraftButton() throws InterruptedException {
        leavesPage.clickSaveDraftBtn();
    }

    @Then("User clicks on the request leave and confirm button")
    public void clickOnRequestLeaveButton() throws InterruptedException {
        leavesPage.clickRequestLeaveBtn();
        leavesPage.clickConfirmRequestLeaveBtn();
    }

    @And("User delete the draft leaves request")
    public void deleteDraftRequest() throws InterruptedException {
        leavesPage.deleteDraftRequest();
    }

    @And("User selects the first draft leave request")
    public void clickFirstDraftRequest() throws InterruptedException {
        leavesPage.clickFirstDraftRequest();
    }
}
