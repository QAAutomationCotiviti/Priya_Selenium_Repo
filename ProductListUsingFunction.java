import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductListUsingFunction {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


        try {


            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();


            List<WebElement> productElements = driver.findElements(By.className("inventory_item"));
            System.out.println("List of Products:");

            for (WebElement productElement : productElements) {
                WebElement productNameElement = productElement.findElement(By.className("inventory_item_name"));
                String productName = productNameElement.getText();
                System.out.println(productName);
            }


        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
//        }
        }
//
        selectsort(driver, "Price (low to high)");
        selectsort(driver, "Price (high to low)");
        selectsort(driver, "Name (A to Z)");
        selectsort(driver, "Name (Z to A)");

    }

    public  static void selectsort(WebDriver driver, String text)
    {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText(text);
    }

}
