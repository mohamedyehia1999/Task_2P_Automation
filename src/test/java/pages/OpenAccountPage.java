package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class OpenAccountPage   {
    private  WebDriver driver;
    private By CustomerName_DropDown = By.id("userSelect");
    private By Currency_DropDown = By.id("currency");
    WebElement dropDownCurrency = driver.findElement(Currency_DropDown);
    private By ProcessButton = By.xpath("//*[@type='submit']");
    public OpenAccountPage(WebDriver driver)
    {

        this.driver=driver;
    }
    public OpenAccountPage SelectCustomerNameFromDropDown(int index){
        Select CustomerName = new Select(driver.findElement(CustomerName_DropDown));
        CustomerName.selectByIndex(index);
        return this;
    }
    public OpenAccountPage SelectRandomCurrency()
    {
        // Get all options within the dropdown
        List<WebElement> currencyOptions = dropDownCurrency.findElements(By.tagName("option"));

        // Select a random option from the list
        int numberOfCurrencies = currencyOptions.size();
        Random random = new Random();
        int randomIndex = random.nextInt(numberOfCurrencies);

        // Click on the randomly selected option
        currencyOptions.get(randomIndex).click();
        return this;

    }
    public OpenAccountPage ClickOnProcessButton()
    {
        driver.findElement(ProcessButton).click();
        return this;

    }
    public String getAccountNumberFromAlert(){
        return driver.switchTo().alert().getText();
    }
    public CustomerPage closeAlert(){
        driver.switchTo().alert().accept();
        return new CustomerPage(driver);
    }

}
