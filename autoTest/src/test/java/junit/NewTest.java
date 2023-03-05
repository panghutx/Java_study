package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

    @Test
    void newTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://food.youngsay.cn");

        final WebElement element = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div.col-md-4 > div > input"));
        Assertions.assertNotNull(element);
    }
}
