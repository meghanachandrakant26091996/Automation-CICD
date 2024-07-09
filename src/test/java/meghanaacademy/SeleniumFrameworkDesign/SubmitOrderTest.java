package meghanaacademy.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import meghanaacademy.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String productName = "ZARA COAT 3";
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException

	{
		
		
		 Assert.assertNotNull(landingPage, "landingPage is null. Application launch failed.");

	        ProductCatalogue productCatalogue = landingPage.LoginApplication(email, password);
	        List<WebElement> products = productCatalogue.getProductList();
	        productCatalogue.addProductToCart(productName);
	        CartPage cartPage = productCatalogue.goToCartPage();

	        Boolean match = cartPage.verifyProductDisplay(productName);
	        Assert.assertTrue(match);
	        CheckoutPage checkoutPage = cartPage.goToCheckout();
	        checkoutPage.selectCountry("india");
	        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	        String confirmMessage = confirmationPage.getConfirmationMessage();

	        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest()
	{
		Assert.assertNotNull(landingPage, "landingPage is null. Application launch failed.");

        ProductCatalogue productCatalogue = landingPage.LoginApplication("meghanachandrakant.26@gmail.com", "Meghsch@nd1");
        OrderPage orderPage = productCatalogue.goToOrderPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"meghanachandrakant.26@gmail.com", "Meghsch@nd1", "ZARA COAT 3"}};
	}

}
