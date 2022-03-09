package com.junglesocks.tests;

import org.testng.annotations.Test;
import java.util.logging.Logger;

public class JungleSocksTests extends BaseTest {

    @Test(priority = 1,description = "Verify all the content on homepage when user lands on jungle socks website")
    public void verifyHomepageContent() {
        utils.openUrl(baseUrl);
        homepage.verifyHomepageContent();
    }

    @Test(priority = 2,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutPageContent() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","1");
        homepage.enterQuantityForProduct("lion","2");
        homepage.enterQuantityForProduct("elephant","3");
        homepage.enterQuantityForProduct("giraffe","4");
        homepage.selectStateFromDropdown("California");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutPageContent();
    }

    @Test(priority = 3,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInCalifornia() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","4");
        homepage.enterQuantityForProduct("lion","5");
        homepage.enterQuantityForProduct("elephant","2");
        homepage.enterQuantityForProduct("giraffe","1");
        homepage.selectStateFromDropdown("California");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(4,5,2,1,"California");
    }

    @Test(priority = 4,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInMinnesota() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","7");
        homepage.enterQuantityForProduct("lion","3");
        homepage.enterQuantityForProduct("elephant","5");
        homepage.enterQuantityForProduct("giraffe","4");
        homepage.selectStateFromDropdown("Minnesota");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(7,3,5,4,"Minnesota");
    }

    @Test(priority = 5,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInNewYork() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","6");
        homepage.enterQuantityForProduct("lion","8");
        homepage.enterQuantityForProduct("elephant","4");
        homepage.enterQuantityForProduct("giraffe","12");
        homepage.selectStateFromDropdown("New York");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(6,8,4,12,"New York");
    }

    @Test(priority = 6,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInTexas() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","3");
        homepage.enterQuantityForProduct("lion","8");
        homepage.enterQuantityForProduct("elephant","1");
        homepage.enterQuantityForProduct("giraffe","2");
        homepage.selectStateFromDropdown("Texas");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(3,8,1,2,"Texas");
    }

    @Test(priority = 7,description = "Verify item is not displayed on checkout page if quantity is less than 1")
    public void verifyItemDoesntDisplayInCheckoutIfQuantityIsLessThanOne() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","0");
        homepage.enterQuantityForProduct("lion","1");
        homepage.enterQuantityForProduct("elephant","abc");
        homepage.enterQuantityForProduct("giraffe","-1");
        homepage.selectStateFromDropdown("Texas");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyItemHavingQuantityLessThanOneAreDisplayed();
        checkoutPage.verifyCheckoutNumbers(0,1,0,0,"Texas");
    }

    @Test(priority = 8,description = "Verify error page is displayed if state is not selected before checkout")
    public void verifyErrorPageIsDisplayedIfStateIsNotSelectedBeforeCheckout() {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct("zebra","2");
        homepage.enterQuantityForProduct("lion","1");
        homepage.enterQuantityForProduct("elephant","3");
        homepage.enterQuantityForProduct("giraffe","4");
        homepage.clickCheckoutBtn();

        checkoutPage.verifyErrorPageIsDisplayed();
    }
}
