package mercans.stepdefinations;

import io.cucumber.java.en.*;
import mercans.pageobjects.CommonPage;
import mercans.utils.DriverManager;
import org.testng.Assert;

import java.io.IOException;

public class CommonSteps extends DriverManager {
    private CommonPage commonPage;

    public CommonSteps(){
        commonPage = new CommonPage(getDriver());
    }
    @Then("Validate that URL contains {string} text")
    public void validateURL(String key) throws IOException {
        commonPage.validateURL(commonPage.getValue(key));
    }
    @Then("Validate that alert should be displayed with the {string} text")
    public void validateAlertMessage(String message) throws InterruptedException {
        Assert.assertTrue(commonPage.getAlertMessage().getText().contains(message));
        commonPage.getCloseAlert().click();
    }

    @When("User selects the approval menu in the left sidebar")
    public void validateAlertMessage() throws InterruptedException {
        commonPage.clickLeavesMenu();
        commonPage.clickApprovalMenu();
    }
}
