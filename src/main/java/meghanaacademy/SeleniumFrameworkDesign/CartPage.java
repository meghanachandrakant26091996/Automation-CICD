package meghanaacademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import meghanaacademy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	
	@FindBy(xpath="//div[@class='subtotal cf ng-star-inserted']//button[@class='btn btn-primary']")
	WebElement checkOut;
	
	public Boolean verifyProductDisplay(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() throws InterruptedException
	{
		checkOut.click();
		Thread.sleep(4000);
		return new CheckoutPage(driver);
	}
	

}
