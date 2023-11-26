package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class HomePage{
    private WebDriver driver;
    private By BankingLink = By.xpath("//*[@alt='banking']");
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public BankingPage ClickOnBankingLink(){
        String parent =driver.getWindowHandle();
        driver.findElement(BankingLink).click();
        Set<String> allWindow =driver.getWindowHandles();
        for(String window : allWindow){
            if (!window.equalsIgnoreCase(parent)) {
                driver.switchTo().window(window);
            }
        }

        return new BankingPage(driver);
    }
}
