package kz.TELE2;

import kz.TELE2.pages.AnyPage;
import kz.TELE2.pages.LoginPage;
import kz.TELE2.pages.PhoneBoxPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static AnyPage anyPage;
    public static LoginPage loginPage;
    public static PhoneBoxPage phoneBoxPage;

    //метод setup помеченный аннотацией Junit @BeforeClass.
    // Он будет выполняться один раз перед запуском кода класса:
    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/i.levchenko/Desktop/chromedriver");
        driver = new ChromeDriver();
        anyPage = new AnyPage(driver);
        loginPage = new LoginPage(driver);
        phoneBoxPage = new PhoneBoxPage(driver);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
        driver.get("https://tele2.kz/");
    }

    @AfterClass
    public static void testDown() {
        driver.quit();
    }
}