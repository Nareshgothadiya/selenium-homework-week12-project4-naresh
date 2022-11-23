package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // clickOnElement(By.name("Login"));
        sendTextToElement(By.name("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.xpath("//input[@data-test='login-button']"));

        String expectedResult = "PRODUCTS";
        String actualResult = getTextFromElement(By.xpath("//span[text()='Products']"));
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        // clickOnElement(By.name("Login"));
        sendTextToElement(By.name("user-name"), "standard_user");
        sendTextToElement(By.id("password"), "secret_sauce");
        clickOnElement(By.xpath("//input[@data-test='login-button']"));

        System.out.println("The Number of Product on Page are :" + driver.findElements(By.className("inventory_item_name")).size());

        //String expectedResult="PRODUCTS";
        // String actualResult=getTextFromElement(By.xpath("//span[text()='Products']"));
        // Assert.assertEquals(expectedResult, actualResult);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}
