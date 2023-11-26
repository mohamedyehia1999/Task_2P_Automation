package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerPage
{
    private WebDriver driver;
    public CustomerPage(WebDriver driver)
    {
        this.driver=driver;
    }
    private By table = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]");
    private By DeleteButton = By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[5]/button");

    public void ScrollToTable()
    {
        WebElement tableElement = driver.findElement(table);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script , tableElement);
    }
    public void DeleteCustomerFromList(){
        driver.findElement(DeleteButton).click();
    }
}
