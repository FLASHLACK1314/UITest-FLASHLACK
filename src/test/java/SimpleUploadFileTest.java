import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SimpleUploadFileTest {
    @Test
    public void testUploadFile() {
        WebDriverManager.chromedriver().setup();
        // 创建 ChromeDriver 实例
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/upload");

        // 显式等待文件输入框出现
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fileInput = wait.until(
                d -> d.findElement(By.id("fileInput")));
        String filePath = "C:\\Users\\flash\\Desktop\\测算资源\\test-尺寸不符合规格.png";
        fileInput.sendKeys(filePath);

        // 显式等待上传按钮可点击
        WebElement uploadButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("fileSubmit")));
        uploadButton.click();

        // 点击上传后，断言页面出现“File Uploaded!”
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'File Uploaded!')]")));
        assert result.isDisplayed();
        System.out.println("文件上传成功，页面显示: " + result.getText());

        driver.quit();
    }
}
