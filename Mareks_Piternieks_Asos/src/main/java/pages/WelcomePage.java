package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText="SHOP MEN")
    private WebElement genderSelectionButton;

    @FindBy(id="onetrust-accept-btn-handler")
    private WebElement acceptCookies;

    public boolean isInitialized() {
        return this.genderSelectionButton.isDisplayed();
    }

    public void enterStore(){
        this.genderSelectionButton.click();
    }

    public void acceptCookies(){
        this.acceptCookies.click();
    }

}
