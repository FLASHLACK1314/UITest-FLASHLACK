import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SimpleSeleniumTest {
    @Test
    public void testGoogleSearch() throws InterruptedException {
        // 使用 WebDriverManager 自动配置 ChromeDriver
        WebDriverManager.chromedriver().setup();

        // 创建 ChromeDriver 实例
        WebDriver driver = new ChromeDriver();

        // 1. 打开 Google 网页
        driver.get("https://www.baidu.com");

        // 2. 找到搜索框元素
        // 百度搜索框的 name 是 "wd"
        WebElement searchBox = driver.findElement(By.name("wd"));

        // 3. 在搜索框中输入内容
        searchBox.sendKeys("Selenium UI automation");

        // 4. 提交表单（这里相当于按 Enter 键）
        searchBox.submit();

        // 5. 打印页面标题
        System.out.println("搜索完成，页面标题是: " + driver.getTitle());
        // 6. 等待几秒钟，以便观察结果
        Thread.sleep(5000); // 在实际项目中不推荐使用 Thread.sleep，应使用显式等待

        // 7. 关闭浏览器
        driver.quit();
    }
}