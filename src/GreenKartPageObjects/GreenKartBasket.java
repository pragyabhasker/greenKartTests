package GreenKartPageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import GreenKartPageObjects.GreenKartHomePage;

public class GreenKartBasket {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GreenKartBasket(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="p.product-name")
	List<WebElement> itemsInCart;
	
	public void verifyBasket() {
		GreenKartHomePage gkhp = new GreenKartHomePage(driver);
		
		List<String> vegList = Arrays.asList(gkhp.vegNeededArray);
		
		int count=0;
		
		for(int i =0; i < itemsInCart.size(); i++) {
			//System.out.println(itemsInCart.get(i).getText());
			
			String[] itemsInCartList = itemsInCart.get(i).getText().split("-");
			String cartItemsFormatted = itemsInCartList[0].trim();
			
			if(vegList.contains(cartItemsFormatted)) {
				System.out.println("They match!");
				Assert.assertTrue(true);
			} else {
				System.out.println("They don't match!");
				Assert.assertTrue(false);
			}
			count++;
			if(count == vegList.size()) {
				break;
			}
			
		}
		
		
	}

}
