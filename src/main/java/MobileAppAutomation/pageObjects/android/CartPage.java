package MobileAppAutomation.pageObjects.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage  extends AndroidActions{
	AndroidDriver driver;

	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productPrice; 
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmmount; 
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	public WebElement termsCondition; 

	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	public double getProductSum() {
		int Count = productPrice.size();
		double totalSum = 0;
		for (int i=0; i<productPrice.size();i++) {
			String Price = productPrice.get(i).getText();
			Double price = getFormattedAmount(Price);
			totalSum = totalSum + price;;;
		}
		return totalSum;

	}
	public double getTotalAmount() {
		return getFormattedAmount(totalAmmount.getText());
		
	}
	public void acceptTermsAndConditions() {
		LongPress(termsCondition);
		acceptButton.click();
	}
	
	public void submitOrder() {
		proceed.click();
	}
	
}


