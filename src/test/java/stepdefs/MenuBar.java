package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MenuBar {

    WebDriver driver;

    @Given("user navigates to home page")
    public void user_navigates_to_home_page() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");

    }
    @And("{string} is visible")
    public void is_visible(String string) {
        List<WebElement> navBar=driver.findElements(By.cssSelector(".top-menu >li"));
        for (WebElement s : navBar) {

            String text= s.getText();
            if(text.equals(string)){
                System.out.println(string + " is available");
                break;
            }

        }
    }



}







