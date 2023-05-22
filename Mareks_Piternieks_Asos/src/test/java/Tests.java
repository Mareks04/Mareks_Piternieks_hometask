import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import custom.objects.Product;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.ConfigReader;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static common.Helper.*;

public class Tests {
  private WebDriver driver;

  static ExtentReports report;

  @BeforeClass(alwaysRun = true)
  public static void initialiseReporter() {
    String reporterPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "reports" + File.separator + "TestReport.html";
    report = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(reporterPath);
    spark.config().setReportName("Mintos task");
    report.setSystemInfo("Project", "Mareks Piternieks Task");
    report.setSystemInfo("OS", "MAC");
    report.setSystemInfo("Author", "Mareks Piternieks");
    report.attachReporter(spark);
  }

  @AfterClass(alwaysRun = true)
  public static void createReport() {
    report.flush();
  }

  @BeforeMethod(alwaysRun = true)
  private void setUpDriver() {
    System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod(alwaysRun = true)
  private void closeDriver() {
    driver.close();
    driver.quit();
  }

  public void addScreenshotToReport(Status status, ExtentTest reporter) {
    String base64ScreenShot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    reporter.log(status, MediaEntityBuilder.createScreenCaptureFromBase64String(base64ScreenShot).build());
  }

  @Test
  public void asosTest() {
    ConfigReader configReader = new ConfigReader();
    String env = configReader.getEnvironment();
    String url = configReader.getApplicationUrl();
    String email = configReader.getPropertyValue("email");
    String password = configReader.getPropertyValue("password");

    ExtentTest testReporter = report.createTest(env);
    testReporter.info("User adds 2 items to shopping cart and proceed with checkout");
    driver.get(url);
    WelcomePage welcomePage = new WelcomePage(driver);
    Assert.assertTrue(welcomePage.isInitialized());
    testReporter.info("Welcome page is initialized");
    welcomePage.acceptCookies();
    welcomePage.enterStore();

    MensPage mensPage = new MensPage(driver);
    Assert.assertTrue(mensPage.isInitialized());
    testReporter.info("Mens page is initialized");
    mensPage.clickAccessories();
    mensPage.clickRings();

    MensRingsPage mensRingsPage = new MensRingsPage(driver);
    Assert.assertTrue(mensRingsPage.isInitialized());
    testReporter.info("Men's rings page is initialized");

    Assert.assertEquals(mensRingsPage.getTitle().getText(), "Men's Rings");
    testReporter.info("Title is correct: " + mensRingsPage.getTitle().getText());
    mensRingsPage.selectFirstRing();

    ItemsPage itemsPage = new ItemsPage(driver);
    Assert.assertTrue(itemsPage.isInitialized());
    testReporter.info("Items page is initialized");
    itemsPage.selectSize();
    itemsPage.clickAddToBagButton();
    Product[] products = new Product[2];
    products[0] = new Product(itemsPage.getItemName().getText(), itemsPage.getItemPrice().getText());
    Assert.assertTrue(itemsPage.isShoppingBasketInitialized(), "Shopping basket was not updated - product is not added");
    if (itemsPage.getShoppingBasketIcon().equals("1")) {
      testReporter.info("First product added");
    } else {
      String actualQuantity = mensRingsPage.getTitle().getText();
      String expectedQuantity = "1";
      testReporter.info("Added product count incorrect! Expected: " + expectedQuantity + ", Actual: " + actualQuantity);
      addScreenshotToReport(Status.WARNING, testReporter);
      testReporter.fail("Product quantity assertion failed");
    }
    itemsPage.navigateBackToRingsPage();

    Assert.assertTrue(mensRingsPage.isInitialized());
    Assert.assertEquals(mensRingsPage.getTitle().getText(), "Men's Rings");
    testReporter.info("Title is correct: " + mensRingsPage.getTitle().getText());
    mensRingsPage.selectSecondRing();

    Assert.assertTrue(itemsPage.isInitialized());
    itemsPage.selectSize();
    itemsPage.clickAddToBagButton();
    products[1] = new Product(itemsPage.getItemName().getText(), itemsPage.getItemPrice().getText());
    if (itemsPage.getShoppingBasketIcon().equals("2")) {
      testReporter.info("Second product added");
    } else {
      String actualQuantity = mensRingsPage.getTitle().getText();
      String expectedQuantity = "2";
      testReporter.info("Added product count incorrect! Expected: " + expectedQuantity + ", Actual: " + actualQuantity);
      addScreenshotToReport(Status.WARNING, testReporter);
      testReporter.fail("Product quantity assertion failed");
    }

    itemsPage.clickShoppingBasketIconButton();
    itemsPage.clickCheckoutButton();

    CheckoutPage checkoutPage = new CheckoutPage(driver);
    Assert.assertTrue(checkoutPage.isInitialized());
    checkoutPage.enterEmail(email);
    checkoutPage.clickContinue();
    checkoutPage.enterPassword(password);
    checkoutPage.clickSignInButton();
    List<WebElement> allPrices = driver.findElements(By.cssSelector("span.item-price"));
    List<WebElement> allNames = driver.findElements(By.cssSelector("span.item-description"));

    int size = Math.min(allPrices.size(), allNames.size());
    Product[] checkoutProducts = new Product[size];

    for (int i = 0; i < size; i++) {
      WebElement priceElement = allPrices.get(i);
      WebElement nameElement = allNames.get(i);

      String price = priceElement.getText();
      String name = nameElement.getText();
      checkoutProducts[i] = new Product(name, price);
    }

    Assert.assertTrue(compareProductArrays(products, checkoutProducts), "Products in basket does not match to selected ones");
    float total = calculateTotalPrice(products);
    Assert.assertEquals(total, checkoutPage.getTotalPrice(), "Total price and price of all products did not match");

  }
}


