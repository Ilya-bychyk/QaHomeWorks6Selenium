package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Dropdown {
    public WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    // Взять все элементы дроп-дауна и проверить их наличие.
    // Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
    @Test
    public void dropdownOption1Test() {
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 1");
        String option1 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option1, "Option 1");
    }

    @Test
    public void dropdownOption2Test() {
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 2");
        String option2 = select.getFirstSelectedOption().getText();
        Assert.assertEquals(option2, "Option 2");
    }
    @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}