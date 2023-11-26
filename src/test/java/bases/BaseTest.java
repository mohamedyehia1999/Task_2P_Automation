package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;


public class BaseTest
{
    protected static WebDriver driver;
    protected HomePage homePage;
    @BeforeMethod
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.navigate().to("https://www.way2automation.com/protractor-angularjs-practice-website.html");
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void tearDown(ITestResult result){

        String TestCaseName = result.getMethod().getMethodName();
        File destFile = new File("target" + File.separator + "ScreenShots" + File.separator + TestCaseName + ".png");
        TakeScreenShots(destFile);
        //driver.quit();


    }
    public  void TakeScreenShots(File destFile){

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file , destFile);
            InputStream inputStream = new FileInputStream(destFile);
            Allure.addAttachment("Screenshot" , inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
