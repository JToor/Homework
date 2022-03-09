package com.junglesocks.tests;

import com.junglesocks.helpers.Utils;
import com.junglesocks.pages.CheckoutPage;
import com.junglesocks.pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseTest {

    protected static String baseUrl = "https://jungle-socks.herokuapp.com/";
    public static Utils utils = new Utils();
    protected WebDriver driver;
    String chromeDriverPath = "chromeDriver/chromedriver";
    public Homepage homepage;
    public CheckoutPage checkoutPage;
    public final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    @BeforeClass
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        utils.setDriver(driver);
        homepage = new Homepage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}
