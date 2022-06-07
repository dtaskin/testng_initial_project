package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CarsComTest extends Base{
    /*
    Test Case 1: Validate Cars.com Sign in page form
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page -> title, url -
    And user should be able to see heading1 as "Sign in"
    And user should be able to see paragraph under “Sign in” header as “New to Cars.com? Sign up. Are you a dealer?”
    And user should be able to see Email input box with “Email” label and enabled
    And user should be able to see Password input box with “Password” label and enabled
    And user should be able to see warning under Password input box as “Minimum of eight characters”
    And user should be able to a link as “Forgot password?” under the Password input box
    And user should be able to see “By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.” Text
    And user should be able to “Sign in” button with its text and be displayed and enabled
     */

    @Test(priority = 1, description = "Test Case 1: Validate Cars.com Sign in page form")
    public void validateSignInForm(){
        driver.get("https://www.cars.com/");

        carsComLandingPage.navigateToSingInPage(driver);

        softAssert.assertTrue(carsComSignInPage.heading1.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.heading1.getText(), "Sign in");

        softAssert.assertTrue(carsComSignInPage.newToCarsComParagraph.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.newToCarsComParagraph.getText(), "New to Cars.com? Sign up. Are you a dealer?");

        softAssert.assertTrue(carsComSignInPage.emailInputBox.isDisplayed());
        softAssert.assertTrue(carsComSignInPage.emailInputBox.isEnabled());
        softAssert.assertTrue(carsComSignInPage.emailInputLabel.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.emailInputLabel.getText(), "Email");

        softAssert.assertTrue(carsComSignInPage.passwordInputBox.isDisplayed());
        softAssert.assertTrue(carsComSignInPage.passwordInputBox.isEnabled());
        softAssert.assertTrue(carsComSignInPage.passwordInputLabel.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.passwordInputLabel.getText(), "Password");

        softAssert.assertTrue(carsComSignInPage.minCharactersWarningParagraph.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.minCharactersWarningParagraph.getText(), "Minimum of eight characters");

        softAssert.assertTrue(carsComSignInPage.forgotPasswordLink.isDisplayed());
        softAssert.assertTrue(carsComSignInPage.forgotPasswordLink.isEnabled());
        softAssert.assertEquals(carsComSignInPage.forgotPasswordLink.getText(), "Forgot password?");

        softAssert.assertTrue(carsComSignInPage.termsAndConditionsParagraph.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.termsAndConditionsParagraph.getText(), "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.");

        softAssert.assertTrue(carsComSignInPage.signInButton.isDisplayed());
        softAssert.assertTrue(carsComSignInPage.signInButton.isEnabled());
        softAssert.assertEquals(carsComSignInPage.signInButton.getText(), "Sign in");
    }

    /*
    Test Case 2: Validate Cars.com Sign in page social media section
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    And user should be able to see headings as "Connect with social"
    And user should be able to “Sign in with Facebook” link with its text and be displayed and enabled
    And user should be able to “Sign in with Google” link with its text and be displayed and enabled
    And user should be able to “Sign in with Apple” link with its text and be displayed and enabled
     */

    @Test(priority = 2, description = "Test Case 2: Validate Cars.com Sign in page social media section")
    public void validateSignInPageSocialMediaSection(){
        driver.get("https://www.cars.com/");
        carsComLandingPage.navigateToSingInPage(driver);

        softAssert.assertTrue(carsComSignInPage.socialMediaHeading.isDisplayed());
        softAssert.assertEquals(carsComSignInPage.socialMediaHeading.getText(), "Connect with social");

        String[] socialLinkTexts = {"Sign in with Facebook", "Sign in with Google", "Sign in with Apple"};

        for (int i = 0; i < 3; i++) {
            softAssert.assertTrue(carsComSignInPage.socialMediaLinks.get(i).isDisplayed());
            softAssert.assertTrue(carsComSignInPage.socialMediaLinks.get(i).isEnabled());
            softAssert.assertEquals(carsComSignInPage.socialMediaLinks.get(i).getText(), socialLinkTexts[i]);
        }
    }

    /*
    Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    When user enters johndoe@gmail.com to the Email input box
    And user enters abcd1234 to the Password input box
    And user clicks on the “Sign in” button
    Then user should not be logged in and displayed an error message on the top of the form as below
    “We were unable to sign you in.
    Your email or password was not recognized. Try again soon.”
     */

    @Test(priority = 3, description = "Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials")
    public void validateErrorMessageForInvalidCredentialsToSignIn(){
        driver.get("https://www.cars.com/");
        carsComLandingPage.navigateToSingInPage(driver);

        carsComSignInPage.signIn("johndoe@gmail.com", "abcd1234");

        Assert.assertEquals(carsComSignInPage.signInErrorContent.getText(), "We were unable to sign you in.\n" +
                "Your email or password was not recognized. Try again soon.");
    }
}