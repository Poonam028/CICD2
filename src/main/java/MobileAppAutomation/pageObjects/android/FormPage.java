package MobileAppAutomation.pageObjects.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	AndroidDriver driver;

	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver = driver; 
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement CountryField; 
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement NameField; 
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
	private WebElement FemaleOption; 
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
	private WebElement MaleOption; 
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShopBtn; 
	
	
	public void Fillform(String name, String countryName) {
		CountryField.click();
		scrollToText(countryName);
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+countryName+"\"));")).click();

		NameField.sendKeys(name);
	}
	public void SetGender(String gender) {
		if (gender.contains("Female"))
		{
	FemaleOption.click();
		} else 
			MaleOption.click();
	}
	
	public ProductCatalogue SubmitForm( ) {
		LetsShopBtn.click();
		return new ProductCatalogue(driver);
	}
}



