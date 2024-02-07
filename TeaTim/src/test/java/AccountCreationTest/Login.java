package AccountCreationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Login {

 
    private static final Logger logger = LoggerFactory.getLogger(Login.class);

    public static void main(String[] arg) {

        WebDriver driver = new ChromeDriver();
        String url = "https://practice.expandtesting.com/notes/app/register";
        driver.get(url);

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement confirmationField = driver.findElement(By.id("confirmPassword"));

        nameField.sendKeys("dotka");
        confirmationField.sendKeys("dotka123");
        emailField.sendKeys("dota123@gmail.com");
        passwordField.sendKeys("dotka123");

        WebElement registerButton = driver.findElement(By.cssSelector("[data-testid='register-submit']"));
        registerButton.click();


        logger.info("Submitted the account creation form");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

        if (successMessage.getText().contains("User account created successfully")) {
            logger.info("Account creation successful");
            System.out.println("Account creation successfully");
        } else {
            logger.error("Account creation failed");
            System.out.println("Account creation failed");
        }

        // Close the browser
        driver.quit();
    }
}
