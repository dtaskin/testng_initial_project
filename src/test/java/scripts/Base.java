package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.CarsComLandingPage;
import pages.CarsComSignInPage;
import utilities.Driver;

public class Base {
    WebDriver driver;
    SoftAssert softAssert;
    CarsComLandingPage carsComLandingPage;
    CarsComSignInPage carsComSignInPage;

    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        softAssert = new SoftAssert();

        //Initialize all your page objects
        carsComLandingPage = new CarsComLandingPage();
        carsComSignInPage = new CarsComSignInPage();
    }

    @AfterMethod
    public void teardown(){
        //TODO if there is a failure, take screenshot and attach it to the report
        softAssert.assertAll();
        Driver.quitDriver();
    }
}