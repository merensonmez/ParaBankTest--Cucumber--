package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ParaBankPage {
    public ParaBankPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//a[normalize-space()='Register'])[1]")
    public WebElement register;

    @FindBy(id = "customer.firstName")
    public WebElement firstname;

    @FindBy(id = "customer.lastName")
    public WebElement lastname;

    @FindBy(id = "customer.address.street")
    public WebElement address;

    @FindBy(id = "customer.address.city")
    public WebElement city;

    @FindBy(id = "customer.address.state")
    public WebElement state;

    @FindBy(id = "customer.address.zipCode")
    public WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    public WebElement ssn;

    @FindBy(id = "customer.username")
    public WebElement username;

    @FindBy(id = "customer.password")
    public WebElement password;

    @FindBy(id = "repeatedPassword")
    public WebElement repeatedPassword;

    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerButton;


    @FindBy(xpath ="/html[1]/body[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement openNewAccount;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement lastOpenNewAccount;
    @FindBy(id = "newAccountId")
    public WebElement newAccountId;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFunds;

    @FindBy(xpath = "//input[@value='Transfer']")
    public WebElement transfer;
}
