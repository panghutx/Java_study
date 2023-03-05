package auto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FirstAutoTest {
    @Test
    public void test() throws InterruptedException {
        ChromeDriver chromeDriver = new ChromeDriver();
        //隐式等待
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        chromeDriver.get("https://baidu.com");
        chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("枪神纪");
        //强制等待
        WebDriverWait webDriverWait = new WebDriverWait(chromeDriver,Duration.ofSeconds(3));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#su")));
        chromeDriver.findElement(By.cssSelector("#su")).click();
        System.out.println(chromeDriver.findElement(By.xpath("//*[@id=\"1\"]/div/div[1]/h3/a")).getAttribute("href"));
        chromeDriver.findElement(By.cssSelector("#kw")).clear();

        final String text = chromeDriver.findElement(By.xpath("//*[@id=\"1\"]/div/div[1]/h3/a")).getText();
        System.out.println(text);
        final String title = chromeDriver.getTitle();
        Assertions.assertEquals("枪神纪_百度搜索",title);
        System.out.println(title);
        final String currentUrl = chromeDriver.getCurrentUrl();
        System.out.println(currentUrl);


        chromeDriver.quit();
    }
}
