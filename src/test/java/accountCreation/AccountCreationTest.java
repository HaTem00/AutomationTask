package accountCreation;

import base.BaseTests;
import data.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.io.IOException;

public class AccountCreationTest extends BaseTests {
    public static String newMail = "test"+System.currentTimeMillis()+"@gmail.com";
    HomePage homePage;
    AuthenticationPage authPage;
    AccountCreationPage accountCreationPage;
    MyAccountPage myAccountPage;

    @DataProvider(name="UserData")
    public Object[][] userRegistrationData() throws IOException {
        ExcelReader ER = new ExcelReader();
        return ER.getUserData();
    }

    @Test(dataProvider = "UserData")
    public void goSignIn(String firstName,String lastName,String password,String day,String month,String year,String address,String city,String state,String postalCode,String country, String mob){
        homePage = new HomePage(driver);
        homePage.clickOnSignInLink();
        authPage = new AuthenticationPage(driver);
        authPage.set_newEmail(newMail);
        authPage.clickOnCreateAccountBtn();
        accountCreationPage = new AccountCreationPage(driver);
        accountCreationPage.registerUser(firstName,lastName,password,day,month,year,address,city,state,postalCode,country,mob);
        myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getUserName().contains(firstName));
    }

}
