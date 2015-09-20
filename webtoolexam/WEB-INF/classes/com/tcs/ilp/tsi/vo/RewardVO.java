package com.tcs.ilp.tsi.vo;

import java.sql.Date;

public class RewardVO {
	public int rewardID;
	public int retailerID;
	public int packageID;
	public Date rewardDate;
	public String rewardStatus;
	public int getRewardID() {
		return rewardID;
	}
	public void setRewardID(int rewardID) {
		this.rewardID = rewardID;
	}
	public int getRetailerID() {
		return retailerID;
	}
	public void setRetailerID(int retailerID) {
		this.retailerID = retailerID;
	}
	public int getPackageID() {
		return packageID;
	}
	public void setPackageID(int packageID) {
		this.packageID = packageID;
	}
	public Date getRewardDate() {
		return rewardDate;
	}
	public void setRewardDate(Date rewardDate) {
		this.rewardDate = rewardDate;
	}
	public String getRewardStatus() {
		return rewardStatus;
	}
	public void setRewardStatus(String rewardStatus) {
		this.rewardStatus = rewardStatus;
	}
}
