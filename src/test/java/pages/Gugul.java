package pages;

import org.openqa.selenium.WebDriver;

public class Gugul extends BasePage {

    public Gugul(WebDriver driver) {
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
    }

    public void searchSomething() {
        write("#APjFqb", "clima guadalajara");
    }

    public void clickSearch() {
        clickElement("div[class='lJ9FBc'] input[name='btnK']");
    }
}
