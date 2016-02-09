package step_definitions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {
    public WebDriver driver;

    public StepDefs() {
	driver = Hooks.driver;
    }

    @When("^open gerberlife website$")
    public void open_gerberlife_website() throws Throwable {
	driver.get("https://www.gerberlife.com/gl/view/index.jsp");
    }

    @Then("^verify website title$")
    public void verify_website_title(String title) throws Throwable {
	assertEquals(title, driver.getTitle());
    }

    @Then("^click on apply button$")
    public void click_on_apply_button() throws Throwable {
	driver.findElement(By.id("growup_cta_button_apply")).click();
    }

    @Then("^select \"(.*?)\" in \"(.*?)\" dropdown$")
    public void select_in_dropdown(String value, String field) throws Throwable {
	if (field.equalsIgnoreCase("state")) {
	    new Select(driver.findElement(By.id("state_select"))).selectByVisibleText(value);
	} else if (field.equalsIgnoreCase("age")) {
	    new Select(driver.findElement(By.id("ChildAge"))).selectByVisibleText(value);
	} else if (field.equalsIgnoreCase("gender")) {
	    new Select(driver.findElement(By.id("ChildGender"))).selectByVisibleText(value);
	}
    }

    @Then("^enter \"(.*?)\" in email textbox$")
    public void enter_in_textbox(String emailAddress) throws Throwable {
	driver.findElement(By.name("value(EmailAddress)")).sendKeys(emailAddress);
    }

    @Then("^verify required validation message \"(.*?)\"$")
    public void verify_required_validation_message(String message) throws Throwable {
	WebElement webElement = driver.findElement(By.xpath("//h4[@class='form_header icon_inline pencil error']"));
	assertEquals(message, webElement.getText());
    }

    @Then("^verify email validation message \"(.*?)\"$")
    public void verify_email_validation_message(String message) throws Throwable {
	
    }

    @Then("^verify element on apply page$")
    public void verify_element_on_apply_page() throws Throwable {
	WebElement webElement = driver.findElement(By.id("topsection_right"));
	assertEquals(true, webElement.isDisplayed());
    }

}