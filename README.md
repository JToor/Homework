# Homework - Jungle Socks App

### To Run test cases: 

#### From Terminal,
1. Go to terminal - > navigate to home dir test repo
2. To run all tests run command: `mvn test` 
3. To run individual tests: `mvn -Dtest=classname#testMethodname test` i.e: `mvn -Dtest=JungleSocksTests#verifyHomepageContent test`

#### From IDE,
1. Go to JungleSocksTests.java class
2. Click on play button on class name
3. Click on individual test play button to run individually

#### Test Cases Automated:

1. Verify all the content on homepage when user lands on jungle socks website
2. Verify all the content on checkout page when user try to purchase different types of socks
3. Verify all the content on checkout page when user try to purchase different types of socks
4. Verify all the content on checkout page when user try to purchase different types of socks
5. Verify all the content on checkout page when user try to purchase different types of socks
6. Verify all the content on checkout page when user try to purchase different types of socks
7. Verify product item is not displayed on checkout page if quantity is less than 1
8. Verify error page is displayed if state is not selected before checkout

### Bugs/Improvements suggested:

1. Quantity fields for products should be int only should not accept varchar or negative numbers
2. Checkout button should be disabled on homepage unless atleast 1 product have more than 0 quantity
3. Checkout button should be disabled when ship to state is not selected
4. Quantity spelling are wrong in subtitle of homepage : `Expected: Quantity, Actual: quantiy`
