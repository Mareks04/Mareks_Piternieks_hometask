package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="checkEmailAddress")
    private WebElement emailInputField;

    @FindBy(css="input.continue-button")
    private WebElement continueButton;

    @FindBy(id="Password")
    private WebElement passwordInputField;

    @FindBy(id="signin")
    private WebElement signInButton;

    @FindBy(css="span.bag-subtotal-price")
    private WebElement totalPrice;

    public boolean isInitialized() {
        return this.emailInputField.isDisplayed();
    }

    public void enterEmail(String email) {
        this.emailInputField.sendKeys(email);
    }

    public void clickContinue() {
        this.continueButton.click();
    }

    public void enterPassword(String password) {
        this.passwordInputField.sendKeys(password);
    }

    public void clickSignInButton() { this.signInButton.click(); }

    public float getTotalPrice(){
        String priceWithoutSymbol = this.totalPrice.getText().replace("€", "");
        return Float.parseFloat(priceWithoutSymbol);
    }


}
