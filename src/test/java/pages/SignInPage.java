package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    @FindBy(tagName = "h1")
    public WebElement signInHeader;

    @FindBy(css = "div[class='column-1']>p")
    public WebElement paragraph;

    @FindBy(css = "input[id='email']")
    public WebElement emailInputBox;

    @FindBy(css = ".sds-label")
    public WebElement emailLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[@for='password']")
    public WebElement passwordLabel;

    @FindBy(css = ".sds-helper-text")
    public WebElement passwordMinLengthWarning;

    @FindBy(linkText = "Forgot password?")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//a[@data-linkname='privacy-statement']/..")
    public WebElement text;

    @FindBy(xpath = "//button[@class='sds-button']")
    public WebElement signInButton;

    @FindBy(tagName = "h3")
    public WebElement connectWithSocialHeader;

    @FindBy(css = "a[href='/signin/fb_go/']")
    public WebElement facebookButton;

    @FindBy(css = "a[href='/signin/google_go/']")
    public WebElement googleButton;

    @FindBy(css = "a[href='/signin/apple_go/']")
    public WebElement appleButton;

    @FindBy(className = "sds-notification__title")
    public WebElement errorMessageTitle;

    @FindBy(className = "sds-notification__desc")
    public WebElement errorMessageText;



}