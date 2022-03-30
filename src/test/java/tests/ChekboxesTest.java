package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChekboxesTest {
    public WebDriver driver;
    boolean checkboxIsSelected = true;
    boolean checkboxIsNotSelected = false;
    private  static  final String BASE_URL = "http://the-internet.herokuapp.com/checkboxes";

    @BeforeClass
    public void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

    }

    @Test (priority = 0)
    public void checkbox1Test() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).isSelected();
        Assert.assertEquals(checkboxIsNotSelected, false);
    }

    @Test (priority = 1)
    public void checkbox2Test() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).click();
        driver.findElement(By.cssSelector("input[type='checkbox']:nth-child(1)")).isSelected();
        Assert.assertEquals(checkboxIsSelected, true);
    }

    @Test (priority = 2)
        public void checkbox3Test() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("input[type='checkbox']:last-child")).isSelected();
        Assert.assertEquals(checkboxIsSelected, true);
    }
    @Test (priority = 3)
    public void checkbox4Test() {
        driver.get(BASE_URL);
        driver.findElement(By.cssSelector("input[type='checkbox']:last-child")).click();
        driver.findElement(By.cssSelector("input[type='checkbox']:last-child")).isSelected();
        Assert.assertEquals(checkboxIsNotSelected, false);
    }

    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}