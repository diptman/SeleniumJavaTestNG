package org.example.project;

import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test
    @Parameters({"name","password"})
    private void loginWithValidCredentials(String name, String password)  {
        Reporter.log("# Navigate to application url", true);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        Reporter.log("# Enter Standard User name", true);
        loginPage.enterUsername(name);
        Reporter.log("# Enter Password", true);
        loginPage.enterPassword(password);
        Reporter.log("# Click on login button", true);
        loginPage.clickLoginButton();
        Reporter.log("# Assert the text title", true);
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
