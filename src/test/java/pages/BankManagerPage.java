package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankManagerPage
{
    private WebDriver driver;
    private By AddCustomerButton = By.xpath("//*[@ng-class = 'btnClass1']");
    private By OpenAccountButton = By.xpath("//*[@ng-class = 'btnClass2']");
    private By OpenCustomersButton = By.xpath("//*[@ng-class = 'btnClass3']");

    public BankManagerPage(WebDriver driver)
    {

        this.driver=driver;
    }
    public AddCustomerPage ClickOnAddCustomerButton(){
        driver.findElement(AddCustomerButton).click();
        return new AddCustomerPage(driver);
    }

    public OpenAccountPage ClickOnOpenAccountButton(){
        driver.findElement(OpenAccountButton).click();
        return new OpenAccountPage(driver);
    }
    public CustomerPage ClickOnCustomersButton(){
        driver.findElement(OpenCustomersButton).click();
        return new CustomerPage(driver);
    }

}
