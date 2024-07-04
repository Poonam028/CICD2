package MobileAppAutomation.POM;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import MobileAppAutomation.pageObjects.android.CartPage;
import MobileAppAutomation.pageObjects.android.FormPage;
import MobileAppAutomation.pageObjects.android.ProductCatalogue;
import io.appium.java_client.AppiumBy;

public class eCommerce_TC2 extends BaseTestGeneralStoreApp {

	@Test
	public void AddItemToCart() throws InterruptedException {
		FormPage formPage = new FormPage(driver);
		formPage.Fillform("Poonam Sawant", "Bhutan");
		formPage.SetGender("Female");
		ProductCatalogue productCatalogue = formPage.SubmitForm();
		productCatalogue.addProductToCartByIndex(0);
		productCatalogue.addProductToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCart();
		double totalSum = cartPage.getProductSum();
		double displaySum = cartPage.getTotalAmount();
		Assert.assertEquals(totalSum, displaySum);
		cartPage.acceptTermsAndConditions();
		cartPage.submitOrder();
		Thread.sleep(5000);
	}
	
}