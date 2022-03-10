package com.junglesocks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class Homepage extends Page {

    private static final By title = By.cssSelector("h1");
    private static final By subtitle = By.cssSelector("p");
    private static final By product_table_column1_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(1)");
    private static final By product_table_column2_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(2)");
    private static final By product_table_column3_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(3)");
    private static final By product_table_column4_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(4)");
    private static final By product1_name = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(2) > td:nth-child(1)");
    private static final By product2_name = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(3) > td:nth-child(1)");
    private static final By product3_name = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(1)");
    private static final By product4_name = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(5) > td:nth-child(1)");
    private static final By product1_price = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(2) > td:nth-child(2)");
    private static final By product2_price = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(3) > td:nth-child(2)");
    private static final By product3_price = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(2)");
    private static final By product4_price = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(5) > td:nth-child(2)");
    private static final By product1_in_stock_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(2) > td:nth-child(3)");
    private static final By product2_in_stock_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(3) > td:nth-child(3)");
    private static final By product3_in_stock_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(3)");
    private static final By product4_in_stock_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(5) > td:nth-child(3)");
    private static final By product1_quantity_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(2) > td:nth-child(4) input");
    private static final By product2_quantity_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(3) > td:nth-child(4) input");
    private static final By product3_quantity_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(4) > td:nth-child(4) input");
    private static final By product4_quantity_value = By.cssSelector("form > table:nth-child(2) > tbody > tr:nth-child(5) > td:nth-child(4) input");
    private static final By ship_state_label = By.cssSelector("form > table:nth-child(4) > tbody > tr > td:nth-child(1)");
    private static final By ship_state_dropdown = By.name("state");
    private static final By checkout_btn = By.xpath("//input[@name='commit']");


    public Homepage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckoutBtn() {
        utils.click(checkout_btn);
    }

    public void selectStateFromDropdown(String name) {
        utils.selectByText(ship_state_dropdown, name);
    }

    public void enterQuantityForProduct(String productName,String quantity) {
        switch (productName.toLowerCase()) {
            case "zebra":
                utils.enterText(product1_quantity_value,quantity);
                break;
            case "lion":
                utils.enterText(product2_quantity_value,quantity);
                break;
            case "elephant":
                utils.enterText(product3_quantity_value,quantity);
                break;
            case "giraffe":
                utils.enterText(product4_quantity_value,quantity);
                break;
            default:
                log.info("Product not present");
                break;

        }
    }

    public void verifyHomepageContent(Map<String, String> testDataMap) {
        SoftAssert sa = new SoftAssert();
        try {
            sa.assertEquals(utils.getText(title),"Welcome To Jungle Socks!","Header wrong on homepage");
            sa.assertEquals(utils.getText(subtitle),"Please enter the quantiy of each kind of sock and then click the checkout button","Header wrong on homepage");
            sa.assertEquals(utils.getText(product_table_column1_header),"Name","product table column 1 header wrong on homepage");
            sa.assertEquals(utils.getText(product_table_column2_header),"Price","product table column 2 header wrong on homepage");
            sa.assertEquals(utils.getText(product_table_column3_header),"In Stock","product table column 3 header wrong on homepage");
            sa.assertEquals(utils.getText(product_table_column4_header),"Quantity","product table column 4 header wrong on homepage");
            sa.assertEquals(utils.getText(product1_name),testDataMap.get("product1Name"),"product 1 name wrong on homepage");
            sa.assertEquals(utils.getText(product2_name),testDataMap.get("product2Name"),"product 2 name wrong on homepage");
            sa.assertEquals(utils.getText(product3_name),testDataMap.get("product3Name"),"product 3 name wrong on homepage");
            sa.assertEquals(utils.getText(product4_name),testDataMap.get("product4Name"),"product 4 name wrong on homepage");
            sa.assertEquals(utils.getText(product1_price),testDataMap.get("product1Price"),"product 1 price wrong on homepage");
            sa.assertEquals(utils.getText(product2_price),testDataMap.get("product2Price"),"product 2 price wrong on homepage");
            sa.assertEquals(utils.getText(product3_price),testDataMap.get("product3Price"),"product 3 price wrong on homepage");
            sa.assertEquals(utils.getText(product4_price),testDataMap.get("product4Price"),"product 4 price wrong on homepage");
            sa.assertEquals(utils.getText(product1_in_stock_value),testDataMap.get("product1InStock"),"product 1 stock value wrong on homepage");
            sa.assertEquals(utils.getText(product2_in_stock_value),testDataMap.get("product2InStock"),"product 2 stock value wrong on homepage");
            sa.assertEquals(utils.getText(product3_in_stock_value),testDataMap.get("product3InStock"),"product 3 stock value wrong on homepage");
            sa.assertEquals(utils.getText(product4_in_stock_value),testDataMap.get("product4InStock"),"product 4 stock value wrong on homepage");
            sa.assertEquals(utils.getText(product1_quantity_value),"","product 1 quantity value wrong on homepage");
            sa.assertEquals(utils.getText(product2_quantity_value),"","product 2 quantity value wrong on homepage");
            sa.assertEquals(utils.getText(product3_quantity_value),"","product 3 quantity value wrong on homepage");
            sa.assertEquals(utils.getText(product4_quantity_value),"","product 4 quantity value wrong on homepage");
            sa.assertEquals(utils.getText(ship_state_label),"Ship to State:","ship to state label text wrong on homepage");
            sa.assertEquals(utils.getFirstSelectedOption(ship_state_dropdown),"","ship dropdown value wrong on homepage");
            sa.assertEquals(utils.getAttribute(checkout_btn,"value"),"checkout","checkout btn text wrong on homepage");
        } catch (Exception e) {
            sa.fail("Issue with product item verification: " + e.getMessage());
        }
        sa.assertAll();
    }
}
