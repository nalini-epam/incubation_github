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
import java.util.Random;

public class UserRegistration_StepDef {
    private WebDriver driver;
    String username;
    String password;

    @Given("^the user is on the OpenCart registration page$")
    public void navigateToRegistrationPage() {

        driver = new ChromeDriver();

        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        myAccount.click();
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
    }

    @When("^the user enters valid registration details$")
    public void enterValidRegistrationDetails() {
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        WebElement email = driver.findElement(By.id("input-email"));
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        WebElement password = driver.findElement(By.id("input-password"));
        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
        WebElement agreeCheckbox = driver.findElement(By.name("agree"));

        firstName.sendKeys("John");
        lastName.sendKeys("Doe");
        username="johndoe"+new Random().nextInt(100)+"@example.com";
        System.out.println(username);
        email.sendKeys( username);
        telephone.sendKeys("1234567890");
        password.sendKeys("password123");
        confirmPassword.sendKeys("password123");
        agreeCheckbox.click();
    }

    @When("^clicks the Register button$")
    public void clickRegisterButton() {
        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        registerButton.click();
    }

    @Then("^the user should be registered successfully$")
    public void verifyRegistrationSuccess() {
        WebElement successMessage = driver.findElement(By.id("content"));
        String message =successMessage.getText();
        System.out.println(message);
        Assert.assertTrue(successMessage.getText().contains("Your Account Has Been Created!"));
        driver.quit();
    }
}
