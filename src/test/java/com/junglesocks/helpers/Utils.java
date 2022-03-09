package com.junglesocks.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.logging.Logger;

public class Utils {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void selectByText(By by, String text) {
        Select select = new Select(findElement(by));
        select.selectByVisibleText(text);
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebElement findElement(By by) {
        return driver.get().findElement(by);
    }

    public void enterText(By loc, String text) {
        try {
            waitForElement(loc);
            findElement(loc).clear();
            findElement(loc).sendKeys(text);
        } catch (Exception e) {
            log.info("unable to enter text:" + e.getMessage());
        }
    }

    public void waitForElement(By loc) throws Exception {
        if (!isElementPresent(loc, 60))
            throw new NoSuchFieldException("Locator " + loc + " not found.");
    }

    public boolean isElementPresent(By loc, int wait) {
        try {
            for (int i = 0; i < wait; i++) {
                if (isElementDisplayed(loc)) {
                    return true;
                }
                sleep(1);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public void sleep(int sec) throws Exception {
        Thread.sleep(sec * 1000L);
    }

    public boolean isElementDisplayed(By by) {
        try {
            return driver.get().findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            log.info("The element " + by + " is not displayed.");
            return false;
        }
    }

    public boolean isElementPresent(By loc) {
        try {
            if (findElement(loc).isDisplayed())
                return true;
            else
                return false;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitForVisibility(By by, int waitTime) {
        Wait<WebDriver> wait = new WebDriverWait(driver.get(), waitTime);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void openUrl(String url) {
        driver.get().get(url);
    }

    public WebElement waitForVisibility(By by) {
        return waitForVisibility(by,60);
    }

    public void click(By by) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver.get();
        waitForVisibility(by, 20);
        WebElement elementToClick = findElement(by);
        waitUntilClickable(by);
        try {
            scrollToElement(elementToClick);
            elementToClick.click();
        } catch (Exception ex1) {
            try {
                jsexecutor.executeScript("arguments[0].scrollIntoView(false);", elementToClick);
                elementToClick.click();

            } catch (Exception ex2) {
                jsexecutor.executeScript("arguments[0].scrollIntoView(true);", elementToClick);
                elementToClick.click();

            }

        }
    }

    public WebElement waitUntilClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver.get(), 60);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver.get();
        jsexecutor.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public String getText(By by) {
        waitForVisibility(by);
        return (findElement(by)).getText();
    }

    public String getFirstSelectedOption(By by){
        Select select = new Select(findElement(by));
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }

    public String getAttribute(By loc, String attr) {
        return driver.get().findElement(loc).getAttribute(attr);
    }
}
