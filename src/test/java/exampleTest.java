import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;
    private By loginBtn = By.xpath(ta(   "loginBtn"));
    private By dropdownAllmanagers = By.xpath(ta("dropdownAllmanagers", ".//*[@id='ext-element-144']"));
    private By firstManagerName = By.cssSelector(ta(   "firstManagerName"));
    //private By firstManagerName = By.cssSelector(ta("firstManagerName", ".x-list-label"));


    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("http://examples.sencha.com/coworkee/#login");
        Thread.sleep(5000);
        driver.findElement(loginBtn).click();
        driver.get("http://examples.sencha.com/coworkee/#organizations");
        Thread.sleep(3000);
        driver.findElement(dropdownAllmanagers).click();
        Thread.sleep(3000);
        driver.findElement(firstManagerName).click();
        Thread.sleep(7000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
