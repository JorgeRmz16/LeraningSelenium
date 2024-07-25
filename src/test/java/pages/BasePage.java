package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    private WebElement find(String locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    public void clickElement(String locator){
        find(locator).click();
    }

    public void write(String locator, String keysToSend){
        find(locator).clear();
        find(locator).sendKeys(keysToSend);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
