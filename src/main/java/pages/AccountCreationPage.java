package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationPage {
    private WebDriver driver;
    private By male_radioBtn = By.id("id_gender1");
    private By firstName_field = By.id("customer_firstname");
    private By lastName_field = By.id("customer_lastname");
    private By email_field = By.id("email");
    private By password_field = By.id("passwd");
    private By days_dropDownList = By.id("days");
    private By months_dropDownList = By.id("months");
    private By years_dropDownList = By.id("years");
    private By company_field = By.id("company");
    private By address_field = By.id("address1");
    private By address2_field = By.id("address2");
    private By city_field = By.id("city");
    private By state_dropDownList = By.id("id_state");
    private By postCode_field = By.id("postcode");
    private By country_dropDownList = By.id("id_country");
    private By mobilePhone_field = By.id("phone_mobile");
    private By register_btn = By.id("submitAccount");


    public AccountCreationPage(WebDriver driver){
        this.driver=driver;
    }
    public void set_gender(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(male_radioBtn)).click();
    }
    public void set_firstName(String firstName){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(firstName_field)).sendKeys(firstName);
    }
    public void set_lastName(String lastName){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(lastName_field)).sendKeys(lastName);
    }
    public void set_email(String email){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(email_field)).sendKeys(email);
    }
    public void set_password(String password){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(password_field)).sendKeys(password);
    }
    public void selectDayFromDropDown(String day){
        Select day_dropdown = new Select(driver.findElement(days_dropDownList));
        day_dropdown.selectByValue(day);
    }
    public void selectMonthFromDropDown(String month){
        Select month_dropdown = new Select(driver.findElement(months_dropDownList));
        month_dropdown.selectByValue(month);
    }
    public void selectYearFromDayDropDown(String year){
        Select year_dropdown = new Select(driver.findElement(years_dropDownList));
        year_dropdown.selectByValue(year);
    }
    public void set_company(String company){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(company_field)).sendKeys(company);
    }
    public void set_address1(String address){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(address_field)).sendKeys(address);
    }
    public void set_address2(String address2){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(address2_field)).sendKeys(address2);
    }
    public void set_city(String city){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(city_field)).sendKeys(city);
    }
    public void selectStateFromDayDropDown(String state){
        Select state_dropdown = new Select(driver.findElement(state_dropDownList));
        state_dropdown.selectByVisibleText(state);
    }
    public void set_postCode(String postCode){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(postCode_field)).sendKeys(postCode);
    }
    public void selectCountryFromDayDropDown(String country){
        Select country_dropdown = new Select(driver.findElement(country_dropDownList));
        country_dropdown.selectByVisibleText(country);
    }
    public void set_MobilePhone(String mobilePhone){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(mobilePhone_field)).sendKeys(mobilePhone);
    }
    public void click_registerButton(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(register_btn)).click();
    }
    public void registerUser(String firstName,String lastName,String password,String day,String month,String year,String address,String city,String state,String postalCode,String country, String mob){
        set_gender();
        set_firstName(firstName);
        set_lastName(lastName);
        set_password(password);
        selectDayFromDropDown(day);
        selectMonthFromDropDown(month);
        selectYearFromDayDropDown(year);
        set_address1(address);
        set_city(city);
        selectStateFromDayDropDown(state);
        set_postCode(postalCode);
        selectCountryFromDayDropDown(country);
        set_MobilePhone(mob);
        click_registerButton();
    }
}
