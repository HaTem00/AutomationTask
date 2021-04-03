package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryPage {
    private WebDriver driver;
    private By order = By.cssSelector("tr.first_item>td>a");

    public OrderHistoryPage(WebDriver driver){
        this.driver=driver;
    }

    public String getOrderId(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(order)).getText();
    }
}
