import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.time.Duration;
import java.time.Instant;

@Test
public class WalterBTest extends BaseTest {
    public void getPage() {

        getDriver().get("http://automationpractice.com/index.php/");
        WebElement link = getDriver().findElement(By.xpath("//*[@id=\'editorial_block_center\']/h1"));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertEquals(link.getText(), "Automation Practice Website");

    }
}
