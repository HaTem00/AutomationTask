package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
    private WebDriver driver;
    private By emailCreation_field = By.id("email_create");
    private By createAnAccount_btn = By.id("SubmitCreate");
    private By email_field = By.id("email");
    private By password_field = By.id("passwd");
    private By signIn_btn = By.id("SubmitLogin");
    private By backToOrders_btn = By.cssSelector("a[title='Back to orders']");

    public AuthenticationPage(WebDriver driver){
        this.driver=driver;
    }
    public void set_newEmail(String newMail){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(emailCreation_field)).sendKeys(newMail);
    }
    public void clickOnCreateAccountBtn(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(createAnAccount_btn)).click();
    }
    public void set_Email(String email){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(email_field)).sendKeys(email);
    }
    public void set_password(String password){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(password_field)).sendKeys(password);
    }
    public void clickOnSignIntBtn(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(signIn_btn)).click();
    }
    public void clickOnCBackToOrdersBtn(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(backToOrders_btn)).click();
    }
    public void signIn(String mail, String password){
        set_Email(mail);
        set_password(password);
        clickOnSignIntBtn();
    }
}
