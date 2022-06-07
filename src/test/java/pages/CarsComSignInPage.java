package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarsComSignInPage {
    public CarsComSignInPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".sds-heading--1")
    public WebElement heading1;

    @FindBy(css = ".sds-page-section__title--sub")
    public WebElement newToCarsComParagraph;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(css = "label[for='email']")
    public WebElement emailInputLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordInputLabel;

    @FindBy(css = ".sds-helper-text")
    public WebElement minCharactersWarningParagraph;

    @FindBy(css = ".password-help a")
    public WebElement forgotPasswordLink;

    @FindBy(css = ".sds-disclaimer ")
    public WebElement termsAndConditionsParagraph;

    @FindBy(xpath = "//input[@id='redirect_path']/..//button")
    public WebElement signInButton;

    @FindBy(css = ".sds-heading--3")
    public WebElement socialMediaHeading;

    @FindBy(css = ".sidebar-social-login a")
    public List<WebElement> socialMediaLinks;

    @FindBy(css = ".sds-notification__content")
    public WebElement signInErrorContent;

    public void signIn(String email, String password){
        emailInputBox.sendKeys(email);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }
}