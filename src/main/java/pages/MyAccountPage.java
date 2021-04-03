package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    private WebDriver driver;
    private By welcomeMsg = By.className("info-account");
    private By signOut_link = By.className("logout");
    private By home_btn = By.cssSelector("a.btn.btn-default.button.button-small");
    private By userName = By.cssSelector("a.account");
    private By womenCategory = By.cssSelector("a[title='Women']");
    private By blousesCategory = By.cssSelector("a[title='Blouses']");

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickHome(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(home_btn));
    }
    public void clickSignOut(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(signOut_link));
    }
    public void selectBlouseCategory(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(womenCategory));
        WebElement women = driver.findElement(womenCategory);
        WebElement blouses = driver.findElement(blousesCategory);
        Actions actions = new Actions(driver);
        actions.moveToElement(women).pause(Duration.ofSeconds(1)).moveToElement(blouses).click().build().perform();
    }
    public String getUserName(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userName)).getText();
    }
    public String getWelcomeMsg(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg)).getText();
    }
}
