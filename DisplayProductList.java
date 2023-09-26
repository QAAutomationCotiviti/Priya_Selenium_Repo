import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DisplayProductList {
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

//


            WebElement dropdown = driver.findElement((By.xpath("//*[@data-test='product_sort_container']")));
            Select select = new Select(driver.findElement(By.className("product_sort_container")));
            select.selectByVisibleText("Price (low to high)");
            select = new Select(driver.findElement(By.className("product_sort_container")));
            select.selectByVisibleText("Price (high to low)");


        } catch (Exception e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }
        finally {
            driver.quit();
//        }
        }
//
//
    }
}
