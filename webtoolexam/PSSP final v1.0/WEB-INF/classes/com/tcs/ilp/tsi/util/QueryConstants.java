package com.tcs.ilp.tsi.util;

public class QueryConstants {
	
	/*Query Constants for PackageDAO*/
	public static final String LOGINQUERY="SELECT * FROM LOGIN_TBL where user_name=? and password=?";
	public static final String ADDPACKAGE = "INSERT INTO COMP_PACKAGE_TBL values(package_seq.nextval,?,?)";
	public static final String VIEWPACKAGE= "SELECT * FROM COMP_PACKAGE_TBL";
	public static final String VIEWPACKAGEID= "SELECT package_id FROM COMP_PACKAGE_TBL";
	public static final String FINDPACKAGE= "SELECT * FROM COMP_PACKAGE_TBL where package_id=?";
	public static final String UPDATEPACKAGE= "UPDATE COMP_PACKAGE_TBL set offers=?,amount=? where package_id=?";
	public static final String DELETEPACKAGE= "DELETE FROM COMP_PACKAGE_TBL where package_id=?";
	public static final String VIEWREWARDS = "SELECT * FROM RETAILER_REWARDS_TBL";
	public static final String SORTBYIDASC="SELECT * FROM COMP_PACKAGE_TBL ORDER BY package_id ";
	public static final String SORTBYIDDES="SELECT * FROM COMP_PACKAGE_TBL ORDER BY package_id desc";
	public static final String SORTBYAMOUNTASC="SELECT * FROM COMP_PACKAGE_TBL ORDER BY amount";
	public static final String SORTBYAMOUNTDES="SELECT * FROM COMP_PACKAGE_TBL ORDER BY amount desc";
	
		
	/*Query Constants for ProductModelDAO*/
	
	public static final String SEQUENCE = "select Model_seq.nextval from dual";
	public static final String ADDPRODUCTMODEL = "INSERT INTO PRODUCTMODEL_INFO_TBL (PRODUCTMODEL_ID, PRODUCTMODEL_NAME, PRODUCTMODEL_DESCRIPTION, PRODUCTMODEL_FEATURES, PRODUCTMODEL_PRICE, PRODUCTMODEL_THRESHOLD) values(?,?,?,?,?,?)";
	public static final String VIEWPRODUCTMODEL = "select * from productmodel_info_tbl join rtl_productmodel_tbl on productmodel_info_tbl.productmodel_id=rtl_productmodel_tbl.productmodel_id join inventory_tbl on productmodel_info_tbl.productmodel_id=inventory_tbl.productmodel_id";
	public static final String VIEWRETAILERID = "SELECT retailer_id from RTL_INFO_TBL";
	public static final String TAGRETAILER = "INSERT INTO RTL_PRODUCTMODEL_TBL VALUES(?,?,?)";
	public static final String ADDQUANTITY = "INSERT INTO INVENTORY_TBL VALUES(?,?)";
	public static final String FINDPRODUCTID = "SELECT PRODUCTMODEL_ID FROM PRODUCTMODEL_INFO_TBL";
	public static final String DELETEPRODUCTMODEL = "DELETE FROM PRODUCTMODEL_INFO_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String UPDATEPRODUCTMODEL = "UPDATE PRODUCTMODEL_INFO_TBL SET PRODUCTMODEL_NAME = ?, PRODUCTMODEL_DESCRIPTION = ?, PRODUCTMODEL_FEATURES = ?, PRODUCTMODEL_PRICE = ?, PRODUCTMODEL_THRESHOLD = ? WHERE PRODUCTMODEL_ID = ?";
	public static final String FINDPRODUCTINFO = "SELECT * FROM PRODUCTMODEL_INFO_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String FINDRETAILERID = "SELECT RETAILER_ID FROM RTL_PRODUCTMODEL_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String UPDATERTL = "insert into rtl_productmodel_tbl values(?,?,?)";
	public static final String DELETETAGGEDRETAILER="DELETE FROM RTL_PRODUCTMODEL_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String DELETEINVENTORY="DELETE FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String SELECTSTATUS = "SELECT PRODUCT_STATUS FROM PRODUCT_STOCK_TBL WHERE PRODUCTMODEL_ID=?";
    public static final String DELETESELECT="select * from RTL_PRODUCTMODEL_TBL where productmodel_id=?";
    public static final String SELECTQUANTITY="select quantity from INVENTORY_TBL where productmodel_id=?";
    public static final String DELETESTOCK="DELETE FROM PRODUCT_STOCK_TBL WHERE PRODUCTMODEL_ID=?";
    public static final String SORTBYIDASCP="select * from productmodel_info_tbl join rtl_productmodel_tbl on productmodel_info_tbl.productmodel_id=rtl_productmodel_tbl.productmodel_id join inventory_tbl on productmodel_info_tbl.productmodel_id=inventory_tbl.productmodel_id ORDER BY productmodel_info_tbl.PRODUCTMODEL_ID";
	public static final String SORTBYIDDESP="select * from productmodel_info_tbl join rtl_productmodel_tbl on productmodel_info_tbl.productmodel_id=rtl_productmodel_tbl.productmodel_id join inventory_tbl on productmodel_info_tbl.productmodel_id=inventory_tbl.productmodel_id ORDER BY productmodel_info_tbl.PRODUCTMODEL_ID desc";
	public static final String SORTBYQUANTITYASC="select * from productmodel_info_tbl join rtl_productmodel_tbl on productmodel_info_tbl.productmodel_id=rtl_productmodel_tbl.productmodel_id join inventory_tbl on productmodel_info_tbl.productmodel_id=inventory_tbl.productmodel_id ORDER BY inventory_tbl.QUANTITY";
	public static final String SORTBYQUANTITYDES="select * from productmodel_info_tbl join rtl_productmodel_tbl on productmodel_info_tbl.productmodel_id=rtl_productmodel_tbl.productmodel_id join inventory_tbl on productmodel_info_tbl.productmodel_id=inventory_tbl.productmodel_id ORDER BY inventory_tbl.QUANTITY desc";
	
	
	/* Query Constants for threshold legends*/
	
