package pages;

public class Gugul extends BasePage {

    public Gugul() {
        super(driver);
    }
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }
    public void searchSomething(){
        write("#APjFqb", "clima guadalajara");
    }
    public void clickSearch(){
        clickElement("div[class='FPdoLc lJ9FBc'] input[name='btnK']");
    }
    
}
