package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
    private WebDriver driver;
//    private By product = By.className("product-name");
    private By product = By.cssSelector("div.right-block>h5>a");

    public CategoryPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectTheProduct(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(product)).click();
    }
}
