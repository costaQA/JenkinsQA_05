import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class GroupSqaeTest extends BaseTest {

    @Test
    public void testNameFormInsurance() {
        getDriver().get("https://insurance.experian.com/sign-up/name");

        WebElement firstName = getDriver().findElement(By.cssSelector("input[name='first_name']"));
        firstName.sendKeys("Ivan");

        WebElement lastName = getDriver().findElement(By.cssSelector("input[name='last_name']"));
        lastName.sendKeys("Smith");

        WebElement buttonNextStep = getDriver().findElement(By.cssSelector("button[data-title='Next Step']"));
        buttonNextStep.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://insurance.experian.com/sign-up/birthdate");
    }

    @Test
    public void testBirthdayFormInsurance() {
        getDriver().get("https://insurance.experian.com/sign-up/birthdate");

        WebElement birthday = getDriver().findElement(By.cssSelector("input[name='date_of_birth']"));
        birthday.sendKeys("12031988");

        WebElement buttonNextStep = getDriver().findElement(By.cssSelector("button[data-title='Next Step']"));
        buttonNextStep.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "https://insurance.experian.com/sign-up/address");

    }

    @Test
    public void testPageTitleOfMagazine() {
        getDriver().get("https://www.theatlantic.com/");
        String actualTitle = getDriver().getTitle();
        String expectedTitle = "The Atlantic";

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void testCancelLabelOnSubscribePageOfMagazine() {
        getDriver().get("https://www.theatlantic.com/");
        WebElement subscribeButton = getDriver().findElement(By.xpath("//*[@id='__next']/nav/div/div[2]/ul/li[2]/a"));
        subscribeButton.click();

        String expectedCancelLabel = "You can cancel anytime.";

        WebElement cancelAnyTimeLabel = getDriver().findElement(By.xpath("//*[@id='root']/div[2]/div/header/h3"));
        Assert.assertEquals(cancelAnyTimeLabel.getText(), expectedCancelLabel);
    }

    @Test
    public void testHeaderLinksOnTitlePageOfMagazine() {
        getDriver().get("https://www.theatlantic.com/");
        WebElement linkPopular = getDriver().findElement(By.linkText("Popular"));
        linkPopular.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.theatlantic.com/most-popular/");

        getDriver().get("https://www.theatlantic.com/");
        WebElement linkLatest = getDriver().findElement(By.linkText("Latest"));
        linkLatest.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.theatlantic.com/latest/");

        getDriver().get("https://www.theatlantic.com/");
        WebElement linkNewsletters = getDriver().findElement(By.linkText("Newsletters"));
        linkNewsletters.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.theatlantic.com/newsletters/");
    }

    @Test
    public void testPageTitleOfSite() {
        getDriver().get("http://www.seleniumframework.com/Practiceform/");

        String actualSiteTitle = getDriver().getTitle();
        String expectedSiteTitle = "Selenium Framework | Practiceform";

        Assert.assertEquals(actualSiteTitle, expectedSiteTitle);
    }

    @Test
    public void testUrlOfSite() {
        getDriver().get("http://www.seleniumframework.com/Practiceform/");
        getDriver().findElement(By.xpath("//*[@id=\"main-nav\"]/li[8]/a/span")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), "http://www.seleniumframework.com/about-2/");
    }

    @Test
    public void testUrlTitleHeading() {
        getDriver().get("http://www.seleniumframework.com/about-2/");
        getDriver().findElement(By.xpath("//*[@id=\"main-nav\"]/li[1]/a/span")).click();

        String actualUrl = getDriver().getCurrentUrl();
        String expectedUrl = "http://www.seleniumframework.com/";

        Assert.assertEquals(actualUrl, expectedUrl);

        String actualTitle = getDriver().getTitle();
        String expectedTitle = "Selenium Framework | Selenium, Cucumber, Ruby, Java et al.";

        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement actualH2 = getDriver().findElement(By.cssSelector("h2"));

        Assert.assertEquals(actualH2.getText(), "Agile Testing and ATDD Automation –  Free Tutorials");
    }
    @Test
    public void testHerokuApp() {

        getDriver().get("https://formy-project.herokuapp.com/");

        WebElement link = getDriver().findElement(By.xpath("//li/a[@href='/autocomplete']"));

        Assert.assertEquals(link.getText(), "Autocomplete");
    }
    @Test
    public void testHerokuAppSearchCheckboxMenu() {
        getDriver().get("https://formy-project.herokuapp.com/");

        //Thread.sleep(5000);
        WebElement link1 = getDriver().findElement(By.xpath("//li/a[@href='/checkbox']"));

        Assert.assertEquals(link1.getText(), "Checkbox");
    }
}
