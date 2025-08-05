package org.flashlack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 主程序入口点。
 * @author flash
 */
public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com");
        System.out.println("当前页面标题: " + driver.getTitle());
        System.out.println("Selenium UI 自动化测试已成功运行。");
        // 关闭浏览器
        driver.quit();
    }
}