package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    //кнопка заказать верхняя
    public static By orderButton =By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Сколько это стоит? И как оплатить?
    public static By howCost = By.xpath(".//*[@id=\"accordion__heading-0\"]");
     //Хочу сразу несколько самокатов! Так можно?
    public static By howManyToOne = By.xpath(".//*[@id=\"accordion__heading-1\"]");
    //Как рассчитывается время аренды?
    public static By orderTimeRange = By.xpath(".//*[@id=\"accordion__heading-2\"]");
      //Можно ли заказать самокат прямо на сегодня?
    public static By scooterWhenIGet = By.xpath(".//*[@id=\"accordion__heading-3\"]");
        //Можно ли продлить заказ или вернуть самокат раньше?
    public static By scooterWhenITake = By.xpath(".//*[@id=\"accordion__heading-4\"]");
     //Вы привозите зарядку вместе с самокатом?
    public static By scooterCharge = By.xpath(".//*[@id=\"accordion__heading-5\"]");
    //Можно ли отменить заказ?
    public static By orderCancel = By.xpath(".//*[@id=\"accordion__heading-6\"]");

    //Я жизу за МКАДом, привезёте?
    public static By liveBehind = By.xpath(".//*[@id=\"accordion__heading-7\"]");



    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    public void clickorderButton() {
        driver.findElement(orderButton).click();
    }


    }


