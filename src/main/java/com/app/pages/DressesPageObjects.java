package com.app.pages;

import java.util.*;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class DressesPageObjects extends Basepage {
	
	public DressesPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[1]//a/span")
	private WebElement sizeS;
	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[2]//a/span")
	private WebElement sizeM;
	
	@FindBy(xpath="//*[@id='ul_layered_id_attribute_group_1']/li[3]//a/span")
	private WebElement sizeL;
	
	@FindBy(xpath="//*[@class='heading-counter']")
	private WebElement productHeader;
	
	@FindBys(@FindBy(xpath="//ul[@class='product_list grid row']/li"))
	private List<WebElement> lstProducts;
	
	@FindBy(xpath="//*[@class='product_list grid row']/li[1]//a[1]//img[1]")
	private WebElement frstDress;
	
	@FindBy(xpath="//*[@class='product_list grid row']/li[1]//*[text()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//*[@title='Close window']")
	private WebElement closeBtn;
	
	@FindBy(xpath="//*[@id='layer_cart']//div[1]/h2")
	private WebElement pdtMsg;
	
	@FindBy(xpath="//*[@id='selectProductSort']")
	private WebElement dropDownSort;
	
	@FindBys(@FindBy(xpath="//*[@class='right-block']//span[@class='price product-price']"))
	private List<WebElement> lstProductPrices;
	
	@FindBy(xpath="//*[@id='layered_ajax_loader']/p/img")
	private WebElement iconLoad;
	
	@FindBys(@FindBy(xpath="//*[@class='right-block']//a[@class='product-name']"))
	private List<WebElement> lstProductNames;
	
	public WebElement getSizeS() {
		return sizeS;
	}
	
	public WebElement getSizeM() {
		return sizeM;
	}
	
	public WebElement getSizeL() {
		return sizeL;
	}
	
	public int getProductCountFromHeaderText() {
		return Integer.parseInt(productHeader.getText().split(" ")[2]);
	}
	
	 public int getProductCount() {
		 return lstProducts.size();
	 }
	 
	 public WebElement getFrstDress() {
		 return frstDress;
	 }
	 
	 public WebElement getAddToCart() {
		 return addToCart;
	 }
	 
	 public WebElement getCloseBtn() {
		 return closeBtn;
	 }
	 
	 public void clickCloseBtn() {
		 closeBtn.click();
	 }
	 
	 public WebElement getPdcIcon() {
		 isElementVisible(pdtMsg);
		 return pdtMsg;
	 }
	 
	 public String getPdtMsg() {
		 return pdtMsg.getText();
	 }
	 
	 public String selectSortOption(String input) {
		 return selectFromDropDown(dropDownSort,input);
	 }
	 
	 public List<Double> getProductPrices() {
		 List<Double> lst=new ArrayList<Double>();
		 isElementVisible(iconLoad);
		 isElementInVisible(iconLoad);
		 
		 for(WebElement e:lstProductPrices) {
			 String txt=e.getText();
			 txt=txt.replace("$", "").trim();
			 Double b=Double.parseDouble(txt);
			 lst.add(b);
			 
			 //lst.add(Double.parseDouble(e.getText().replace("$","").trim()));
		 }
		 return lst;
		 
		 }
	 
	 public List<String> getProductNames() {
		 ArrayList<String> productNames=new ArrayList<String>();
		 isElementVisible(iconLoad);
		 isElementInVisible(iconLoad);
		 for(WebElement e:lstProductNames) {
			 String txt=e.getText();
			 productNames.add(txt.trim());
		 }
		 return productNames;
		 }
	 }

