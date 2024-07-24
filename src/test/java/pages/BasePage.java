package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {
    protected static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
 
    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }
 
    public static void navigateTo(String url) {
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

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
