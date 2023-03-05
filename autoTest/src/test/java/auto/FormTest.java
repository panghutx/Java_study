package auto;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class FormTest {

    @Test
    void formTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://baidu.com");
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        final String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        for (String s : driver.getWindowHandles()) {
            if (!s.equals(windowHandle)) {
                System.out.println(s);
                System.out.println(driver.switchTo().window(s).getTitle());
            }
        }
        driver.quit();
    }

    @Test
    void navigateTest(){
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://baidu.com");
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        //打开新的标签页，前进和后退没有效果
        driver.navigate().forward();
        driver.navigate().back();
    }

    @Test
    void alertTest(){
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("file:///C:/Users/panghutx/Desktop/selenium2html/alert.html#");
//        driver.findElement(By.cssSelector("#tooltip")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();

        ChromeDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/panghutx/Desktop/selenium2html/send.html");
        driver.findElement(By.cssSelector("body > input[type=button]")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("你好呀");
        alert.dismiss();
    }

    @Test
    void MouseAndKeyword() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/panghutx/Desktop/selenium2html/level_locate.html");
        driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > a")).click();
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(By.cssSelector("#dropdown1 > li:nth-child(2) > a"));
        actions.clickAndHold(ele).perform();
        Thread.sleep(3000);
    }

    @Test
    void chooseBox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/panghutx/Desktop/selenium2html/drop_down.html");
        final WebElement element = driver.findElement(By.cssSelector("#ShippingMethod"));
        element.click();
        Select select = new Select(element);
        //select.selectByIndex(3);
        //select.selectByValue("9.03");
        select.selectByVisibleText("UPS 3 Day Select ==> $10.69");
    }

    @Test
    void fileUpload(){
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/panghutx/Desktop/selenium2html/upload.html");
        driver.findElement(By.cssSelector("body > div > div > input[type=file]")).sendKeys("C:\\Users\\panghutx\\Desktop\\未命名码.png");
    }

    @Test
    void screen() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://baidu.com");
        driver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#su")).click();
        //屏幕截图
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File filename = new File("./my.png");
        FileUtils.copyFile(src,filename);
    }
}
