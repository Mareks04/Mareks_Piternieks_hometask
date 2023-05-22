package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ItemsPage {

    public ItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="h1.jcdpl")
    private WebElement itemName;

    @FindBy(css="select#main-size-select-0")
    private WebElement sizeDropdown;

    @FindBy(css=".MwTOW[data-testid=\"current-price\"]")
    private WebElement itemPrice;

    @FindBy(css="button#product-add-button")
    private WebElement addToBagButton;

    @FindBy(linkText="Rings")
    private WebElement ringsPageNavigationButton;

    @FindBy(css="span._1z5n7CN")
    private  WebElement shoppingBasketIcon;

    @FindBy(css="button[data-testid='miniBagIcon']")
    private  WebElement shoppingBasketIconButton;

    @FindBy(css="a[data-test-id='checkout-link']")
    private  WebElement checkoutButton;

    public boolean isInitialized() {
        return this.itemName.isDisplayed();
    }

    public WebElement getItemName() {
        return this.itemName;
    }

    public WebElement getItemPrice() {
        return this.itemPrice;
    }

    public void selectSize() {
        Select sizeDropdown = new Select(this.sizeDropdown);
        sizeDropdown.selectByIndex(2);
    }

    public void clickAddToBagButton(){
        this.addToBagButton.click();
    }
    public void navigateBackToRingsPage(){
        this.ringsPageNavigationButton.click();
    }

    public boolean isShoppingBasketInitialized(){
        return this.shoppingBasketIcon.isDisplayed();
    }
    public String getShoppingBasketIcon(){
        return this.shoppingBasketIcon.getText();
    }

    public void clickShoppingBasketIconButton(){
        this.shoppingBasketIconButton.click();
    }

    public void clickCheckoutButton(){
        this.checkoutButton.click();
    }
}
