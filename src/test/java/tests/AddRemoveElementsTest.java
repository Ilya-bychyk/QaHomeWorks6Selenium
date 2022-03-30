package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest {
    public WebDriver driver;
    int expectedNumber = 1;

    @BeforeClass
    public void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addRemoveElementsTest() {
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        driver.findElement(By.xpath("//*[text()='Delete']")).click();
        List<WebElement> actualSize = driver.findElements(By.xpath("//*[text()='Delete']"));
        int actualNumber = actualSize.size();
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    @AfterClass
    public void quitBrowser() {
      driver.quit();
    }
}


