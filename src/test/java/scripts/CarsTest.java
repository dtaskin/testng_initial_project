package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CarsTest extends Base{
    @Test(priority = 1)
    public  void validateSignInPageForm(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.signInHeader.isDisplayed() && signInPage.signInHeader.getText().equals("Sign in"));
        Assert.assertTrue(signInPage.paragraph.isDisplayed() && signInPage.paragraph.getText().equals("New to Cars.com? Sign up. Are you a dealer?"));
        Assert.assertTrue(signInPage.emailInputBox.isDisplayed() && signInPage.emailInputBox.isEnabled());
        Assert.assertTrue(signInPage.emailLabel.getText().equals("Email"));
        Assert.assertTrue(signInPage.passwordInputBox.isDisplayed() && signInPage.passwordInputBox.isEnabled());
        Assert.assertTrue(signInPage.passwordLabel.getText().equals("Password"));
        Assert.assertTrue(signInPage.passwordMinLengthWarning.getText().equals("Minimum of eight characters"));
        Assert.assertTrue(signInPage.forgotPasswordLink.isDisplayed() && signInPage.forgotPasswordLink.getText().equals("Forgot password?"));
        Assert.assertTrue(signInPage.text.isDisplayed() && signInPage.text.getText().equals("By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service."));
        Assert.assertTrue(signInPage.signInButton.isDisplayed() && signInPage.signInButton.isEnabled() &&
                signInPage.signInButton.getText().equals("Sign in"));

    }
    @Test(priority = 3)
    public void validateSignInPageSocialMediaSection(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        Assert.assertTrue(signInPage.connectWithSocialHeader.isDisplayed() && signInPage.connectWithSocialHeader.getText().equals("Connect with social"));
        Assert.assertTrue(signInPage.facebookButton.isDisplayed() && signInPage.facebookButton.isEnabled() &&
                signInPage.facebookButton.getText().equals("Sign in with Facebook"));
        Assert.assertTrue(signInPage.googleButton.isDisplayed() && signInPage.googleButton.isEnabled() &&
                signInPage.googleButton.getText().equals("Sign in with Google"));
        Assert.assertTrue(signInPage.appleButton.isDisplayed() && signInPage.appleButton.isEnabled() &&
                signInPage.appleButton.getText().equals("Sign in with Apple"));
    }
    @Test(priority = 2, dependsOnMethods = "validateSignInPageForm")
    public void validateNotToSignIn(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        signInPage.emailInputBox.sendKeys("johndoe@gmail.com");
        signInPage.passwordInputBox.sendKeys("abcd1234");
        signInPage.signInButton.click();
        Assert.assertTrue(signInPage.errorMessageTitle.isDisplayed() && signInPage.errorMessageTitle.getText().equals("We were unable to sign you in."));
        Assert.assertTrue(signInPage.errorMessageText.isDisplayed() && signInPage.errorMessageText.getText().equals("Your email or password was not recognized. Try again soon."));
    }
}