package tests;

import bases.BaseTest;
import org.testng.annotations.Test;

public class Scenario3Test extends BaseTest
{
    @Test
    public void UserCanDeleteSuccessfullyTest(){
        homePage
                .ClickOnBankingLink()
                .ClickOnBankManagerLoginButton()
                .ClickOnCustomersButton()
                .DeleteCustomerFromList();
    }
}
