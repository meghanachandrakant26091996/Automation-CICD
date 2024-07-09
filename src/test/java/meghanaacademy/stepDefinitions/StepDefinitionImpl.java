package meghanaacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import meghanaacademy.SeleniumFrameworkDesign.CartPage;
import meghanaacademy.SeleniumFrameworkDesign.CheckoutPage;
import meghanaacademy.SeleniumFrameworkDesign.ConfirmationPage;
import meghanaacademy.SeleniumFrameworkDesign.LandingPage;
import meghanaacademy.SeleniumFrameworkDesign.ProductCatalogue;
import meghanaacademy.TestComponents.BaseTest;

public class StepDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		landingPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password)
	{
	    productCatalogue = landingPage.LoginApplication(username, password);
	}
	
	@When("^I add product (.+) to cart$")
	public void  I_add_product_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}

	 @And("^checkout (.+) and submit the order$")
	 public void checkout_product_and_submit_the_order(String productName) throws InterruptedException
	 {
		 CartPage cartPage = productCatalogue.goToCartPage();
		 Boolean match = cartPage.verifyProductDisplay(productName);
		 Assert.assertTrue(match);
		 CheckoutPage checkoutPage = cartPage.goToCheckout();
		 checkoutPage.selectCountry("india");
		 confirmationPage = checkoutPage.submitOrder();
	 }
	 
	 @Then("{string} message is displayed on ConfirmationPage")
	 public void message_displayed_on_ConfirmationPage(String string)
	 {
		 String confirmMessage = confirmationPage.getConfirmationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		 driver.close();
	 }
	 
	 @Then("{string} message is displayed")
	 public void error_message_display(String strArg1)
	 {
		 Assert.assertEquals(strArg1, landingPage.getErrorMessage());
		 driver.close();
	 }

}
