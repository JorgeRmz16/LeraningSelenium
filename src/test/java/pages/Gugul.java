package pages;

import org.openqa.selenium.WebDriver;

public class Gugul extends BasePage {

    public Gugul(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
        takeScreenshot("navigateToGoogle");
    }

    public void searchSomething() {
        write("#APjFqb", "clima guadalajara");
        takeScreenshot("searchSomething");
    }

    public void clickSearch() {
        clickElement("div[class='FPdoLc lJ9FBc'] input[name='btnK']");
        takeScreenshot("clickSearch");
    }
}
