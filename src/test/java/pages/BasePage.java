package pages;

import java.time.Duration;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    public void takeScreenshot(String fileName) {
        TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
        File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), Paths.get("target/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
