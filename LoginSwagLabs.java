import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSwagLabs {
    static WebDriver driver;

    static WebElement usernameInputField;

    static WebElement passwordInputField;

    static WebElement loginButton;

    static WebElement errorContainer;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
//
//        inputCredentials("locked_out_user",  "secret_sauce",  true);
//        inputCredentials("wrong_username",  "secret_sauce",  true);
        inputCredentials("standard_username",  "secret_sauce",  true);

        driver.close();

    }

    public static void inputCredentials(String username, String password, Boolean errorExpected) {

        usernameInputField = driver.findElement(By.id("user-name"));
        passwordInputField = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.id("login-button"));
        errorContainer = driver.findElement(By.className("error-message-container"));

        clearInputFields();

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
    }

    public static void clearInputFields() {
        usernameInputField.clear();
        passwordInputField.clear();
    }

}
