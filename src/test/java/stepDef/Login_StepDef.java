package stepDef;





import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Login_StepDef {
        private WebDriver driver;

        @Given("^the user is on the OpenCart login page$")
        public void navigateToLoginPage() {

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            driver.get("https://naveenautomationlabs.com/opencart/");
            WebElement myAccount = driver.findElement(By.linkText("My Account"));
            myAccount.click();
            WebElement register = driver.findElement(By.linkText("Login"));
            register.click();
        }

        @When("^the user enters valid login credentials$")
        public void enterValidLoginCredentials() {
            WebElement email = driver.findElement(By.id("input-email"));
            WebElement password = driver.findElement(By.id("input-password"));

            email.sendKeys("johndoe55@example.com");
            password.sendKeys("password123");
        }

        @When("^clicks the Login button$")
        public void clickLoginButton() {
            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
            loginButton.click();
        }

        @Then("^the user should be logged in successfully$")
        public void verifyLoginSuccess() {
            WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
            Assert.assertTrue(successMessage.getText().contains("Congratulations! You have successfully logged in."));
            driver.quit();
        }
    }


