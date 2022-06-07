package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;
import utilities.Waiter;

public class CarsComLandingPage {

    //Constructor
    public CarsComLandingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Web Elements
    @FindBy(css = ".header-signin")
    public WebElement signInLink;

    public void navigateToSingInPage(WebDriver driver){
        signInLink.click();
        Waiter.waitUntilTitleIs(driver, 30, "Cars.com | Cars.com");
        Assert.assertEquals(driver.getTitle(), "Cars.com | Cars.com", "User could not navigate to “Sign in” page");
    }
}