package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.Gugul;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GugulSteps {
    WebDriver driver;
    Gugul gugul;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless"); // Ejecutar en modo sin cabeza
        options.addArguments("--remote-allow-origins=*");  // Agregar esta línea

        driver = new ChromeDriver(options);
        gugul = new Gugul(driver);
    }

    @Given("I navigate to www.google.com")
    public void navigateToGoogle() {
        gugul.navigateToGoogle();
    }

    @When("I go to search something and click")
    public void searchWatter() {
        gugul.searchSomething();
        gugul.clickSearch();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
