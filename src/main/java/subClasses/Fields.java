package subClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fields {
    private WebDriver driver;
    private WebDriverWait wait;

    public Fields(WebDriver driver){
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 5);
    }

    public Fields openGoogle(){
        driver.get(ConfigData.GOOGLE_LINK);
        return this;
    }

    public Fields inputSearchText(){
        WebElement searchField = driver.findElement(By.xpath(ConfigData.SEARCH_FIELD));
        searchField.click();
        searchField.sendKeys("bicycle");
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public Fields select18Page(){
        driver.findElement(By.xpath(ConfigData.LAST_ELEMENT_OF_PAGE_LIST)).click();
        driver.findElement(By.xpath(ConfigData.LAST_ELEMENT_OF_PAGE_LIST)).click();
        return this;
    }

}
