package Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CandidatesPage {
    WebDriver driver;
    WebDriverWait wait;

//    By recruitment = By.xpath("//span[contains(text(), 'Recruitment')]");
    By recruitment = By.xpath("(//span[contains(@class,'oxd-main-menu-item--name')])[5]");
    By addUser = By.xpath("//button/i[contains(@class,'bi-plus')]");
    By fName = By.xpath("//input[@name='firstName']");
    By lName = By.xpath("//input[@name='lastName']");
    By mail = By.xpath("//label[contains(text(),'Notes')]/following::input[1]");
    By saveButton = By.xpath("//button[contains(@class,'orangehrm-left-space')]");
    By verify = By.xpath("//h6[contains(@class,'orangehrm-main-title')]");



    public CandidatesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void recruitmentMenu(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(recruitment));
        driver.findElement(recruitment).click();
        driver.findElement(addUser).click();
    }
    public void addCandidate() throws IOException {
        String path = System.getProperty("user.dir") + "//src//test//java//TestData//OrangeRecriutment.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String fname = sheet.getRow(1).getCell(0).getStringCellValue();
        String lname = sheet.getRow(1).getCell(1).getStringCellValue();
        String email = sheet.getRow(1).getCell(2).getStringCellValue();
        driver.findElement(fName).sendKeys(fname);
        driver.findElement(lName).sendKeys(lname);
        driver.findElement(mail).sendKeys(email);
        driver.findElement(saveButton).click();
    }
    public void verify(){
        boolean isResultDisplayed = driver.findElement(verify).isDisplayed();
        org.testng.Assert.assertTrue(isResultDisplayed, "add user error");
    }

}