package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankingPage
{
    private WebDriver driver;
    private By BankManagerLoginButton= By.xpath("//*[@ng-click='manager()']");

    public BankingPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public BankManagerPage ClickOnBankManagerLoginButton(){
        driver.findElement(BankManagerLoginButton).click();
        return new BankManagerPage(driver);
    }

}
