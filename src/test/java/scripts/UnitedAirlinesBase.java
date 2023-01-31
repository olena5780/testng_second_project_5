package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.asserts.SoftAssert;
import pages.UnitedAirlinesBasePage;
import pages.UnitedAirlinesHomePage;
import utilities.ConfigReader;
import utilities.Driver;

public class UnitedAirlinesBase {
    WebDriver driver;
    SoftAssert softAssert;
    UnitedAirlinesBasePage unitedAirlinesBasePage;
    UnitedAirlinesHomePage unitedAirlinesHomePage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getDriver();
        softAssert = new SoftAssert();
        driver.get(ConfigReader.getProperty("appURL"));

        unitedAirlinesBasePage = new UnitedAirlinesBasePage();
    }

    @AfterMethod
    public void teardown() {
        //We will quit driver and do other proper clean ups
        softAssert.assertAll();
        Driver.quitDriver();
    }
}

