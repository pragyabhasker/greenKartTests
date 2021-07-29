package GreenKartTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GreenKartPageObjects.GreenKartBasket;
import GreenKartPageObjects.GreenKartHomePage;

public class selectVegetables {
	@Test
	public void addVegetables() {
		System.setProperty("webdriver.chrome.driver", "//Users//ishanbhasker//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        
        GreenKartHomePage gkhp = new GreenKartHomePage(driver);
        GreenKartBasket gkb = new GreenKartBasket(driver);
        
        gkhp.addVegetablesInBasket();
        
        gkhp.proceedToCheckout();
        
        gkb.verifyBasket();
        
        
        
	}

}
