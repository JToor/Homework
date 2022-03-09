package com.junglesocks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;

public class CheckoutPage extends Page {

    private static final By title = By.cssSelector("h1");
    private static final By subtitle = By.cssSelector("p");
    private static final By product_table_column1_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(1)");
    private static final By product_table_column2_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(2)");
    private static final By product_table_column3_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(3)");
    private static final By product_table_column4_header = By.cssSelector("tbody > tr:nth-child(1) > th:nth-child(4)");
    private static final By product1_name = By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(1)");
    private static final By product2_name = By.cssSelector("tbody > tr:nth-child(3) > td:nth-child(1)");
    private static final By product3_name = By.cssSelector("tbody > tr:nth-child(4) > td:nth-child(1)");
    private static final By product4_name = By.cssSelector("tbody > tr:nth-child(5) > td:nth-child(1)");
    private static final By product1_price = By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(2)");
    private static final By product2_price = By.cssSelector("tbody > tr:nth-child(3) > td:nth-child(2)");
    private static final By product3_price = By.cssSelector("tbody > tr:nth-child(4) > td:nth-child(2)");
    private static final By product4_price = By.cssSelector("tbody > tr:nth-child(5) > td:nth-child(2)");
    private static final By product1_quantity_value = By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(3)");
    private static final By product2_quantity_value = By.cssSelector("tbody > tr:nth-child(3) > td:nth-child(3)");
    private static final By product3_quantity_value = By.cssSelector("tbody > tr:nth-child(4) > td:nth-child(3)");
    private static final By product4_quantity_value = By.cssSelector("tbody > tr:nth-child(5) > td:nth-child(3)");
    private static final By subtotal_label = By.cssSelector("table:nth-child(3) > tbody > tr:nth-child(7) > td:nth-child(1)");
    private static final By tax_label = By.cssSelector("table:nth-child(3) > tbody > tr:nth-child(8) > td:nth-child(1)");
    private static final By total_label = By.cssSelector("table:nth-child(3) > tbody > tr:nth-child(9) > td:nth-child(1)");
    private static final By subtotal_value = By.id("subtotal");
    private static final By tax_value = By.id("taxes");
    private static final By total_value = By.id("total");
    private static final By lion_line_item = By.cssSelector(".line_item.lion");
    private static final By zebra_line_item = By.cssSelector(".line_item.zebra");
    private static final By elephant_line_item = By.cssSelector(".line_item.elephant");
    private static final By giraffe_line_item = By.cssSelector(".line_item.giraffe");


    private static final DecimalFormat df = new DecimalFormat("0.00");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void verifyCheckoutPageContent() {
        SoftAssert sa = new SoftAssert();
        try {
            sa.assertEquals(utils.getText(title),"Please Confirm Your Order","Header wrong on checkout page");
            sa.assertEquals(utils.getText(product_table_column1_header),"Name","product table column 1 header wrong on checkout page");
            sa.assertEquals(utils.getText(product_table_column2_header),"Price","product table column 2 header wrong on checkout page");
            sa.assertEquals(utils.getText(product_table_column3_header),"Quantity","product table column 3 header wrong on checkout page");
            sa.assertEquals(utils.getText(product1_name),"zebra","product 1 name wrong on checkout page");
            sa.assertEquals(utils.getText(product2_name),"lion","product 2 name wrong on checkout page");
            sa.assertEquals(utils.getText(product3_name),"elephant","product 3 name wrong on checkout page");
            sa.assertEquals(utils.getText(product4_name),"giraffe","product 4 name wrong on checkout page");
            sa.assertEquals(utils.getText(product1_price),"13","product 1 price wrong on checkout page");
            sa.assertEquals(utils.getText(product2_price),"20","product 2 price wrong on checkout page");
            sa.assertEquals(utils.getText(product3_price),"35","product 3 price wrong on checkout page");
            sa.assertEquals(utils.getText(product4_price),"17","product 4 price wrong on checkout page");
            sa.assertEquals(utils.getText(product1_quantity_value),"1","product 1 quantity value wrong on checkout page");
            sa.assertEquals(utils.getText(product2_quantity_value),"2","product 2 quantity value wrong on checkout page");
            sa.assertEquals(utils.getText(product3_quantity_value),"3","product 3 quantity value wrong on checkout page");
            sa.assertEquals(utils.getText(product4_quantity_value),"4","product 4 quantity value wrong on checkout page");
            sa.assertEquals(utils.getText(subtotal_label),"Subtotal:","value wrong on checkout page");
            sa.assertEquals(utils.getText(tax_label),"Taxes:","value wrong on checkout page");
            sa.assertEquals(utils.getText(total_label),"Total:","value wrong on checkout page");
        } catch (Exception e) {
            sa.fail("Unable to verify checkout page content: " + e.getMessage());
        }
        sa.assertAll();
    }

