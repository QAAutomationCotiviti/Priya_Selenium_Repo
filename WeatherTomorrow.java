import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeatherTomorrow {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        searchWeather(driver, "How is weather Today?");


        translateToEnglish(driver);

        printTemperature(driver);

        clearSearchField(driver);

        searchWeather(driver, "How is weather Tomorrow?");

        printTemperature(driver);

        driver.close();

    }

    private static void translateToEnglish(WebDriver driver) {
        WebElement translate = driver.findElement(By.xpath("//a[text()='Change to English']"));
        translate.click();
    }

    private static void printTemperature(WebDriver driver) {
        WebElement temp = driver.findElement(By.id("wob_tm"));
        WebElement celcius = driver.findElement(By.xpath("//span[@aria-label='°Celsius']"));
        System.out.println("The Temperature is: " + temp.getText() + celcius.getText());
    }

    private static void searchWeather(WebDriver driver, String query) {
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    private static void clearSearchField(WebDriver driver) {
        driver.findElement(By.name("q")).clear();
    }
}
