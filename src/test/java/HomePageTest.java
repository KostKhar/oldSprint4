import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObject.HomePage.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class HomePageTest {
    private String message;
    private By elementText;
    private By button;
    private  boolean isVisible;

    public HomePageTest(By button, By elementText, String message, boolean isVisible) {
        this.button=button;
        this.elementText=elementText;
        this.message=message;
        this.isVisible=isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getMessage () {
        return new Object[][]{
                {howCost, itCost,"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {howManyToOne, oneOrderOneScooter, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {orderTimeRange, orderTimeRangeAbout, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {scooterWhenIGet, scooterIGet, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {scooterWhenITake, scooterITake, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {scooterHowCharge, scooterCharge , "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {orderCancel,orderCancelConditions, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {liveBehind,liveInOblast, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
                {orderCancel,scooterIGet, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", false}
        };
    }

    @Test
    public void checkListButton() {
        WebDriverManager.firefoxdriver().setup();
        System.setProperty("webdriver.gecko.driver", "C:\\cygwin64\\home\\admin\\untitled\\geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(orderButton));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(button));
        driver.findElement(button).click();
        String actual=driver.findElement(elementText).getText();
        assertEquals(isVisible, actual.equals(message));
        driver.quit();
    }
   }