    public void verifyCheckoutNumbers(int product1Quantity,int product2Quantity,int product3Quantity,int product4Quantity,String shipToState) {
        SoftAssert sa = new SoftAssert();
        try {
            double subtotal = (zebraProductPrice     * product1Quantity) +
                              (lionProductPrice      * product2Quantity) +
                              (elephantProductPrice  * product3Quantity) +
                              (giraffeProductPrice   * product4Quantity);
            double tax;

            switch (shipToState.toLowerCase()) {
                case "california":
                   tax = subtotal * 0.08;
                   break;
                case "new york":
                    tax = subtotal * 0.06;
                    break;
                case "minnesota":
                    tax = subtotal * 0.00;
                    break;
                default:
                    tax = subtotal * 0.05;
                    break;
            }
            double total = subtotal + tax;

            sa.assertEquals(utils.getText(subtotal_value),"$" + df.format(subtotal),"Subtotal value wrong");
            sa.assertEquals(utils.getText(tax_value),"$" + df.format(tax),"Taxes value wrong");
            sa.assertEquals(utils.getText(total_value),"$" + df.format(total),"Taxes value wrong");
        } catch (Exception e) {
            sa.fail("Issue will verifying checkout numbers: " + e.getMessage());
        }
        sa.assertAll();
    }

    public void verifyItemHavingQuantityLessThanOneAreDisplayed() {
        SoftAssert sa = new SoftAssert();
        try {
            sa.assertEquals(utils.getText(title),"Please Confirm Your Order","Header wrong on checkout page");
            sa.assertEquals(utils.getText(product_table_column1_header),"Name","product table column 1 header wrong on checkout page");
            sa.assertEquals(utils.getText(product_table_column2_header),"Price","product table column 2 header wrong on checkout page");
            sa.assertEquals(utils.getText(product_table_column3_header),"Quantity","product table column 3 header wrong on checkout page");
            sa.assertTrue(utils.isElementPresent(lion_line_item),"lion item not present on checkout page");
            sa.assertFalse(utils.isElementPresent(zebra_line_item),"zebra item present on checkout page");
            sa.assertFalse(utils.isElementPresent(elephant_line_item),"elephant item present on checkout page");
            sa.assertFalse(utils.isElementPresent(giraffe_line_item),"giraffe item present on checkout page");
        } catch (Exception e) {
            sa.fail("Unable to verify checkout page content: " + e.getMessage());
        }
        sa.assertAll();
    }

    public void verifyErrorPageIsDisplayed() {
        SoftAssert sa = new SoftAssert();
        try {
            sa.assertEquals(utils.getText(title),"We're sorry, but something went wrong.","Error title wrong");
            sa.assertEquals(utils.getText(subtitle),"We've been notified about this issue and we'll take a look at it shortly.","Error subtitle wrong");
        } catch (Exception e) {
            sa.fail("Unable to verify checkout page content: " + e.getMessage());
        }
        sa.assertAll();
    }
}
