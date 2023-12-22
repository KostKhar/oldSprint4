package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    //кнопка заказать верхняя
    public static By orderButton =By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //Сколько это стоит? И как оплатить?
    public static By howCost = By.xpath(".//*[@id=\"accordion__heading-0\"]");
    //Сутки 400 рублей. Оплата курьеру - наличными или картой.
    public static By itCost = By.xpath(".//*[@id=\"accordion__panel-0\"]/p");

     //Хочу сразу несколько самокатов! Так можно?
    public static By howManyToOne = By.xpath(".//*[@id=\"accordion__heading-1\"]");
    //Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    public static By oneOrderOneScooter = By.xpath(".//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    //Как рассчитывается время аренды?
    public static By orderTimeRange = By.xpath(".//*[@id=\"accordion__heading-2\"]");
   //Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    public static By orderTimeRangeAbout = By.xpath(".//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
      //Можно ли заказать самокат прямо на сегодня?
    public static By scooterWhenIGet = By.xpath(".//*[@id=\"accordion__heading-3\"]");
    //Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    public static By scooterIGet = By.xpath(".//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
        //Можно ли продлить заказ или вернуть самокат раньше?
    public static By scooterWhenITake = By.xpath(".//*[@id=\"accordion__heading-4\"]");
    //Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    public static By scooterITake = By.xpath(".//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
     //Вы привозите зарядку вместе с самокатом?
    public static By scooterHowCharge = By.xpath(".//*[@id=\"accordion__heading-5\"]");
    //Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    public static By scooterCharge = By.xpath(".//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    //Можно ли отменить заказ?
    public static By orderCancel = By.xpath(".//*[@id=\"accordion__heading-6\"]");
    //Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    public static By orderCancelConditions = By.xpath(".//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    //Я жизу за МКАДом, привезёте?
    public static By liveBehind = By.xpath(".//*[@id=\"accordion__heading-7\"]");
    //Да, обязательно. Всем самокатов! И Москве, и Московской области.
    public static By liveInOblast = By.xpath(".//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");




    public HomePage (WebDriver driver) {
        this.driver = driver;
    }
    public void clickorderButton() {
        driver.findElement(orderButton).click();
    }


    }


