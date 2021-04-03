package steps;

import base.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import pages.*;

import java.util.concurrent.TimeUnit;

public class CartCheckout {
    private WebDriver driver;
    private String password = "password0";
    private String size = "M";
    private String orderId;
    private String orderId2;
    HomePage homePage;
    AuthenticationPage authPage;
    MyAccountPage myAccountPage;
    CategoryPage categoryPage;
    ProductPage productPage;
    OrderPage orderPage;
    OrderHistoryPage orderHistoryPage;


    @Given("the user is in the home page")
    public void the_user_in_the_home_page() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("resolution", "1024x768");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        homePage.clickOnSignInLink();
    }

    @When("the user sign in")
    public void the_user_sign_in() {
        authPage = new AuthenticationPage(driver);
        authPage.signIn(AccountCreation.newMail,password);
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getWelcomeMsg().contains("Welcome"));
    }

    @And("the user select Blouses Subcategory in Women Category")
    public void the_user_select_Blouses_Subcategory_in_Women_Category() {
        myAccountPage = new MyAccountPage(driver);
        myAccountPage.selectBlouseCategory();
    }

    @And("the user Select resulted product")
    public void the_user_Select_resulted_product() {
        categoryPage = new CategoryPage(driver);
        categoryPage.selectTheProduct();
    }

    @And("the user select White colour and M size")
    public void the_user_select_White_colour_and_M_size() {
        productPage = new ProductPage(driver);
        productPage.selectWhiteColor();
        productPage.selectSize(size);
        productPage.addToCart();
        productPage.checkout();
    }

    @And("the user follow checkout procedure")
    public void the_user_follow_checkout_procedure() {
        orderPage = new OrderPage(driver);
        orderPage.proceedToCheckout();
    }

    @And("the user confirm order by selecting bank wire option")
    public void the_Confirm_order_by_selecting_bank_wire_option() {
        orderPage = new OrderPage(driver);
        orderPage.chooseBankWire();
        orderPage.confirmOrder();
        orderId=orderPage.getReferenceNumber();
        orderPage.goToOrderHistory();
    }

    @Then("the order was placed and found in order history page")
    public void the_order_was_placed_and_found_in_order_history_page() {
        orderHistoryPage = new OrderHistoryPage(driver);
        orderId2 = orderHistoryPage.getOrderId();
        Assert.assertEquals(orderId,orderId2);
        driver.quit();
    }

}
