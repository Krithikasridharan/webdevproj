package com.tcs.ilp.tsi.vo;

import java.io.Serializable;
public class ProductModelVO implements Serializable{
	
	private static final long serialVersionUID = 00001;
	
	private int productModelId = 0;
	private String productModelName = null;
	private int productModelThreshold = 0;
	private float productModelPrice = 0;
	private String productModelDescription = null;
	private String productModelFeatures = null;
	private int retailerID=0;
	private java.sql.Date taggedDate;
	private int quantity=0;
	private int thresholdlimit=0;
	public int getThresholdlimit() {
		return thresholdlimit;
	}

	public void setThresholdlimit(int thresholdlimit) {
		this.thresholdlimit = thresholdlimit;
	}

	public ProductModelVO()
	{
		
	}
	
	public java.sql.Date getTaggedDate() {
		return taggedDate;
	}

	public void setTaggedDate(java.sql.Date taggedDate) {
		this.taggedDate = taggedDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public int getRetailerID() {
		return retailerID;
	}

	public void setRetailerID(int retailerID) {
		this.retailerID = retailerID;
	}
	
	public ProductModelVO (int pId, String pName, String pDesc, String pFeat, float pPrice, int pThresh )
	{
		this.productModelId = pId;
		this.productModelName = pName;
		this.productModelPrice = pPrice;
		this.productModelThreshold = pThresh;
		this.productModelDescription = pDesc;
		this.productModelFeatures = pFeat;
	}
	
	
	
	
	public int getProductModelId()
	{
		return productModelId;
	}
	public void setProductModelId(int xId)
	{
		this.productModelId = xId; 
	}
	
	public String getProductModelDescription()
	{
		return productModelDescription;
	}
	public void setProductModelDescription(String xDesc)
	{
		this.productModelDescription = xDesc; 
	}
	
	public String getProductModelFeatures()
	{
		return productModelFeatures;
	}
	public void setProductModelFeatures(String xFeat)
	{
		this.productModelFeatures = xFeat; 
	}
	
	public String getProductModelName()
	{
		return productModelName;
	}
	public void setProductModelName(String xName)
	{
		this.productModelName = xName; 
	}

	public int getProductModelThreshold()
	{
		return productModelThreshold;
	}
	public void setProductModelThreshold(int xThresh)
	{
		this.productModelThreshold = xThresh; 
	}
	
	public float getProductModelPrice()
	{
		return productModelPrice;
	}
	public void setProductModelPrice(float xPrice)
	{
		this.productModelPrice = xPrice; 
	}
}
