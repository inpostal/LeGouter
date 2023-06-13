package com.group.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// implements java.io.Serializable

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupProductVO{

	private Integer groupProductId;
	private String groupProductName;
	private String groupProductContent;
	private Integer groupProductPrice;
	private String groupProductStardate;
	private String groupProductEnddate;
	private Integer groupProductStatus;
	
	public Integer getGroupProductId() {
		return groupProductId;
	}
	public void setGroupProductId(Integer groupProductId) {
		this.groupProductId = groupProductId;
	}
	public String getGroupProductName() {
		return groupProductName;
	}
	public void setGroupProductName(String groupProductName) {
		this.groupProductName = groupProductName;
	}
	public String getGroupProductContent() {
		return groupProductContent;
	}
	public void setGroupProductContent(String groupProductContent) {
		this.groupProductContent = groupProductContent;
	}
	public Integer getGroupProductPrice() {
		return groupProductPrice;
	}
	public void setGroupProductPrice(Integer groupProductPrice) {
		this.groupProductPrice = groupProductPrice;
	}
	public String getGroupProductStardate() {
		return groupProductStardate;
	}
	public void setGroupProductStardate(String groupProductStardate) {
		this.groupProductStardate = groupProductStardate;
	}
	public String getGroupProductEnddate() {
		return groupProductEnddate;
	}
	public void setGroupProductEnddate(String groupProductEnddate) {
		this.groupProductEnddate = groupProductEnddate;
	}
	public Integer getGroupProductStatus() {
		return groupProductStatus;
	}
	public void setGroupProductStatus(Integer groupProductStatus) {
		this.groupProductStatus = groupProductStatus;
	}
	@Override
	public String toString() {
		return "GroupProductVO [groupProductId=" + groupProductId + ", groupProductName=" + groupProductName
				+ ", groupProductContent=" + groupProductContent + ", groupProductPrice=" + groupProductPrice
				+ ", groupProductStardate=" + groupProductStardate + ", groupProductTimegroupProductEnddate="
				+ groupProductEnddate + ", groupProductStatus=" + groupProductStatus + "]";
	}
	
}
