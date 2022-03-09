package com.junglesocks.pages;

import com.junglesocks.tests.BaseTest;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page extends BaseTest {

  protected WebDriver driver;
  protected final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  protected int zebraProductPrice = 13;
  protected int lionProductPrice = 20;
  protected int elephantProductPrice = 35;
  protected int giraffeProductPrice = 17;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

}
