package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private WebDriver driver;
    private By summaryCheckout_btn = By.cssSelector("p.cart_navigation.clearfix>a>span");
 //  private By summaryCheckout_btn = By.className("button.btn.btn-default.standard-checkout.button-medium");
    private By addressCheckout_btn = By.cssSelector("button[name='processAddress']");
    private By shippingCheckout_btn = By.cssSelector("button[name='processCarrier']");
    private By agreement_checkbox = By.id("uniform-cgv");
    private By bankWire = By.className("bankwire");
    private By confirmOrder_btn = By.cssSelector("button.button.btn.btn-default.button-medium");
  //  private By orderReference = By.cssSelector("div.box>br:nth-child(10)");
  private By orderReference = By.cssSelector("div.box");
  //  private By orderReference = By.xpath("//strong[text()='RTP']/following-sibling::br[1]");
    private By backToOrders_btn = By.cssSelector("a[title='Back to orders']");

    public OrderPage(WebDriver driver){
        this.driver=driver;
    }
/*
    public void scrollToBottom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,800)");
    }
*/
    public void proceedSummary(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(summaryCheckout_btn)).click();
    }

    public void proceedAddress(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressCheckout_btn)).click();
    }

    public void proceedShipping(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingCheckout_btn)).click();
    }

    public void checkAgree(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(agreement_checkbox)).click();
    }

    public void chooseBankWire(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(bankWire)).click();
    }

    public void confirmOrder(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder_btn)).click();
    }

    public String getReferenceNumber(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        String order =wait.until(ExpectedConditions.visibilityOfElementLocated(orderReference)).getText();
        order = order.substring(order.indexOf("reference")+10,order.indexOf("in ")).trim();
        return order;
    }

    public void proceedToCheckout(){
        proceedSummary();
        proceedAddress();
        checkAgree();
        proceedShipping();
    }

    public void goToOrderHistory(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(backToOrders_btn)).click();
    }
}
