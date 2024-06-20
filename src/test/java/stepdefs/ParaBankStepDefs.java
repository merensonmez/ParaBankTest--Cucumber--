package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import pages.ParaBankPage;
import utilities.Driver;
import utilities.WaitUtils;

public class ParaBankStepDefs {
    ParaBankPage paraBankPage = new ParaBankPage();

    Faker faker = new Faker();
    String firstName = faker.name().fullName();
    String fakeLastName = faker.name().lastName();
    String fakeAddress = faker.address().fullAddress();
    String fakeCity = faker.address().city();
    String fakeState = faker.address().state();
    String fakeZipCode = faker.address().zipCode();
    String fakePhoneNumber= faker.phoneNumber().phoneNumber();
    String fakeUsername = faker.name().username();
    String fakePassword = RandomStringUtils.randomAlphanumeric(10);

    @Given("user goes to site")
    public void user_goes_to_site() {
        Driver.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
        Driver.getDriver().navigate().refresh();
    }
    @Given("user click register button")
    public void user_click_register_button() {
        paraBankPage.register.click();

    }
    @Given("user write personal information")
    public void user_write_personal_information() {
        paraBankPage.firstname.sendKeys(firstName);
        WaitUtils.waitFor(1);
        paraBankPage.lastname.sendKeys(fakeLastName);
        WaitUtils.waitFor(1);
        paraBankPage.address.sendKeys("Slas Ks");
        WaitUtils.waitFor(1);
        paraBankPage.city.sendKeys(fakeCity);
        WaitUtils.waitFor(1);
        paraBankPage.state.sendKeys(fakeState);
        WaitUtils.waitFor(1);
        paraBankPage.zipCode.sendKeys(fakeZipCode);
        WaitUtils.waitFor(1);
        paraBankPage.phoneNumber.sendKeys(fakePhoneNumber);
        WaitUtils.waitFor(1);
        paraBankPage.ssn.sendKeys("123456789");
        WaitUtils.waitFor(1);
        paraBankPage.username.sendKeys(fakeUsername);
        System.out.println("Generated username: " +fakeUsername);
        WaitUtils.waitFor(1);
        paraBankPage.password.sendKeys(fakePassword);
        System.out.println("Generated password: " +fakePassword);
        paraBankPage.repeatedPassword.sendKeys(fakePassword);
        WaitUtils.waitFor(2);
        paraBankPage.registerButton.click();

    }

    @Given("user click open new account button and create account")
    public void user_click_open_new_account_button_and_create_account() {
        paraBankPage.openNewAccount.click();
        WaitUtils.waitFor(1);
        paraBankPage.lastOpenNewAccount.click();

    }
    @Given("user click Transfer fund and transfer money from first account to another account")
    public void user_click_transfer_fund_and_transfer_money_from_first_account_to_another_account() {
        paraBankPage.transferFunds.click();
        Select objSelect = new Select(Driver.getDriver().findElement(By.id("toAccountId")));
        objSelect.selectByIndex(1);
    }
    @Given("user click bill pay and enter payee information")
    public void user_click_bill_pay_and_enter_payee_information() {

    }
    @Given("user click find transactions")
    public void user_click_find_transactions() {

    }
    @Then("user click request load and write amount")
    public void user_click_request_load_and_write_amount() {

    }

}
