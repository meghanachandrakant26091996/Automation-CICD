package meghanaacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import meghanaacademy.SeleniumFrameworkDesign.CartPage;
import meghanaacademy.SeleniumFrameworkDesign.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	@FindBy(xpath="//section[@class='ta-results list-group ng-star-inserted']")
	WebElement results;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement proceed;
	
	public CartPage goToCartPage() throws InterruptedException
	{
		cartHeader.click();
		Thread.sleep(4000);
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	
	public void waitForElementToAppear(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToAppear(WebElement findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForElementToBeClickable(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}

}

