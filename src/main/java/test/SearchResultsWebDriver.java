package test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import subClasses.ConfigData;
import subClasses.Fields;

import java.io.File;
import java.io.IOException;

public class SearchResultsWebDriver {

    private WebDriver driver;

    DesiredCapabilities capabilities = DesiredCapabilities.chrome();

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Users\\Bohdan_Mamai\\Desktop\\ONAPP\\Package2_shared_cart\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        driver = new ChromeDriver(service, options);
    }

    @Test(description = "Just first test, JIRA binding can be here")
    public void firstPageOfResults() throws IOException {
        Fields fields = new Fields(driver);

        fields.openGoogle()
                .inputSearchText();

        WebElement page = driver.findElement(By.xpath(ConfigData.FIRST_PAGE));
        WebElement text = driver.findElement(By.xpath(ConfigData.RESULT_FIELD));

        Assert.assertEquals(page.getText(),"1");
        Assert.assertEquals(text.getText(),ConfigData.RESULT_TEXT);

        if(text.isDisplayed()){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[@href=\"https://en.wikipedia.org/wiki/Bicycle\"]/h3")));
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Bohdan_Mamai\\Desktop\\Java\\screenshot.png"));
            System.out.println("Page number: " + page.getText());
        }

    }

    @Test(description = "Just second test, JIRA binding can be here")
    public void furtherThen10Page() throws IOException {
        Fields fields = new Fields(driver);
        fields.select18Page();

        WebElement element = driver.findElement(By.xpath(ConfigData.LAST_ELEMENT_OF_PAGE_LIST));

        if(driver.getPageSource().contains(ConfigData.RESULT_TEXT_SECOND)) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Bohdan_Mamai\\Desktop\\Java\\screenshotSecond.png"));
            System.out.println("Page number: " + element.getText());
        }

    }

    @Test(description = "Just third test, JIRA binding can be here")
    public void isNotInTheSearch() throws IOException {
        Fields fields = new Fields(driver);

        fields.openGoogle()
                .inputSearchText();

        boolean element = driver.getPageSource().contains(ConfigData.Text_FOR_THIRD_TEST);
        WebElement searchField = driver.findElement(By.xpath(ConfigData.SEARCH_FIELD));

        if(element){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.getPageSource().contains(ConfigData.Text_FOR_THIRD_TEST));
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("C:\\Users\\Bohdan_Mamai\\Desktop\\Java\\screenshotThird.png"));
            System.out.println("Page number: " + searchField.getText());
        } else {
            System.out.println("We can find " + ConfigData.Text_FOR_THIRD_TEST + " word for you.");
        }

    }

    @AfterTest(alwaysRun = true)
    public void browseTearDown() {
        driver.quit();
    }

}
