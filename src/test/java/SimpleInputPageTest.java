import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleInputPageTest {
    @Test
    public void testInputPage() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/inputs");
        // 等待页面加载完成
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait.until(
                d -> d.findElement(By.id("input-number")));
        String inputFieldId = "123456";
        // 输入数字
        inputField.sendKeys(inputFieldId);
        assert inputField.getAttribute("value").equals(inputFieldId) : "输入框内容不正确";

        driver.quit();
    }
}
