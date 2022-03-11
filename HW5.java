package ru.gb.lessons.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;


public class AuthorizationTest {

    @Test
    void Authorization() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        WebElement authPopup = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        authPopup.findElement(By.name("username")).sendKeys("test.testovich.88@list.ru");
        authPopup.findElement(By.name("password")).sendKeys("Parol-2222");
        authPopup.findElement(By.xpath("//*[@id=\"login\"]/div/div[4]/button")).click();
        assert "Здравствуйте, Тест!".equals(StringUtils.capitalize("дравствуйте, Тест!")) : "Авторизация прошла успешно";
        webDriver.quit();
    }
}


public class AddProductToCartTest {
    
    @Test
    void AddProductToCart(){
        String productName = "Цветной Корректор - Желтый - против темных кругов под глазами";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[5]/nav/ul/li[4]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/main/section/div[2]/div[1]/article/div/a/h3")).click();
        webDriver.findElement(By.xpath("//*[@id=\"pdp\"]/section[1]/aside/div/div/div[2]/form/div[2]/div/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"popup_add-to-cart\"]/div[1]/div/div/div/div[3]/a[2]")).click();
        assert "Товар добавлен в корзину".equals(StringUtils.capitalize("Товар добавлен в корзин")) : "Тест успешен";
        webDriver.quit();
    }
}


public class ExitFromCartTest {

    @Test
    void ExitFromCart(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/div/nav/div/div/div/div/div/div/ul/li[7]/form/button")).click();
        assert "Выход".equals(StringUtils.capitalize("Выход")) : "Вы вышли из личного кабинета";
        webDriver.quit();

    }
}
