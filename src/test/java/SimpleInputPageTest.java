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
        WebElement inputNumberField = wait.until(
                d -> d.findElement(By.id("input-number")));
        String inputFieldId = "123456";
        // 输入数字
        inputNumberField.sendKeys(inputFieldId);
        WebElement inputTextField = wait.until(
                d -> d.findElement(By.id("input-text")));
        String inputText = "测试输入框";
        // 输入文本
        inputTextField.sendKeys(inputText);
        assert inputNumberField.getAttribute("value").equals(inputFieldId) : "输入数字框内容不正确";
        assert inputTextField.getAttribute("value").equals(inputText) : "输入文本框内容不正确";

        driver.quit();
    }
}
