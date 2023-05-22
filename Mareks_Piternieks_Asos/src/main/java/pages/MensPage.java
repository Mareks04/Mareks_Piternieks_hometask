package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensPage {
    public MensPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[@data-index=\"4\" and span/span[text()=\"Accessories\"]]")
    private WebElement accessories;

    @FindBy(xpath="(//span[text()=\"Rings\"]/parent::a)[2]")
    private WebElement rings;


    public boolean isInitialized() {
        return this.accessories.isDisplayed();
    }

    public WebElement getAccessories() {
        return this.accessories;
    }

    public WebElement getRings() {
        return this.rings;
    }

    public void clickRings() {
        this.rings.click();
    }

    public void clickAccessories() {
        this.accessories.click();
    }

}
