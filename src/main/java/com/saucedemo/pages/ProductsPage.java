package com.saucedemo.pages;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.ElementUtillty;
import com.saucedemo.utils.WaitUtility;

public class ProductsPage {
	
    @FindBy(className = "title")
    private WebElement productsTitle;
    
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement hamburgerMenu;
    

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;
    
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;
    
    @FindBy(xpath = "//button[text()='Remove']")
    private WebElement removeButton;

	
	
	WebDriver driver;
	ElementUtillty elementUtillty;
	WaitUtility waitUtlity;

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtillty = new ElementUtillty();
		waitUtlity = new WaitUtility(driver);
	}
	
	public String getProductPageTitle() {
		return elementUtillty.getText(productsTitle);
	}
	
	   public void clickMenu() {
		   waitUtlity.clickWithWait(hamburgerMenu, 5);
	    }

	    public void clickLogOut() {
	    	 waitUtlity.clickWithWait(logoutLink, 5);
	    }
	    
	    public void clickOnAddToCart() {
	    	elementUtillty.click(addToCartButton);

	    }
	    
	    public String getItemCountInCart() {
	        try {
	            return cartBadge.getText();
	        } catch (NoSuchElementException e) {
	            return "0";
	        }
	    }
	    
	    public void clickRemove() {
	    	elementUtillty.click(removeButton);

	    }


}
