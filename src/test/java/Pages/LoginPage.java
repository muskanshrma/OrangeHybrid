package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public static Properties prop;

    By loginPageVerify = By.xpath("//h5");
    By username = By.xpath("//input[@name='username']");
    By loginPassword = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By homePageVerify = By.xpath("//h6");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() throws IOException {
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//TestData//resources.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageVerify));
        driver.findElement(username).sendKeys(prop.getProperty("uName"));
        driver.findElement(loginPassword).sendKeys(prop.getProperty("pass"));
    }

    public void loginButton() throws IOException {

        driver.findElement(loginButton).click();
    }

    public void verification() throws IOException {
        boolean isResultDisplayed = driver.findElement(homePageVerify).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "Login error");
    }
}