import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Yandex {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        final Wait<WebDriver> wait = new WebDriverWait(driver, 20, 1000);
        driver.get("https://translate.yandex.ru/?utm_source=wizard"); // Переходим по ссылке
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        // Находим элемент "Сайт", ждем, когда ссылка удет кликабельна
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/a[1]"));
        wait.until(ExpectedConditions.elementToBeClickable((element)));
        element.click();

        // Открывается страница перевода сайта. Там находим поле для ввода ссылки. И затем вставляем ссылку.
        //driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        WebElement url = driver.findElement(By.xpath("//*[@id=\"urlInput\"]"));
        wait.until(ExpectedConditions.visibilityOf((url)));
        url.sendKeys("https://gorest.co.in/");


        // Находи кнопку "перевести", ждем когда она будет кликабельна. И нажимаем кнопку.
        // Дальше откроется страница с переводом сайта
        WebElement button = driver.findElement(By.xpath("/html/body/div[1]/div[4]/span[2]"));
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable((button)));
        button.click();
    }
}

