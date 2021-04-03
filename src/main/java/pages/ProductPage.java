package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private By whiteColor = By.id("color_8");
    private By size_dropDownList = By.id("group_1");
    private By addToCart_btn = By.cssSelector("button.exclusive");
    private By checkout_btn = By.cssSelector("a[title='Proceed to checkout']");

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }

    public void selectWhiteColor(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(whiteColor)).click();
    }
    public void selectSize(String size){
        Select size_dropdown = new Select(driver.findElement(size_dropDownList));
        size_dropdown.selectByVisibleText(size);
    }
    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(addToCart_btn)).click();
    }
    public void checkout(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(checkout_btn)).click();
    }
}
