package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    private LoginPage loginPage;
    private CandidatesPage candidatePage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public CandidatesPage getCandidatesPage() {
        if (candidatePage == null) {
            candidatePage = new CandidatesPage(driver);
        }
        return candidatePage;
    }

}