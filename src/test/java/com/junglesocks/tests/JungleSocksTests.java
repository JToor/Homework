package com.junglesocks.tests;

import com.junglesocks.config.DataProviderHelper;
import org.testng.annotations.Test;

import java.util.Map;

public class JungleSocksTests extends DataProviderHelper {

    @Test(dataProvider = "testData",priority = 1,description = "Verify all the content on homepage when user lands on jungle socks website")
    public void verifyHomepageContent(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.verifyHomepageContent(testDataMap);
    }

    @Test(dataProvider = "testData",priority = 2,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutPageContent(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"1");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"2");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"3");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"4");
        homepage.selectStateFromDropdown("California");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutPageContent(testDataMap);
    }

    @Test(dataProvider = "testData",priority = 3,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInCalifornia(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"4");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"5");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"2");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"1");
        homepage.selectStateFromDropdown("California");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(4,5,2,1,"California");
    }

    @Test(dataProvider = "testData",priority = 4,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInMinnesota(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"7");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"3");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"5");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"4");
        homepage.selectStateFromDropdown("Minnesota");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(7,3,5,4,"Minnesota");
    }

    @Test(dataProvider = "testData",priority = 5,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInNewYork(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"6");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"8");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"4");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"12");
        homepage.selectStateFromDropdown("New York");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(6,8,4,12,"New York");
    }

    @Test(dataProvider = "testData",priority = 6,description = "Verify all the content on checkout page when user try to purchase different types of socks")
    public void verifyCheckoutNumbersWhenUserBuysSocksInTexas(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"3");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"8");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"1");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"2");
        homepage.selectStateFromDropdown("Texas");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyCheckoutNumbers(3,8,1,2,"Texas");
    }

    @Test(dataProvider = "testData",priority = 7,description = "Verify product item is not displayed on checkout page if quantity is less than 1")
    public void verifyItemDoesntDisplayInCheckoutIfQuantityIsLessThanOne(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"0");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"1");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"abc");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"-1");
        homepage.selectStateFromDropdown("Texas");

        homepage.clickCheckoutBtn();

        checkoutPage.verifyItemHavingQuantityLessThanOneAreDisplayed();
        checkoutPage.verifyCheckoutNumbers(0,1,0,0,"Texas");
    }

    @Test(dataProvider = "testData",priority = 8,description = "Verify error page is displayed if state is not selected before checkout")
    public void verifyErrorPageIsDisplayedIfStateIsNotSelectedBeforeCheckout(Map<String, String> testDataMap) {
        utils.openUrl(baseUrl);
        homepage.enterQuantityForProduct(testDataMap.get("product1Name"),"2");
        homepage.enterQuantityForProduct(testDataMap.get("product2Name"),"1");
        homepage.enterQuantityForProduct(testDataMap.get("product3Name"),"3");
        homepage.enterQuantityForProduct(testDataMap.get("product4Name"),"4");
        homepage.clickCheckoutBtn();

        checkoutPage.verifyErrorPageIsDisplayed(testDataMap);
    }
}
