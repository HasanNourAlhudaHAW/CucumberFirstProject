package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
    WebDriver driver;
    Faker faker  = new Faker();
    String randomEmail = faker.internet().emailAddress();

    @Given("User have a Chrome browser running")
    public void user_have_a_chrome_browser_running() {

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }
    @When("User go to tricentis.com")
    public void user_go_to_tricentis_com() {

        driver.get("https://demowebshop.tricentis.com");

    }

    @When("User clicks on register link button")
    public void user_clicks_on_register_link_button() {
        driver.findElement(By.linkText("Register")).click();
    }

    @And("User enters first name")
    public void user_enters_first_name() {
        driver.findElement(By.id("FirstName")).sendKeys("Test1");
    }
    @And("User enters last name")
    public void user_enters_last_name() {
        driver.findElement(By.id("LastName")).sendKeys("Test2");
    }
    @And("User enters invalid email format")
    public void user_enters_invalid_email_format() throws InterruptedException {

        driver.findElement(By.id("Email")).sendKeys("adlkadjlakdjajdaldjdasl");
    }

    @And("User tries to enter password")
    public void user_tries_to_enter_password() {
        driver.findElement(By.id("Password")).sendKeys(" ");
    }
    @Then("User should get an error message: Wrong email")
    public void user_should_get_an_error_message_wrong_email() {
        WebElement element =driver.findElement(By.xpath("//span[contains(text(), 'Wrong email')]"));

        String errorMessage = element.getText();
        Assert.assertEquals(errorMessage, "Wrong email");
    }



    @Given("user is on Demo home page")
    public void user_is_on_demo_home_page() {
        this.user_have_a_chrome_browser_running();
        this.user_go_to_tricentis_com();
    }

    @When("user clicks on register link")
    public void user_clicks_on_register_link() {

        this.user_clicks_on_register_link_button();
    }


    @And("user fills out the fields and clicks on register")
    public void user_fills_out_the_fields_and_clicks_on_register() {

        driver.findElement(By.id("gender-male")).click();
        this.user_enters_first_name();
        this.user_enters_last_name();
        driver.findElement(By.id("Email")).sendKeys(randomEmail);
        driver.findElement(By.id("Password")).sendKeys("randomPassword");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("randomPassword");
        driver.findElement(By.id("register-button")).click();
    }



    @Then("user should gets Your registration completed")
    public void user_should_gets_your_registration_completed() {

        String text=  driver.findElement(By.xpath("//div[@class='result']")).getText();
        Assert.assertEquals(text, "Your registration completed");

    }
    @Then("user should be able to press continue")
    public void user_should_be_able_to_press_continue() throws InterruptedException {

        driver.findElement(By.xpath("//input[@type='button'][@class=\"button-1 register-continue-button\"]")).click();
        WebElement element =driver.findElement(By.linkText(randomEmail));
        String email =element.getText();
        Assert.assertEquals(email, randomEmail);
        driver.quit();
    }









}
