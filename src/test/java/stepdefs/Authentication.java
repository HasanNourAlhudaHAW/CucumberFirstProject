package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authentication {

    WebDriver driver;
    Faker faker  = new Faker();
    String randomEmail = faker.internet().emailAddress();

    @Given("user navigates to demo shop site")
    public void user_navigates_to_demo_shop_site() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");

    }

    @And("user hits Log in link")
    public void user_hits_log_in_link() {
        driver.findElement(By.linkText("Log in")).click();
    }


    @When("user enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String string, String string2) {
        driver.findElement(By.id("Email")).sendKeys(string);
        driver.findElement(By.id("Password")).sendKeys(string2);
        driver.findElement(By.xpath("//input[@type=\"submit\"][@value=\"Log in\"]")).click();

    }


    @Then("login should be unsuccessful")
    public void login_should_be_unsuccessful() {

            WebElement element = driver.findElement(By.xpath("//li[contains(text(), 'No customer account found')]"));
            String errorMessage = element.getText();
            Assert.assertEquals(errorMessage, "No customer account found");
    }


    @Then("login should be successful")
    public void login_should_be_successful() {
        WebElement element = driver.findElement(By.xpath("//a[contains(text(), \"HasanNour8@gmail.com\")]"));
        String emailAddress= element.getText();
        Assert.assertEquals(emailAddress, "HasanNour8@gmail.com");
    }


    //Log Out Test
    @Given("User is logged in with a validated email and password")
    public void user_is_logged_in_with_a_validated_email_and_password() {
        this.user_navigates_to_demo_shop_site();
        this.user_hits_log_in_link();
        this.user_enters_email_as_and_password_as("HasanNour8@gmail.com","123456");
    }

    @When("User hits the Log out button")
    public void user_hits_the_log_out_button() {
        driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
    }

    @Then("User should be logged out")
    public void user_should_be_logged_out() {
        WebElement element =driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        String logIn =element.getText();
        Assert.assertEquals(logIn,"Log in");
    }



    @When("User enters an email address in the Subscribe field")
    public void user_enters_an_email_address_in_the_subscribe_field() {
        driver.findElement(By.id("newsletter-email")).sendKeys(randomEmail);
    }
    @And("User hits the Subscribe button for newsletters")
    public void user_hits_the_subscribe_button_for_newsletters() {
        driver.findElement(By.id("newsletter-subscribe-button")).click();
    }

    @Then("User should be subscribed and get message Thank you for signing up!")
    public void user_should_be_subscribed_and_get_message_thank_you_for_signing_up() {

      boolean bool =driver.findElement(By.id("newsletter-result-block")).isEnabled();
         Assert.assertTrue(bool);
    }




}
