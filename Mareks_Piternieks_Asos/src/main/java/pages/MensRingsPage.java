package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MensRingsPage {
    public MensRingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="h1.categoryTitle_r3Kaq")
    private WebElement title;

    @FindBy(xpath="(//section/article//a)[2]")
    private WebElement firstRing;

    @FindBy(xpath="(//section/article//a)[3]")
    private WebElement secondRing;

    public boolean isInitialized() {
        return this.title.isDisplayed();
    }

    public WebElement getTitle() {
        return this.title;
    }

    public void selectFirstRing(){
        this.firstRing.click();
    }

    public void selectSecondRing(){
        this.secondRing.click();
    }
}
