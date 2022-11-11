package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListCard {


    Authentication driver = new Authentication();
    Faker faker  = new Faker();
    String randomEmail = faker.internet().emailAddress();

    @Given("User is logged in with validated email and password")
    public void user_is_logged_in_with_validated_email_and_password() {
       driver.user_is_logged_in_with_a_validated_email_and_password();
    }
    @Given("User moves to gift card on the bar")
    public void user_moves_to_gift_card_on_the_bar() {
        driver.driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[7]/a[1]")).click();
    }
    @Given("User selects a gift card")
    public void user_selects_a_gift_card() {
        driver.driver.findElement(By.xpath("//a[@title= \"Show details for $5 Virtual Gift Card\"]")).click();
    }
    @When("User enters the recipient's name")
    public void user_enters_the_recipient_s_name() {
        driver.driver.findElement(By.id("giftcard_1_RecipientName")).sendKeys("Name");
    }
    @When("user enters the recipient's email")
    public void user_enters_the_recipient_s_email() {
        driver.driver.findElement(By.id("giftcard_1_RecipientEmail")).sendKeys(randomEmail);
    }
    @When("User hits the button Add to wishlist")
    public void user_hits_the_button_add_to_wishlist() {
        driver.driver.findElement(By.id("add-to-wishlist-button-1")).click();
    }
    @Then("User should receive the message The product has been added to your wishlist")
    public void user_should_receive_the_message_the_product_has_been_added_to_your_wishlist() {
        Boolean isEnabled  =driver.driver.findElement(By.id("bar-notification")).isEnabled();
        Assert.assertTrue(isEnabled);
    }
}