	public static final String VIEWTHRESHOLD="select productmodel_info_tbl.productmodel_id,productmodel_info_tbl.productmodel_threshold,inventory_tbl.quantity from productmodel_info_tbl join inventory_tbl on productmodel_info_tbl.productmodel_id=inventory_tbl.productmodel_id";
	
	
	/* Query Constants for Stock */
	
	
	public static final String ADDSTOCK = "INSERT INTO PRODUCT_STOCK_TBL(PRODUCT_CODE, PRODUCTMODEL_ID,PRODUCT_NAME,PRODUCT_STATUS) values(Stock_Seq.nextval,?,?,?)";
	public static final String INCREMENTQUANTITY="SELECT * FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String UPDATEQUANTITY="UPDATE INVENTORY_TBL SET QUANTITY=? WHERE PRODUCTMODEL_ID=?";
	public static final String DECREMENTQUANTITY="SELECT QUANTITY FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String FINDSTOCK="SELECT * FROM PRODUCT_STOCK_TBL WHERE PRODUCT_CODE=?";
	public static final String SELECT_QUANTITY="SELECT QUANTITY FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String DELETE_STOCK = "DELETE FROM PRODUCT_STOCK_TBL WHERE PRODUCT_CODE=?";
	public static final String UPDATESTOCK ="UPDATE PRODUCT_STOCK_TBL SET PRODUCT_NAME = ?,PRODUCT_STATUS = ? WHERE PRODUCT_CODE = ?";
	public static final String SELECTPRODUCTSTATUS="SELECT PRODUCT_STATUS FROM PRODUCT_STOCK_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String SELECTPRODUCTCODE="SELECT PRODUCT_CODE FROM PRODUCT_STOCK_TBL";
	public static final String VIEW = "SELECT * FROM PRODUCT_STOCK_TBL";
	public static final String VIEWQUANTITY="SELECT QUANTITY FROM INVENTORY_TBL WHERE PRODUCTMODEL_ID=?";
	//public static final String VIEWTHRESHOLD="SELECT PRODUCTMODEL_THRESHOLD FROM PRODUCTMODEL_INFO_TBL WHERE PRODUCTMODEL_ID=?";
	public static final String SORTASCENDING="SELECT * FROM PRODUCT_STOCK_TBL ORDER BY PRODUCT_CODE";
	public static final String SORTDESCENDING="SELECT * FROM PRODUCT_STOCK_TBL ORDER BY PRODUCT_CODE DESC";


	
	
}
