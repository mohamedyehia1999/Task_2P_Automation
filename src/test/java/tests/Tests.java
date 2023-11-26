package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class Tests extends BaseTest
{
    protected HomePage homePage;
    protected AddCustomerPage addCustomerPage;
    protected BankManagerPage bankManagerPage;
    protected OpenAccountPage openAccountPage;
    protected CustomerPage customerPage;

    @Test
    public void AllScenarioTestCases() {
        homePage = new HomePage(driver);
        addCustomerPage = new AddCustomerPage(driver);
        bankManagerPage = new BankManagerPage(driver);
        openAccountPage = new OpenAccountPage(driver);
        customerPage = new CustomerPage(driver);

        // Scenario 1

        homePage
                .ClickOnBankingLink()
                .ClickOnBankManagerLoginButton()
                .ClickOnAddCustomerButton()
                .AddCustomer("Mohamed", "Yehia", "1");

        String CustomerId = addCustomerPage.getCustomerId();

        // Splitting the text to get the customer ID

        String [] parts = CustomerId.split(":");
        String ID = parts[1];
        addCustomerPage.closeAlert();
        Assert.assertEquals( ID,"6");


        // Scenario 2
       bankManagerPage
               .ClickOnOpenAccountButton()
                .SelectCustomerNameFromDropDown(5)
                .SelectRandomCurrency()
                .ClickOnProcessButton();

        String AllMessage = openAccountPage.getAccountNumberFromAlert();

        String[] SplitAccountNumber = AllMessage.split(":");
        String AccountNumber = SplitAccountNumber[1];
        openAccountPage.closeAlert();


        // Scenario 3
        bankManagerPage
                .ClickOnCustomersButton()
                .DeleteCustomerFromList();


    }

}
