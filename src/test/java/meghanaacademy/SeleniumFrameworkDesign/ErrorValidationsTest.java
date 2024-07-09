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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import meghanaacademy.TestComponents.BaseTest;
import meghanaacademy.TestComponents.Retry;

public class ErrorValidationsTest extends BaseTest{

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void submitOrder() throws InterruptedException, IOException

	{
		String productName = "ZARA COAT 3";
		
        
		ProductCatalogue productCatalogue = landingPage.LoginApplication("meghscha@gmail.com",
				"Mhsch@nd1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());


	
		
	}

}
