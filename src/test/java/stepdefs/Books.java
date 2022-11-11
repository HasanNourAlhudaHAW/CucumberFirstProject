package stepdefs;

import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.An;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Books {

    WebDriver driver;
    @Given("user navigate to home page")
    public void user_navigate_to_home_page() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
    }

    @When("user clicks on Books")
    public void user_clicks_on_books() {
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
    }

    @When("user select a book randomly")
    public void user_select_a_book_randomly() {
        driver.findElement(By.linkText("Computing and Internet")).click();

    }
    @And("clicks on Add to cart")
    public void clicks_on_add_to_cart() {
        driver.findElement(By.id("add-to-cart-button-13")).click();
    }

    @Then("the selected book will be added to shopping.cart")
    public void the_selected_book_will_be_added_to_shopping_cart() throws InterruptedException {

        driver.findElement(By.linkText("Shopping cart")).click();
        List<WebElement> allProducts = driver.findElements(By.xpath("//td/a"));
        for(int i=0; i< allProducts.size(); i++)
        {
            String  productName = allProducts.get(i).getText();
            Assert.assertEquals(productName, "Computing and Internet");

        }

        Thread.sleep(3000);
        driver.close();

    }

    @And("user adds two books to cart")
    public void user_adds_two_books_to_cart() throws InterruptedException {
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();

    }
    @And("the selected books will be added to shopping cart")
    public void the_selected_books_will_be_added_to_shopping_cart() {
        driver.findElement(By.linkText("Shopping cart")).click();
        List<WebElement> allProducts = driver.findElements(By.xpath("//td/a"));

        for (int i = 0; i < allProducts.size(); i++) {
            String productName = allProducts.get(i).getText();
            if (productName.equals("Computing and Internet") || productName.equals("Fiction")) {
                System.out.println(productName + " Added");
            }

        }
    }

        @When("user clicks on the Agree box")
        public void user_clicks_on_the_agree_box() {
        driver.findElement(By.id("termsofservice")).click();


        }
        @When("user clicks on Checkout button")
        public void user_clicks_on_checkout_button() {
            driver.findElement(By.id("checkout")).click();
        }
        @When("user fills out the required fields")
        public void user_fills_out_the_required_fields() {
            driver.findElement(By.id("BillingNewAddress.FirstName")).sendKeys("User1");
            driver.findElement(By.id("BillingNewAddress.LastName")).sendKeys("Muster");
            driver.findElement(By.id("BillingNewAddress.Email")).sendKeys("HasanNour10@gmail.com");
            Select dropCountry =new Select(driver.findElement(By.name("BillingNewAddress.CountryId")));
            dropCountry.selectByVisibleText("Germany");
            driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Hamburg");
            driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("Musterstraße 100");
            driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("12345");
            driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("015767355465");
        }
        @When("user clicks on continue button")
        public void user_clicks_on_continue_button() {
            driver.findElement(By.xpath("//input[@type=\"button\"][@title=\"Continue\"]")).click();
        }
        @When("user clicks in billing address on continue")
        public void user_clicks_in_billing_address_on_continue() {
            driver.findElement(By.xpath("//input[@type=\"button\"][@title=\"Continue\"]")).click();
        }
        @When("user clicks in Shipping address on continue")
        public void user_clicks_in_shipping_address_on_continue() {
            driver.findElement(By.xpath("//input[@type=\"button\"][@title=\"Continue\"]")).click();
        }




    }

