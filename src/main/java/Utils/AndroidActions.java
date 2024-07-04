package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidActions {
	AndroidDriver driver;
	
	public AndroidActions (AndroidDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	 public void LongPress(WebElement ele) {
		  ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	 }
	 
	 public void scrollToText(String Text) {
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Text+"\"));"));
	 }
	 
	 public void SwipeAction(WebElement ele, String Direction) {
		    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	  				"elementId", ((RemoteWebElement) ele).getId(),  "direction", "left",
	  		        "percent", 0.75));
	    }
	 
	 public Double getFormattedAmount(String amount) {
			Double price = Double.parseDouble(amount.substring(1));

			return price;
	    	
	    }
	 
	 
}
