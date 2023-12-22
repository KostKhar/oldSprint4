package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    public static By orderButton =By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    private WebDriver driver;

    //кнопка Заказать в середине
    public static By orderMiddleButton =By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");


    // Имя
    public static By nameField = By.xpath(".//input[@placeholder='* Имя']" );


    //Фамилия
    private By surnameField =  By.xpath(".//input[@placeholder='* Фамилия']");;


    //Адрес: куда привезти заказ
    private By addressField =  By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");


    //поле Станция метро
    private By station =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[1]/input");


    //Тверская
    private By tverskayStation =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[31]");


    //Сокольники
    private By socolnikiStation =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[4]");


    //Телефон: на него позвонит курьер
    private By phoneNumberField =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");


    //Далее
    public static By next =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button");



    //Когда привезти самокат
    private By dateField =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //24.12.2023
    private By twentyFourDecember = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--024 react-datepicker__day--selected react-datepicker__day--weekend']");


    //Срок аренды
    private By termField =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div[1]");


    //сутки
    private By oneDay =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[1]");


    //шестеро суток
    private By sevenDay =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[7]");


    //Цвет самоката - черный
    private By black =  By.xpath(".//*[@id=\"black\"]");


    //серая безысходность
    private By grey =  By.xpath(".//*[@id=\"grey\"]");


    //Комментарий для курьера
    private By commentField =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");


    //Заказать
    private By orderButtonInForm =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");


    //Хотите оформить заказ - Да
    private By orderButtonTakeYes =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");

//Посмотреть статус заказа
    public static By orderStatusButton =  By.xpath(".//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickorderButton() {
        driver.findElement(orderButton).click();
    }


    public void makeOrderOnePageSocolniki (String name, String surname, String address,  String number){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).click();
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).click();
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(station).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(socolnikiStation));
       driver.findElement(socolnikiStation).click();
        driver.findElement(phoneNumberField).click();
        driver.findElement(phoneNumberField).sendKeys(number);
        driver.findElement(next).click();
    }
    public void makeOrderOnePageTverskay (String name, String surname, String address,  String number){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(station).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(tverskayStation));
        driver.findElement(tverskayStation).click();
        driver.findElement(phoneNumberField).sendKeys(number);
        driver.findElement(next).click();
    }
    public void makeOrderTwoPageOneDay (String date, String comment){
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(twentyFourDecember).click();
        driver.findElement(termField).click();
        driver.findElement(oneDay).click();
        driver.findElement(black).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButtonInForm).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(orderButtonTakeYes));
        driver.findElement(orderButtonTakeYes).click();

    }

    public void makeOrderTwoPageSevenDay (String date, String comment){
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).click();
        driver.findElement(twentyFourDecember).click();
        driver.findElement(termField).click();
        driver.findElement(sevenDay).click();
        driver.findElement(grey).click();
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButtonInForm).click();
        new WebDriverWait(driver,4).until(ExpectedConditions.elementToBeClickable(orderButtonTakeYes));
        driver.findElement(orderButtonTakeYes).click();

    }

}
