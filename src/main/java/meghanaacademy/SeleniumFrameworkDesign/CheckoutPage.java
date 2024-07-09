package meghanaacademy.SeleniumFrameworkDesign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import meghanaacademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="//a[@class='btnn action__submit ng-star-inserted']")
	WebElement submit;
	
	By results = By.xpath("//section[@class='ta-results list-group ng-star-inserted']");
	
	public void selectCountry(String countryName)
	{
	Actions a = new Actions(driver);
	a.sendKeys(country, countryName).build().perform();
	waitForElementToAppear(results);
	selectCountry.click();	
	}
	
	public ConfirmationPage submitOrder()
	{
		waitForElementToBeClickable(submit);
		submit.click();
		return new ConfirmationPage(driver);
	}

	

}
