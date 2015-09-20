package com.tcs.ilp.tsi.vo;
/**
 * 
 */

/**
 * @author 734211
 *
 */
public class StockVO {
	int ProductCode;
	String ProductName;
	String ProductStatus;
	int Product_ModelID;
	String Thresholdstatus;
	public String getThresholdstatus() {
		return Thresholdstatus;
	}
	public void setThresholdstatus(String thresholdstatus) {
		Thresholdstatus = thresholdstatus;
	}
	public int getProduct_ModelID() {
		return Product_ModelID;
	}
	public void setProduct_ModelID(int productModelID) {
		Product_ModelID = productModelID;
	}
	public int getOrder_ID() {
		return Order_ID;
	}
	public void setOrder_ID(int orderID) {
		Order_ID = orderID;
	}
	int Order_ID;
	public int getProductCode() {
		return ProductCode;
	}
	public void setProductCode(int productCode) {
		ProductCode = productCode;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductStatus() {
		return ProductStatus;
	}
	public void setProductStatus(String productStatus) {
		ProductStatus = productStatus;
	}
	
}
