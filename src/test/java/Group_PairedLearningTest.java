import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Group_PairedLearningTest {

    @Test
    public void testSubMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/ksenianehotina/Chromedriver/chromedriver3");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "FAQ How to start Ask a question ";

        driver.get(url);

        driver.manage().window().maximize();
        WebElement support = driver.findElement(By.xpath(" //div[@id='support-dropdown']"));

        Thread.sleep(5000);
        support.click();

        List<WebElement> allSupportMenu = driver.findElements(
                By.xpath("//ul[@class='dropdown-menu dropdown-visible']/li/a")
        );
        String actualResult = "";
        for (WebElement supportMenu : allSupportMenu) {
            actualResult += supportMenu.getText() + " ";
        }

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
