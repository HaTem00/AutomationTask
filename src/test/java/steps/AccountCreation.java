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
import pages.AccountCreationPage;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.concurrent.TimeUnit;

public class AccountCreation {
    private WebDriver driver;
    public static String newMail = "test"+System.currentTimeMillis()+"@gmail.com";
    HomePage homePage;
    AuthenticationPage authPage;
    AccountCreationPage accountCreationPage;
    MyAccountPage myAccountPage;

    @Given("the user is at the home page")
    public void the_user_is_at_the_home_page() {
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
    @When("the user is in authentication page and enter mail")
    public void the_user_is_in_authentication_page_and_enter_mail() {
        authPage = new AuthenticationPage(driver);
        authPage.set_newEmail(newMail);
        authPage.clickOnCreateAccountBtn();
    }

    @And("the user enters {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} in the account creation page")
    public void the_user_enters_the_required_data_in_the_account_creation_page(String firstName,String lastName,String password,String day,String month,String year,String address,String city,String state,String postalCode,String country, String mob) {
        accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.registerUser(firstName,lastName,password,day,month,year,address,city,state,postalCode,country,mob);
    //    accountCreationPage.registerUser(firstName,lastName,password,day,month,year,address,city,state,postalCode,country,mob);
    }
    @Then("the account created successfully")
    public void the_account_created_successfully() {
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getWelcomeMsg().contains("Welcome"));
        driver.quit();
    }

}

