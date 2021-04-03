package checkout;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import accountCreation.AccountCreationTest;

public class CartCheckoutTest extends BaseTests {
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

    @Test
    public void checkout(){
    homePage = new HomePage(driver);
    homePage.clickOnSignInLink();
    authPage = new AuthenticationPage(driver);
    authPage.signIn(AccountCreationTest.newMail,password);
    myAccountPage = new MyAccountPage(driver);
    myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getWelcomeMsg().contains("Welcome"));
    myAccountPage.selectBlouseCategory();
    categoryPage = new CategoryPage(driver);
    categoryPage.selectTheProduct();
    productPage = new ProductPage(driver);
    productPage.selectWhiteColor();
    productPage.selectSize(size);
    productPage.addToCart();
    productPage.checkout();
    orderPage = new OrderPage(driver);
    orderPage.proceedToCheckout();
    orderPage.chooseBankWire();
    orderPage.confirmOrder();
    orderId=orderPage.getReferenceNumber();
    orderPage.goToOrderHistory();
    orderHistoryPage = new OrderHistoryPage(driver);
    orderId2 = orderHistoryPage.getOrderId();
        Assert.assertEquals(orderId,orderId2);
    }


}
