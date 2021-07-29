package GreenKartPageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GreenKartHomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GreenKartHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="h4.product-name")
	List<WebElement> names;
	
	@FindBy(css="div.product button")
	List<WebElement> button;
	
	@FindBy(css="a.cart-icon")
	WebElement cartIcon;
	
	
	@FindBy(css="div.cart-preview.active button")
	WebElement proceedToCheckoutButton;
	
	String[] vegNeededArray = {"Brocolli", "Cauliflower", "Cashews"};

	
	public void addVegetablesInBasket() {
		
		
		// List<WebElement> names = driver.findElements(By.cssSelector("h4.product-name"));
		int count =0;
		for(int i =0; i < names.size(); i++) {
			String[] prodName = names.get(i).getText().split("-");
			String vegNames = prodName[0].trim();
			
			//System.out.println(vegNames);
			
			List<String> vegNeededlist = Arrays.asList(vegNeededArray); 
			
			if(vegNeededlist.contains(vegNames)) {
				//List<WebElement> button = driver.findElements(By.cssSelector("div.product button"));
				button.get(i).click();
				count++;
			}
			
			
			if (count == vegNeededArray.length) {
				break;
			}
			
			}	
	}
	
	public void proceedToCheckout() {
		cartIcon.click();
		proceedToCheckoutButton.click();
		
	}

}
