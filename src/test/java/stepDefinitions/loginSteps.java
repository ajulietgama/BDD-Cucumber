package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class loginSteps {
    WebDriver driver;


    @Given("The tour page")
    public void the_tour_page() {
        System.out.println("Setting up chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/register.php");

    }

    @When("I specify user name and password")
    public void i_specify_user_name_and_password() {
        System.out.println("User enters username and password");
        WebElement register = driver.findElement(By.xpath("//img[@src='images/mast_register.gif']"));

        if (register.isDisplayed()){
            driver.findElement(By.id("email")).sendKeys("qualityadmin");
            driver.findElement(By.name("password")).sendKeys("pass1");
            driver.findElement(By.name("confirmPassword")).sendKeys("pass1");
            driver.findElement(By.name("submit")).click();
        } else {
            System.out.println("Register page not found");
        }

    }



    @Then("I can log into the website")
    public void i_can_log_into_the_website() {
        System.out.println("User on homepage");

        driver.quit();
    }




}
