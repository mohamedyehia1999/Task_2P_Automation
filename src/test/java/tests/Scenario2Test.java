package tests;

import bases.BaseTest;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.HomePage;
import pages.OpenAccountPage;

public class Scenario2Test extends BaseTest
{
    protected HomePage homePage;
    protected OpenAccountPage openAccountPage;
    @Test
    public void UserCanSelectRandomly() {
        HomePage homePage = new HomePage(driver);
        openAccountPage = new OpenAccountPage(driver);
        homePage
                .ClickOnBankingLink();
                /*
                .ClickOnBankManagerLoginButton()
                .ClickOnOpenAccountButton()
                .SelectCustomerNameFromDropDown(6)
                .SelectRandomCurrency()
                .ClickOnProcessButton();
        openAccountPage.getAccountNumberFromAlert();
        openAccountPage.closeAlert();;
        */

    }
}
