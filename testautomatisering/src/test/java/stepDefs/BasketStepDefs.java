package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class BasketStepDefs {
    private WebDriver driver;
    private static void click(WebDriver driver, By by) {
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
    @Given("I am on Basketball Englands registration page using {string}")
    public void iAmOnBasketballEnglandsRegistrationPageUsing(String browser) {
        switch (browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;

            case "Edge":
                driver = new EdgeDriver();
                break;
        }
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @Given("I have entered date of birth")
    public void iHaveEnteredDateOfBirth() {
        driver.findElement(By.id("dp")).sendKeys("1/1/2000");
    }

    @Given("I have entered first name")
    public void iHaveEnteredFirstName() {
        driver.findElement(By.id("member_firstname")).sendKeys("Otto");
    }

    @Given("I have entered last name {string}")
    public void iHaveEnteredLastName(String lastName) {
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
    }

    @Given("I have entered and confirmed e-mail address {string}")
    public void iHaveEnteredAndConfirmedEMailAddress(String email) {
        int random = (int) (Math.random() * 9999) + 1;

        driver.findElement(By.id("member_emailaddress")).sendKeys(random + email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(random + email);
    }

    @Given("I have entered password {string}")
    public void iHaveEnteredPassword(String password) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
    }

    @Given("I have confirmed password {string}")
    public void iHaveConfirmedPassword(String confirmPassword) {
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
    }

    @Given("Terms and condition {string}")
    public void termsAndCondition(String status) {
        if (status.equals("checked")) { // Om terms & conditions ska vara ikryssad, klicka på knappen
            driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
        }
    }

    @Given("I have checked I am over 18 and accepted code of conduct")
    public void iHaveCheckedIAmOverAndAcceptedCodeOfConduct() {
        click(driver, By.cssSelector(".md-checkbox:nth-child(2) > label > .box")); // Explicit wait
        click(driver, By.cssSelector(".md-checkbox:nth-child(7) .box")); // Explicit wait
    }

    @When("I click confirm and join")
    public void iClickConfirmAndJoin() {
        click(driver, By.name("join")); // Explicit wait
    }

    @Then("Verify that {string} is shown")
    public void verifyThatIsShown(String expected) {
        String actual;
        WebElement error; // Locator för error messages
        WebElement confirm; // Locator för lyckad registrering

        switch (expected) {
            case "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND" -> {
                confirm = driver.findElement(By.cssSelector(".bold:nth-child(1)"));
                actual = confirm.getText();
                assertEquals(expected, actual);
            }
            case "Last Name is required", "You must confirm that you have read and accepted our Terms and Conditions", "Password did not match" -> {
                error = driver.findElement(By.cssSelector(".warning > span"));
                actual = error.getText();
                assertEquals(expected, actual);
            }
        }
        driver.close();
    }
}