import PageObject.HomePage;
import PageObject.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObject.OrderPage.*;
import static org.junit.Assert.assertEquals;


public class OrderPageTest {

    private WebDriver driver;


    public void startChrome(WebDriver driver){
        WebDriverManager.chromedriver().setup();
      this.driver = new ChromeDriver();
    }

    public void startFox(WebDriver driver){
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:\\cygwin64\\home\\admin\\untitled\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        this.driver = new FirefoxDriver(capabilities);
            }




    @Test
    public void checkOrderByUpButton () {
        startFox(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
       new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderButton));
       OrderPage hP= new OrderPage(driver);
        objHomePage.clickorderButton();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(nameField));
       hP.makeOrderOnePageSocolniki("Иван", "Иванов", "Москва, Азовская, д. 23, кв 40",  "+79887552545");
       hP.makeOrderTwoPageOneDay("24.12.2023", "Домофон 25*25");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderStatusButton));
        boolean actual = driver.findElement(orderStatusButton).getText().equals("Посмотреть статус");
        assertEquals(true,  actual);
        driver.findElement(orderStatusButton).click();
       driver.quit();
    }
    @Test
    public void checkOrderByMiddleButton () {
        startChrome(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(orderMiddleButton));
        driver.findElement(orderMiddleButton).click();
        OrderPage hP= new OrderPage(driver);
        hP.clickorderButton();
        hP.makeOrderOnePageTverskay("Илья", "Сидоров", "г. Домодедово, Азовская, д. 23, кв 40",  "+79182566989");
        hP.makeOrderTwoPageSevenDay("24.12.2023","");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderStatusButton));
        boolean actual = driver.findElement(orderStatusButton).getText().equals("Посмотреть статус");
        Assert.assertTrue(actual);
        driver.findElement(orderStatusButton).click();
        driver.quit();
    }


}
