package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inputs {
    public WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
    }
    @Test
    public void inputNumTest() {
        String inputNumbers = "12345";
        driver.findElement(By.tagName("input")).sendKeys(inputNumbers);
        String actualResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(actualResult, inputNumbers);
    }
    @Test
    public void inputTextTest() {
        String inputText = "TextInput";
        driver.findElement(By.tagName("input")).sendKeys(inputText);
        String actualResult2 = driver.findElement(By.tagName("input")).getText();
        Assert.assertEquals(actualResult2, inputText);
    }
    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
