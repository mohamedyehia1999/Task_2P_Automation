package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerPage {
    private  WebDriver driver;
    private By FirstNameField = By.xpath("//*[@ng-model='fName']");
    private By LastNameField = By.xpath("//*[@ng-model='lName']");
    private By PostalCodeField = By.xpath("//*[@ng-model='postCd']");
    private By SubmitButton = By.xpath("//*[@type='submit']");
    public AddCustomerPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public AddCustomerPage AddCustomer(String FirstName , String LastName , String PostalCode  ){
        driver.findElement(FirstNameField).sendKeys(FirstName);
        driver.findElement(LastNameField).sendKeys(LastName);
        driver.findElement(PostalCodeField).sendKeys(PostalCode);
        driver.findElement(SubmitButton).click();
        return this;
    }
    public  String getCustomerId(){
        return driver.switchTo().alert().getText();
    }
    public  BankManagerPage closeAlert(){
        driver.switchTo().alert().accept();
        return new BankManagerPage(driver);
    }
}
