import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static PageObject.HomePage.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class HomePageTest {
    private final By message;
    private final By button;
    private  boolean isVisible;

    public HomePageTest(By button,By message, boolean isVisible) {
        this.button=button;
        this.message=message;
        this.isVisible=isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getMessage () {
        return new Object[][]{
                {howCost, itCost, true},
                {howManyToOne, oneOrderOneScooter, true},
                {orderTimeRange, orderTimeRangeDescript, true},
                {scooterWhenIGet, scooterWhenIGetSince, true},
                {scooterWhenITake, scooterWhenITakeAbout, true},
                {scooterCharge, scooterChargeTake, true},
                {orderCancel, conditionsOrderCancel, true},
                {liveBehind, liveBehindGet, true},
                {orderCancel,scooterChargeTake, false}
        };
    }

    @Test
    public void checkListButton() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(button));
        driver.findElement(button).click();
        List<WebElement> elements = driver.findElements(message);

            assertEquals(isVisible, elements.size()!=0);
        driver.quit();
   }

}

